package zeta.android.thunderbird.interceptors;

import java.io.IOException;

import javax.annotation.ParametersAreNonnullByDefault;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import zeta.android.thunderbird.providers.SessionTokenProvider;
import zeta.android.utils.lang.StringUtils;

import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_ACCEPT;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_ACCEPT_LANGUAGE;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_CONTENT_TYPE;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_SXID;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_XID;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_XSRF;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.VALUE.VALUE_ACCEPT;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.VALUE.VALUE_ACCEPT_LANGUAGE;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.VALUE.VALUE_CONTENT_TYPE;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.VALUE.VALUE_ZERO_EMPTY;

@ParametersAreNonnullByDefault
public class IdpApiHeadersInterceptor implements Interceptor {

    private SessionTokenProvider sessionTokenProvider;

    public IdpApiHeadersInterceptor(SessionTokenProvider sessionTokenProvider) {
        this.sessionTokenProvider = sessionTokenProvider;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder.header(KEY_ACCEPT, VALUE_ACCEPT);
        requestBuilder.header(KEY_CONTENT_TYPE, VALUE_CONTENT_TYPE);
        requestBuilder.header(KEY_ACCEPT_LANGUAGE, VALUE_ACCEPT_LANGUAGE);

        // Set XID -- Session ID
        //This comes as a meta response` token`
        final String sessionIdOrXid = sessionTokenProvider.getSessionIdOrXid();
        if (StringUtils.isNotNullOrEmpty(sessionIdOrXid)
                && !sessionIdOrXid.equalsIgnoreCase(VALUE_ZERO_EMPTY)) {
            requestBuilder.header(KEY_XID, sessionIdOrXid);
        }

        // SXID == AT,  This info only comes in header.
        // Set SXID if request is https -- Secure session ID
        final String secureSessionIdOrSxid = sessionTokenProvider.getSecureSessionIdOrSxid();
        if (request.isHttps() && StringUtils.isNotNullOrEmpty(secureSessionIdOrSxid)
                && !secureSessionIdOrSxid.equalsIgnoreCase(VALUE_ZERO_EMPTY)) {
            requestBuilder.header(KEY_SXID, secureSessionIdOrSxid);
        }

        // Set XSRF -- CSRF token
        //This comes as a meta response` xsrfToken`
        final String csrfTokenOrXsrf = sessionTokenProvider.getCsrfTokenOrXsrf();
        if (StringUtils.isNotNullOrEmpty(csrfTokenOrXsrf)
                && !csrfTokenOrXsrf.equalsIgnoreCase(VALUE_ZERO_EMPTY)) {
            requestBuilder.header(KEY_XSRF, csrfTokenOrXsrf);
        }

        return chain.proceed(request);
    }
}
