package zeta.android.thunderbird.models.transformers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCardsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationComponentsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCrossLinksResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationInfoResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationMoreInfoResponse;
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
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3SocialTitle;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3StyleNote;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ActionType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3CompleteLookComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3CrossLinksComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3LikersLazyComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3MoreInfoComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3RelatedPdpLazyComponent;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ActionProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3CrossLinksProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3MoreInfoProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3RelatedProperty;
import zeta.android.thunderbird.models.utils.PdpV3CardTypeUtil;
import zeta.android.thunderbird.models.utils.PdpV3ComponentTypeUtil;
import zeta.android.thunderbird.models.utils.PdpV3ProductComponentTypeUtil;
import zeta.android.utils.lang.CollectionUtils;
import zeta.android.utils.lang.StringUtils;

import static zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType.BRAND;
import static zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType.MORE_INFO_CARD;
import static zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType.PRODUCT;
import static zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType.RELATED;
import static zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType.SERVICEABILITY;
import static zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType.SOCIAL;

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

    //region PdpV3SocialCard transformer methods

    private PdpV3SocialCard transformSocialCard(PdpComponentizationCardsResponse socialCard) {

        @PdpV3ComponentType
        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
        PdpV3LikersLazyComponent pdpV3LikersLazyComponent = null;
        PdpV3CompleteLookComponent pdpV3CompleteLookComponent = null;

        if(CollectionUtils.hasElements(socialCard.componentsList)){
            final int componentListSize = socialCard.componentsList.size();
            for(int indexPos = 0; indexPos < componentListSize; indexPos++){
                PdpComponentizationComponentsResponse pdpComponentizationComponentsResponse
                        = socialCard.componentsList.get(indexPos);
                @PdpV3ComponentType
                final String componentType = pdpComponentizationComponentsResponse.type;
                switch (componentType){
                    case PdpV3ComponentType.LIKERS_LAZY:
                        transformPdpV3LikersLazyComponent(pdpComponentizationComponentsResponse.props.actionType,
                                pdpComponentizationComponentsResponse.props.action,
                                pdpComponentizationComponentsResponse.args.title);
                        componentPositionIndex.put(PdpV3ComponentTypeUtil.from(componentType), indexPos);
                        break;
                    case PdpV3ComponentType.COMPLETE_LOOK:
                        transformPdpV3CompleteLookComponent(pdpComponentizationComponentsResponse.props.styleNote,
                                pdpComponentizationComponentsResponse.args.title);
                        componentPositionIndex.put(PdpV3ComponentTypeUtil.from(componentType), indexPos);
                        break;
                }
            }
        }

        return PdpV3SocialCard.create()
                .setComponentPositionsIndex(componentPositionIndex)
                .setPdpV3LikersLazyComponent(pdpV3LikersLazyComponent)
                .setPdpV3CompleteLookComponent(pdpV3CompleteLookComponent)
                .build();
    }

    private PdpV3LikersLazyComponent transformPdpV3LikersLazyComponent(String actionType,
                                                                       String action, String title){

        @PdpV3ActionType String pdpV3ActionType = getPdpV3ActionType(actionType);
        PdpV3SocialTitle pdpV3SocialTitle = null;
        if(StringUtils.isNotNullOrEmpty(title)){
            pdpV3SocialTitle = PdpV3SocialTitle.create(title);
        }

        return PdpV3LikersLazyComponent.create()
                .setPdpV3ActionProperty(PdpV3ActionProperty.create()
                        .setAction(action)
                        .setActionType(pdpV3ActionType).build())
                .setLikersTitle(pdpV3SocialTitle)
                .build();
    }

    private PdpV3CompleteLookComponent transformPdpV3CompleteLookComponent(String styleNote, String title){

        PdpV3SocialTitle pdpV3SocialTitle = null;
        PdpV3StyleNote pdpV3StyleNote = null;
        if(StringUtils.isNotNullOrEmpty(title)){
            pdpV3SocialTitle = PdpV3SocialTitle.create(title);
        }
        if(StringUtils.isNotNullOrEmpty(styleNote)){
            pdpV3StyleNote = PdpV3StyleNote.create(title);
        }

        return PdpV3CompleteLookComponent.create()
                .setPdpV3StyleNote(pdpV3StyleNote)
                .setCompleteLookTitle(pdpV3SocialTitle)
                .build();
    }

    //endregion


    //region PdpV3RelatedCard transformer methods

    private PdpV3RelatedCard transformRelatedCard(PdpComponentizationCardsResponse relatedCard) {

        @PdpV3ComponentType
        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
        PdpV3RelatedPdpLazyComponent pdpV3RelatedPdpLazyComponent = null;
        PdpV3CrossLinksComponent pdpV3CrossLinksComponent = null;
        if(CollectionUtils.hasElements(relatedCard.componentsList)){
            final int componentListSize = relatedCard.componentsList.size();
            for(int indexPos = 0; indexPos < componentListSize; indexPos++){
                @PdpV3ComponentType
                final String componentType = relatedCard.componentsList.get(indexPos).type;
                switch (componentType){
                    case PdpV3ComponentType.RELATED_PDP_LAZY:
                        pdpV3RelatedPdpLazyComponent = transformPdpV3RelatedPdpLazyComponent(
                                relatedCard.componentsList.get(indexPos).props.actionType,
                                relatedCard.componentsList.get(indexPos).props.action);
                        componentPositionIndex.put(PdpV3ProductComponentTypeUtil.from(componentType),
                                indexPos);
                        break;
                    case PdpV3ComponentType.CROSS_LINKS:
                        pdpV3CrossLinksComponent = transformPdpV3PdpV3CrossLinksComponent(
                                relatedCard.componentsList.get(indexPos).props.crossLinksList);
                        componentPositionIndex.put(PdpV3ProductComponentTypeUtil.from(componentType),
                                indexPos);
                        break;
                }
            }
        }

        return PdpV3RelatedCard.create()
                .setComponentPositionsIndex(componentPositionIndex)
                .setPdpV3RelatedPdpLazyComponent(pdpV3RelatedPdpLazyComponent)
                .setPdpV3CrossLinksComponent(pdpV3CrossLinksComponent)
                .build();
    }

    private PdpV3RelatedPdpLazyComponent transformPdpV3RelatedPdpLazyComponent(String actionType,
                                                                               String action){

        @PdpV3ActionType String pdpV3ActionType = getPdpV3ActionType(actionType);

        return PdpV3RelatedPdpLazyComponent.create()
                .setPdpV3ActionProperty(PdpV3ActionProperty.create()
                        .setAction(action)
                        .setActionType(pdpV3ActionType)
                        .build())
                .build();
    }

    private PdpV3CrossLinksComponent transformPdpV3PdpV3CrossLinksComponent
            (List<PdpComponentizationCrossLinksResponse> crossLinksList){

        List<PdpV3CrossLinksProperty> crossLinksPropertyList = new ArrayList<>(0);
        for(PdpComponentizationCrossLinksResponse pdpComponentizationCrossLinksResponse :
                crossLinksList){
            crossLinksPropertyList.add(PdpV3CrossLinksProperty.create()
                    .setTitle(pdpComponentizationCrossLinksResponse.title)
                    .setUrl(pdpComponentizationCrossLinksResponse.url)
                    .build());
        }

        return PdpV3CrossLinksComponent.create()
                .setPdpV3CrossLinksPropertyList(crossLinksPropertyList)
                .build();
    }

    //endregion


    //region PDPV3MoreInfoCard transformer methods

    private PdpV3MoreInfoCard transformMoreInfoCard(PdpComponentizationCardsResponse moreInfoCard) {

        @PdpV3ComponentType
        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
        PdpV3MoreInfoComponent pdpV3MoreInfoComponent = null;
        if(CollectionUtils.hasElements(moreInfoCard.componentsList)){
            final int moreInfoIndexPos = 0;
            @PdpV3ComponentType
            final String componentType = moreInfoCard.componentsList.get(moreInfoIndexPos).type;
            switch (componentType) {
                case PdpV3ComponentType.MORE_INFO:
                    pdpV3MoreInfoComponent = transformPdpV3MoreInfoComponent(moreInfoCard.componentsList.
                            get(moreInfoIndexPos).props.moreInfoList);
                    @PdpV3ComponentType
                    String pdpV3ComponentType = PdpV3ProductComponentTypeUtil.from(componentType);
                    componentPositionIndex.put(pdpV3ComponentType, moreInfoIndexPos);
                    break;
            }
        }

        return PdpV3MoreInfoCard.create()
                .setComponentPositionsIndex(componentPositionIndex)
                .setPdpV3MoreInfoComponent(pdpV3MoreInfoComponent)
                .build();
    }

    private PdpV3MoreInfoComponent transformPdpV3MoreInfoComponent(List<PdpComponentizationMoreInfoResponse>
                                                                           moreInfoList){

        List<PdpV3MoreInfoProperty> pdpV3MoreInfoPropertyList = new ArrayList<>(0);
        for (PdpComponentizationMoreInfoResponse pdpComponentizationMoreInfoResponse : moreInfoList) {
            String action = null;
            if (pdpComponentizationMoreInfoResponse.action != null) {
                action = pdpComponentizationMoreInfoResponse.action.toString();
            }
            pdpV3MoreInfoPropertyList.add(PdpV3MoreInfoProperty.create()
                    .setAction(action)
                    .setDescription(pdpComponentizationMoreInfoResponse.description)
                    .setTitle(pdpComponentizationMoreInfoResponse.title)
                    .build());
        }

        return PdpV3MoreInfoComponent.create()
                .setPdpV3MoreInfoPropertyList(pdpV3MoreInfoPropertyList)
                .build();
    }

    //endregion


    //region Common helper methods

    @PdpV3ActionType
    private String getPdpV3ActionType(String actionType){
        @PdpV3ActionType String pdpV3ActionType = PdpV3ActionType.UNKNOWN ;
        if(StringUtils.isNotNullOrEmpty(actionType)){
            switch (actionType) {
                case PdpV3ActionType.LAZY:
                    pdpV3ActionType = PdpV3ActionType.LAZY;
                    break;
                case PdpV3ActionType.LAZY_LOADED:
                    pdpV3ActionType = PdpV3ActionType.LAZY_LOADED;
                    break;
                case PdpV3ActionType.ON_DEMAND:
                    pdpV3ActionType = PdpV3ActionType.ON_DEMAND;
                    break;
                case PdpV3ActionType.UNKNOWN:
                    pdpV3ActionType = PdpV3ActionType.UNKNOWN;
                    break;
            }
        }
        return pdpV3ActionType;
    }

    //endregion

}