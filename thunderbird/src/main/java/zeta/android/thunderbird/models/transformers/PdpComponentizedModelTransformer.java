package zeta.android.thunderbird.models.transformers;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCardsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationInfoResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.thunderbird.models.products.common.ProductTitle;
import zeta.android.thunderbird.models.products.pdpv3.PdpComponentizationModel;

@ParametersAreNonnullByDefault
public class PdpComponentizedModelTransformer implements ITransformer<PdpComponentizationResponse, PdpComponentizationModel> {
    @Override
    public PdpComponentizationModel transform(PdpComponentizationResponse response) {

        PdpComponentizationInfoResponse info = response.info;
        List<PdpComponentizationCardsResponse> cardsList = response.cardsList;

        //region info
        ProductId productId = ProductId.create(info.id);
        ProductTitle title = ProductTitle.create(info.name);
        //endregion

        return PdpComponentizationModel.create()
                .setProductId(productId)
                .setProductTitle(title)
                .build();
    }
}