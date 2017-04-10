package zeta.android.thunderbird.managers;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.github.zetaapps.either.Either;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import rx.Observable;
import zeta.android.thunderbird.api.apify.MyntraApify;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.ComponentizationResponse;
import zeta.android.thunderbird.managers.params.ProductDetailsParams;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.common.Managers;
import zeta.android.thunderbird.models.pdp.PdpModel;
import zeta.android.thunderbird.models.pdp.errors.PdpException;

@ParametersAreNonnullByDefault
public class ApifyManager {

    private final MyntraApify apify;
    private final ITransformer<ComponentizationResponse, PdpModel> mProductsTransformer;

    @Inject
    public ApifyManager(MyntraApify myntraApify, ITransformer<ComponentizationResponse, PdpModel> transformer) {
        apify = myntraApify;
        mProductsTransformer = transformer;
    }

    @RxLogObservable
    public Observable<Either<PdpModel, PdpException>> getComponentizedProductDetails(ProductDetailsParams productDetailsParams) {
        return apify.getProductDetailsComponentizedResponse(productDetailsParams.getProductId().getRawProductId(), 1)
                .map(response -> Managers.buildOneOf(
                        response,
                        PdpException::new,
                        mProductsTransformer));
    }

}
