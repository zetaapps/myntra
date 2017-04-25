package zeta.android.thunderbird.managers;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.github.zetaapps.either.Either;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import rx.Observable;
import zeta.android.thunderbird.api.apify.MyntraApify;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3Response;
import zeta.android.thunderbird.managers.params.ProductDetailsParams;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.common.Managers;
import zeta.android.thunderbird.models.products.pdp.PdpModel;
import zeta.android.thunderbird.models.products.pdp.errors.PdpException;
import zeta.android.thunderbird.models.products.pdpv3.PdpComponentizationModel;

@ParametersAreNonnullByDefault
public class PdpV3Manager {

    private final MyntraApify apify;
    private final ITransformer<PdpV3Response, PdpModel> mPdpV3Transformer;
    private final ITransformer<PdpComponentizationResponse, PdpComponentizationModel> mProductsTransformer;

    @Inject
    public PdpV3Manager(MyntraApify myntraApify,
                        ITransformer<PdpV3Response, PdpModel> pdpV3Transformer,
                        ITransformer<PdpComponentizationResponse, PdpComponentizationModel> componentizedTransformer) {
        apify = myntraApify;
        mPdpV3Transformer = pdpV3Transformer;
        mProductsTransformer = componentizedTransformer;
    }

    @RxLogObservable
    public Observable<Either<PdpModel, PdpException>> getProductDetailsV3(ProductDetailsParams productDetailsParams) {
        return apify.getProductDetailsResponse(productDetailsParams.getProductId().getRawId())
                .map(response -> Managers.buildOneOf(
                        response,
                        PdpException::new,
                        mPdpV3Transformer));
    }

    @RxLogObservable
    public Observable<Either<PdpComponentizationModel, PdpException>> getComponentizedProductDetailsV3(
            ProductDetailsParams productDetailsParams) {
        return apify.getProductDetailsComponentizedResponse(productDetailsParams.getProductId().getRawId(), 1)
                .map(response -> Managers.buildOneOf(
                        response,
                        PdpException::new,
                        mProductsTransformer));
    }

}
