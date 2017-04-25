package zeta.android.thunderbird.models.transformers;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.devapi.response.pdp.PdpDataResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.pdp.PdpModel;
import zeta.android.thunderbird.models.products.common.ProductId;

@ParametersAreNonnullByDefault
public class PdpModelTransformer implements ITransformer<PdpResponse, PdpModel> {

    @Override
    public PdpModel transform(PdpResponse pdpResponse) {
        PdpDataResponse pdpDataResponse = pdpResponse.pdpDataResponse;

        return PdpModel.create()
                .setProductId(ProductId.create(pdpDataResponse.productId))
                .setProductTitle(pdpDataResponse.productDisplayName)
                .setDefaultImageUrl(pdpDataResponse.styleImages.defaultImages.imageURL)
                .build();
    }
}