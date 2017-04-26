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
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType;
import zeta.android.thunderbird.models.utils.PdpV3CardTypeUtil;

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

        //region card
        for (int i = 0; i < cardsList.size(); i++) {
            final PdpComponentizationCardsResponse cardsResponse = cardsList.get(i);
            @PdpV3CardType
            final String cardType = PdpV3CardTypeUtil.from(cardsResponse.type);
            switch (cardType) {
                case PdpV3CardType.PRODUCT:
                    transformProductCard();
                    break;
                case PdpV3CardType.BRAND:
                    transformBrandCard();
                    break;
                case PdpV3CardType.SERVICEABILITY:
                    transformServiceabilityCard();
                    break;
                case PdpV3CardType.SOCIAL:
                    transformSocialCard();
                    break;
                case PdpV3CardType.RELATED:
                    transformRelatedCard();
                    break;
                case PdpV3CardType.MORE_INFO_CARD:
                    transformMoreInfoCard();
                    break;
                default:
                    break;
            }
        }
        //endregion

        return PdpComponentizationModel.create()
                .setProductId(productId)
                .setProductTitle(title)
                .build();
    }

    private void transformProductCard() {
        //TODO::add argument and return type
    }

    private void transformBrandCard() {
        //TODO::add argument and return type
    }

    private void transformServiceabilityCard() {
        //TODO::add argument and return type
    }

    private void transformSocialCard() {
        //TODO::add argument and return type
    }

    private void transformRelatedCard() {
        //TODO::add argument and return type
    }

    private void transformMoreInfoCard() {
        //TODO::add argument and return type
    }

}