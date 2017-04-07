package zeta.android.thunderbird.managers;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.github.zetaapps.either.Either;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import rx.Observable;
import zeta.android.thunderbird.api.apify.MyntraApify;
import zeta.android.thunderbird.api.apify.response.pdp.PdpV3Response;
import zeta.android.thunderbird.managers.params.ProductDetailsParams;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.common.Managers;
import zeta.android.thunderbird.models.pdp.PdpModel;
import zeta.android.thunderbird.models.pdp.errors.PdpException;

@ParametersAreNonnullByDefault
public class ApifyManager {

    private final MyntraApify apify;
    private final ITransformer<PdpV3Response, PdpModel> mProductsTransformer;

    @Inject
    public ApifyManager(MyntraApify devApi, ITransformer<PdpV3Response, PdpModel> transformer) {
        apify = devApi;
        mProductsTransformer = transformer;
    }

    @RxLogObservable
    public Observable<Either<PdpModel, PdpException>> getProductDetails(ProductDetailsParams productDetailsParams) {
        return apify.getProductDetailsV3Response(productDetailsParams.getProductId().getRawProductId(), 1)
                .map(response -> Managers.buildOneOf(
                        response,
                        PdpException::new,
                        mProductsTransformer));
    }

}
