package zeta.android.thunderbird.managers;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.github.zetaapps.either.Either;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import okhttp3.Headers;
import retrofit2.Response;
import rx.Observable;
import timber.log.Timber;
import zeta.android.thunderbird.api.idpapi.IdpDevApi;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.thunderbird.api.idpapi.response.params.IdpMyntraLoginParams;
import zeta.android.thunderbird.api.idpapi.response.params.IdpSocialLoginParams;
import zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst;
import zeta.android.thunderbird.managers.params.LoginParams;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.common.Managers;
import zeta.android.thunderbird.models.session.AccessToken;
import zeta.android.thunderbird.models.session.LoginType;
import zeta.android.thunderbird.models.session.SessionModel;
import zeta.android.thunderbird.models.session.UserId;
import zeta.android.thunderbird.models.session.UserPassword;
import zeta.android.thunderbird.models.session.errors.SessionException;
import zeta.android.thunderbird.providers.SessionTokenProvider;
import zeta.android.utils.lang.StringUtils;

import static zeta.android.thunderbird.models.session.LoginType.MYNTRA;

@ParametersAreNonnullByDefault
public class SessionManager {

    private final IdpDevApi mIdpDevAPi;
    private final SessionTokenProvider mSessionTokenProvider;
    private final ITransformer<IdpTokenResponse, SessionModel> mSessionTransformer;

    @Inject
    public SessionManager(IdpDevApi idpDevAPi,
                          SessionTokenProvider sessionTokenProvider,
                          ITransformer<IdpTokenResponse, SessionModel> transformer) {
        mIdpDevAPi = idpDevAPi;
        mSessionTokenProvider = sessionTokenProvider;
        mSessionTransformer = transformer;
    }

    @RxLogObservable
    public Observable<Either<SessionModel, SessionException>> getSessionLoginDetails(LoginParams loginParams)
            throws IllegalArgumentException {
        @LoginType
        final String loginType = loginParams.getLoginType();

        switch (loginType) {
            case LoginType.FACEBOOK:
            case LoginType.GOOGLE:
                AccessToken accessToken = loginParams.getAccessToken();
                if (accessToken == null) {
                    throw new IllegalArgumentException("Access Token cannot be null for social login");
                }
                final IdpSocialLoginParams params = new IdpSocialLoginParams(loginType,
                        accessToken.getRawId());

                return mIdpDevAPi.getLoginInfo(params)
                        .map(this::processHeader)
                        .map(response -> Managers.buildOneOf(
                                response,
                                SessionException::new,
                                mSessionTransformer));

            case MYNTRA:
                final UserId userId = loginParams.getUserId();
                final UserPassword userPassword = loginParams.getUserPassword();
                if (userId == null || userPassword == null) {
                    throw new IllegalArgumentException("User id or Password cannot be null");
                }
                final String userIdRaw = userId.getRawId();
                final String passwordRaw = userPassword.getRawId();
                if (StringUtils.isNullOrEmpty(userIdRaw) || StringUtils.isNullOrEmpty(passwordRaw)) {
                    throw new IllegalArgumentException("User id or Password cannot be empty or null");
                }
                final IdpMyntraLoginParams myntraLoginParams = new IdpMyntraLoginParams(LoginType.MYNTRA, userIdRaw, passwordRaw);

                return mIdpDevAPi.getLoginInfo(myntraLoginParams)
                        .map(this::processHeader)
                        .map(response -> Managers.buildOneOf(
                                response,
                                SessionException::new,
                                mSessionTransformer));

            case LoginType.PHONE_NUMBER:
                throw new IllegalArgumentException("Phone number login is not supported yet");
        }

        Timber.wtf("This case should never happen, We need to define LoginType to reach here");
        throw new IllegalArgumentException("LoginType is unknown");
    }

    /**
     * Helper method to update the headers within token provider.
     *
     * @param response :  data response
     * @return : return the data response as is for Rx chaining
     */
    private Response<IdpTokenResponse> processHeader(Response<IdpTokenResponse> response) {
        final Headers headers = response.headers();
        final IdpTokenResponse idpTokenResponse = response.body();
        if (idpTokenResponse == null) {
            return response;
        }

        //As per my understanding only sxid comes from header.
        final String sxid = headers.get(MyntraHttpHeadersInterceptorConst.KEY.KEY_SXID);
        String token = idpTokenResponse.profileMeta.token;
        String xsrfToken = idpTokenResponse.profileMeta.xsrfToken;

        //Secure session id is updated from header
        if (!mSessionTokenProvider.getSecureSessionIdOrSxid().equalsIgnoreCase(sxid) &&
                StringUtils.isNotNullOrEmpty(sxid)) {
            mSessionTokenProvider.setSecureSessionIdOrSxid(sxid);
        }

        //Session id is updated from the response
        if (!mSessionTokenProvider.getSessionIdOrXid().equalsIgnoreCase(token) &&
                StringUtils.isNotNullOrEmpty(token)) {
            mSessionTokenProvider.setSessionIdOrXid(token);
        }

        //CSRF token is updated from the response
        if (!mSessionTokenProvider.getCsrfTokenOrXsrf().equalsIgnoreCase(xsrfToken) &&
                StringUtils.isNotNullOrEmpty(xsrfToken)) {
            mSessionTokenProvider.setCsrfTokenOrXsrf(xsrfToken);
        }
        return response;
    }

}
