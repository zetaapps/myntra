package zeta.android.thunderbird.models.transformers;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCardsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationComponentsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationInfoResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.thunderbird.models.products.common.ProductTitle;
import zeta.android.thunderbird.models.products.pdpv3.PdpComponentizationModel;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3BrandCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3MoreInfoCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3ProductCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3RelatedCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3ServiceabilityCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3SocialCard;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3ComponentType;
import zeta.android.thunderbird.models.utils.PdpV3CardTypeUtil;
import zeta.android.thunderbird.models.utils.PdpV3ProductComponentTypeUtil;

import static zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType.BRAND;
import static zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType.MORE_INFO_CARD;
import static zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType.PRODUCT;
import static zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType.RELATED;
import static zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType.SERVICEABILITY;
import static zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType.SOCIAL;

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

        PdpV3BrandCard brandCard = null;
        PdpV3SocialCard socialCard = null;
        PdpV3RelatedCard relatedCard = null;
        PdpV3ProductCard productCard = null;
        PdpV3MoreInfoCard moreInfoCard = null;
        PdpV3ServiceabilityCard serviceabilityCard = null;
        @PdpV3CardType
        LinkedHashMap<String, Integer> cardPositionIndex = new LinkedHashMap<>(0);

        //region card
        if (cardsList != null) {
            final int size = cardsList.size();
            for (int indexPos = 0; indexPos < size; indexPos++) {
                final PdpComponentizationCardsResponse cardsResponse = cardsList.get(indexPos);

                @PdpV3CardType
                final String cardType = PdpV3CardTypeUtil.from(cardsResponse.type);
                //Maintain the index of the card
                cardPositionIndex.put(cardType, indexPos);

                switch (cardType) {
                    case PRODUCT:
                        productCard = transformProductCard(cardsResponse);
                        break;
                    case BRAND:
                        brandCard = transformBrandCard(cardsResponse);
                        break;
                    case SERVICEABILITY:
                        serviceabilityCard = transformServiceabilityCard(cardsResponse);
                        break;
                    case SOCIAL:
                        socialCard = transformSocialCard(cardsResponse);
                        break;
                    case RELATED:
                        relatedCard = transformRelatedCard(cardsResponse);
                        break;
                    case MORE_INFO_CARD:
                        moreInfoCard = transformMoreInfoCard(cardsResponse);
                        break;
                    default:
                        break;
                }
            }
        }
        //endregion
        return PdpComponentizationModel.create()
                .setProductId(productId)
                .setProductTitle(title)
                .setBrandCard(brandCard)
                .setSocialCard(socialCard)
                .setProductCard(productCard)
                .setRelatedCard(relatedCard)
                .setMoreInfoCard(moreInfoCard)
                .setCardPositionsIndex(cardPositionIndex)
                .setServiceabilityCard(serviceabilityCard)
                .build();
    }

    private PdpV3ProductCard transformProductCard(PdpComponentizationCardsResponse productCard) {
        @PdpV3ComponentType
        LinkedHashMap<String, Integer> componentIndex = new LinkedHashMap<>(0);
        List<PdpComponentizationComponentsResponse> componentsList = productCard.componentsList;
        if (componentsList != null) {
            final int size = componentsList.size();
            for (int indexPos = 0; indexPos < size; indexPos++) {
                PdpComponentizationComponentsResponse componentsResponse = componentsList.get(indexPos);

                //Maintain the index of the component
                @PdpV3ComponentType
                String componentType = PdpV3ProductComponentTypeUtil.from(componentsResponse.type);
                componentIndex.put(componentType, indexPos);
            }
        }

        return PdpV3ProductCard.create()
                .setPdpV3CardType(PdpV3CardType.PRODUCT)
                .setComponentPositionsIndex(componentIndex)
                .build();
    }

    private PdpV3BrandCard transformBrandCard(PdpComponentizationCardsResponse brandCard) {
        return PdpV3BrandCard.create()
                .build();
    }

    private PdpV3ServiceabilityCard transformServiceabilityCard(PdpComponentizationCardsResponse serviceabilityCard) {
        return PdpV3ServiceabilityCard.create()
                .build();
    }

    private PdpV3SocialCard transformSocialCard(PdpComponentizationCardsResponse socialCard) {
        return PdpV3SocialCard.create()
                .build();
    }

    private PdpV3RelatedCard transformRelatedCard(PdpComponentizationCardsResponse relatedCard) {
        return PdpV3RelatedCard.create()
                .build();
    }

    private PdpV3MoreInfoCard transformMoreInfoCard(PdpComponentizationCardsResponse moreInfoCard) {
        return PdpV3MoreInfoCard.create()
                .build();
    }

}