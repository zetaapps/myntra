package zeta.android.thunderbird.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import zeta.android.thunderbird.api.apify.MyntraApify;
import zeta.android.thunderbird.api.devapi.MyntraDevApi;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.managers.ProductsManager;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.pdp.PdpModel;
import zeta.android.thunderbird.models.transformers.PdpModelTransformer;
import zeta.android.thunderbird.qualifiers.retrofit.RetrofitApify;
import zeta.android.thunderbird.qualifiers.retrofit.RetrofitDevApi;

@Module
public class ProductsModule {

    @Provides
    MyntraApify providesMyntraApify(@RetrofitApify Retrofit retrofit) {
        return retrofit.create(MyntraApify.class);
    }

    @Provides
    MyntraDevApi providesMyntraDevApi(@RetrofitDevApi Retrofit retrofit) {
        return retrofit.create(MyntraDevApi.class);
    }

    @Provides
    ITransformer<PdpResponse, PdpModel> providesProductsTransformer() {
        return new PdpModelTransformer();
    }

    @Provides
    ProductsManager providesProductManager(MyntraDevApi devApi,
                                           ITransformer<PdpResponse, PdpModel> transformer) {
        return new ProductsManager(devApi, transformer);
    }

}
