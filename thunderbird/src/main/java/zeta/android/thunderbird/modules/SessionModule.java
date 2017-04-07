package zeta.android.thunderbird.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import zeta.android.thunderbird.api.idpapi.IdpDevApi;
import zeta.android.thunderbird.api.idpapi.response.idp.IdpTokenResponse;
import zeta.android.thunderbird.managers.SessionManager;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.session.SessionModel;
import zeta.android.thunderbird.models.transformers.SessionModelTransformer;
import zeta.android.thunderbird.providers.SessionTokenProvider;
import zeta.android.thunderbird.qualifiers.retrofit.RetrofitIdpApi;

@Module
public class SessionModule {

    @Provides
    IdpDevApi providesIdpDevApi(@RetrofitIdpApi Retrofit retrofit) {
        return retrofit.create(IdpDevApi.class);
    }

    @Provides
    ITransformer<IdpTokenResponse, SessionModel> providesProductsTransformer() {
        return new SessionModelTransformer();
    }

    @Provides
    SessionManager providesSessionManager(IdpDevApi idpDevApi,
                                          SessionTokenProvider sessionTokenProvider,
                                          ITransformer<IdpTokenResponse, SessionModel> transformer) {
        return new SessionManager(idpDevApi, sessionTokenProvider, transformer);
    }

}
