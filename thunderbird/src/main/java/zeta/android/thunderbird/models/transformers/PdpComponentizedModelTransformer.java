package zeta.android.thunderbird.models.transformers;


import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3DescriptorResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3PriceResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3SizeResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCardsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationComponentsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationInfoResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationInfoTextResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationLikesResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationMediumResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationPropsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationRelatedResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationSizeRecoLazyResponse;
import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.common.ProductBrand;
import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.thunderbird.models.products.common.ProductSizeVariantId;
import zeta.android.thunderbird.models.products.common.ProductTitle;
import zeta.android.thunderbird.models.products.pdpv3.PdpComponentizationModel;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3BrandCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3MoreInfoCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3ProductCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3RelatedCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3ServiceabilityCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3SocialCard;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3WareHouse;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ActionType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ProductSupplyType;
import zeta.android.thunderbird.models.products.pdpv3.common.property.PdpV3SizeProperty;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3BestPriceOnDemandComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ButtonsComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ImageComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3InfoComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3SizeSelectorComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3VatInfoComponent;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ActionProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3DescriptorsProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3DiscountProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3InfoTextProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3LikeProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3MediaProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3PriceProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3RelatedProperty;
import zeta.android.thunderbird.models.utils.GenderTypeUtil;
import zeta.android.thunderbird.models.utils.PdpV3CardTypeUtil;
import zeta.android.thunderbird.models.utils.PdpV3ProductComponentTypeUtil;
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
        @GenderType
        String genderType = GenderTypeUtil.from(response.info.gender);
        ProductBrand productBrand = response.info.brand != null ? ProductBrand.create(response.info.brand) : null;
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
                        //brandCard = transformBrandCard(cardsResponse);
                        break;
                    case SERVICEABILITY:
                        //serviceabilityCard = transformServiceabilityCard(cardsResponse);
                        break;
                    case SOCIAL:
                        //socialCard = transformSocialCard(cardsResponse);
                        break;
                    case RELATED:
                        //relatedCard = transformRelatedCard(cardsResponse);
                        break;
                    case MORE_INFO_CARD:
                        //moreInfoCard = transformMoreInfoCard(cardsResponse);
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
                .setGender(genderType)
                .setProductBrand(productBrand)
                .setBrandCard(brandCard)
                .setSocialCard(socialCard)
                .setProductCard(productCard)
                .setRelatedCard(relatedCard)
                .setMoreInfoCard(moreInfoCard)
                .setCardPositionsIndex(cardPositionIndex)
                .setServiceabilityCard(serviceabilityCard)
                .build();
    }


    //region PdpV3ProductCard transformer methods
    private PdpV3ProductCard transformProductCard(PdpComponentizationCardsResponse productCard) {

        PdpV3InfoComponent pdpV3InfoComponent = null;
        PdpV3ImageComponent pdpV3ImageComponent = null;
        PdpV3VatInfoComponent pdpV3VatInfoComponent = null;
        PdpV3ButtonsComponent pdpV3ButtonsComponent = null;
        PdpV3SizeSelectorComponent pdpV3SizeSelectorComponent = null;
        PdpV3BestPriceOnDemandComponent pdpV3BestPriceOnDemandComponent = null;
        @PdpV3ComponentType
        LinkedHashMap<String, Integer> componentIndex = new LinkedHashMap<>(0);

        List<PdpComponentizationComponentsResponse> componentsList = productCard.componentsList;

        if (componentsList != null) {
            final int size = componentsList.size();
            for (int indexPos = 0; indexPos < size; indexPos++) {
                @PdpV3ComponentType
                final String componentType = productCard.componentsList.get(indexPos).type;
                PdpComponentizationComponentsResponse componentsResponse = componentsList.get(indexPos);

                componentIndex.put(PdpV3ProductComponentTypeUtil.from(componentType), indexPos);

                switch (componentType) {
                    case PdpV3ComponentType.PRODUCT_COMPONENT_IMAGE:
                        pdpV3ImageComponent = transformPdpV3ImageComponent(componentsResponse.props);
                        break;
                    case PdpV3ComponentType.PRODUCT_COMPONENT_INFO:
                        pdpV3InfoComponent = transformPdpV3InfoComponent(componentsResponse);
                        break;
                    case PdpV3ComponentType.PRODUCT_COMPONENT_VAT_INFO:
                        pdpV3VatInfoComponent = transformPdpV3VatInfoComponent(componentsResponse.props.vatInfo);
                        break;
                    case PdpV3ComponentType.PRODUCT_COMPONENT_BEST_PRICE_ONDEMAND:
                        pdpV3BestPriceOnDemandComponent = transformPdpV3BestPriceOnDemandComponent(componentsResponse);
                        break;
                    case PdpV3ComponentType.PRODUCT_COMPONENT_SIZE_SELECTOR:
                        pdpV3SizeSelectorComponent = transformPdpV3SizeSelectorComponent(componentsResponse);
                        break;
                    case PdpV3ComponentType.PRODUCT_COMPONENT_ADD_TO_CART_BUTTON:
                        //pdpV3ButtonsComponent = transformPdpV3ButtonsComponent(componentsResponse);
                        break;
                }
            }
        }

        return PdpV3ProductCard.create()
                .setComponentPositionsIndex(componentIndex)
                .setPdpV3ImageComponent(pdpV3ImageComponent)
                .setPdpV3InfoComponent(pdpV3InfoComponent)
                .setPdpV3VatInfoComponent(pdpV3VatInfoComponent)
                .setPdpV3BestPriceOnDemandComponent(pdpV3BestPriceOnDemandComponent)
                .setPdpV3SizeSelectorComponent(pdpV3SizeSelectorComponent)
                .setPdpV3ButtonsComponent(pdpV3ButtonsComponent)
                .build();
    }

    private PdpV3ImageComponent transformPdpV3ImageComponent(PdpComponentizationPropsResponse
                                                                     pdpComponentizationPropsResponse) {
        return PdpV3ImageComponent.create()
                .setImageAndVideoMediaProperty(transformPdpV3MediaPropertyList(pdpComponentizationPropsResponse.mediumList))
                .setLikeProperty(transformPdpV3LikeProperty(pdpComponentizationPropsResponse.likes))
                .setRelatedProperty(transformPdpV3RelatedProperty(pdpComponentizationPropsResponse.related))
                .setBaseColorProperty(pdpComponentizationPropsResponse.baseColour)
                .build();
    }

    @Nullable
    private List<PdpV3MediaProperty> transformPdpV3MediaPropertyList(@Nullable List<PdpComponentizationMediumResponse> pdpComponentizationMediumResponseList) {
        if (pdpComponentizationMediumResponseList == null) {
            return null;
        }
        List<PdpV3MediaProperty> pdpV3MediaPropertyList = new ArrayList<>(0);
        for (PdpComponentizationMediumResponse pdpComponentizationMediumResponse : pdpComponentizationMediumResponseList) {
            Uri mediaSource = Uri.parse(pdpComponentizationMediumResponse.src);
            pdpV3MediaPropertyList.add(PdpV3MediaProperty.create(pdpComponentizationMediumResponse.type)
                    .setSource(mediaSource)
                    .build());
        }
        return pdpV3MediaPropertyList;
    }

    @Nullable
    private PdpV3LikeProperty transformPdpV3LikeProperty(@Nullable PdpComponentizationLikesResponse pdpComponentizationLikesResponse) {
        if (pdpComponentizationLikesResponse == null) {
            return null;
        }
        return PdpV3LikeProperty.create()
                .setIsLiked(pdpComponentizationLikesResponse.isLiked)
                .setLikeAction(pdpComponentizationLikesResponse.action)
                .setLikeCount(pdpComponentizationLikesResponse.likeCount)
                .build();
    }

    @Nullable
    private PdpV3RelatedProperty transformPdpV3RelatedProperty(@Nullable PdpComponentizationRelatedResponse pdpComponentizationRelatedResponse) {
        if (pdpComponentizationRelatedResponse == null) {
            return null;
        }
        return PdpV3RelatedProperty.create()
                .setAction(pdpComponentizationRelatedResponse.action)
                .setActionType(getPdpV3ActionType(pdpComponentizationRelatedResponse.actionType))
                .setHasColors(pdpComponentizationRelatedResponse.hasColors)
                .build();
    }

    private PdpV3InfoComponent transformPdpV3InfoComponent(PdpComponentizationComponentsResponse pdpComponentizationComponentsResponse) {
        PdpComponentizationPropsResponse pdpComponentizationPropsResponse = pdpComponentizationComponentsResponse.props;
        ProductId productId = ProductId.create(pdpComponentizationPropsResponse.id);
        ProductTitle productTitle = ProductTitle.create(pdpComponentizationPropsResponse.name);
        PdpV3PriceProperty pdpV3PriceProperty = transformPdpV3PriceProperty(pdpComponentizationPropsResponse.price);
        PdpV3InfoTextProperty pdpV3InfoTextProperty = transformPdpV3InfoTextProperty(pdpComponentizationComponentsResponse.args.infoText);

        return PdpV3InfoComponent.create()
                .setProductId(productId)
                .setProductTitle(productTitle)
                .setPriceProperty(pdpV3PriceProperty)
                .setInfoTextProperty(pdpV3InfoTextProperty)
                .setPdpV3DescriptorsPropertyList(tarnsformPdpV3DescriptorsPropertyList(pdpComponentizationComponentsResponse.props.descriptorList))
                .build();

    }

    private PdpV3PriceProperty transformPdpV3PriceProperty(PdpV3PriceResponse pdpV3PriceResponse) {
        PdpV3DiscountProperty pdpV3DiscountProperty = null;
        if (pdpV3PriceResponse.discount != null) {
            pdpV3DiscountProperty = PdpV3DiscountProperty.create()
                    .setDiscountLabel(pdpV3PriceResponse.discount.label)
                    .setDescription(pdpV3PriceResponse.discount.label)
                    .setMyntraCoupon(pdpV3PriceResponse.discount.coupon == null ? null : (pdpV3PriceResponse.discount.coupon.toString()))
                    .setMyntraCrash(pdpV3PriceResponse.discount.myntCash == null ? null : (pdpV3PriceResponse.discount.myntCash.toString()))
                    .build();
        }

        return PdpV3PriceProperty.create()
                .setDiscountedPrice(pdpV3PriceResponse.discounted)
                .setMrpPrice(pdpV3PriceResponse.mrp)
                .setDiscountProperty(pdpV3DiscountProperty)
                .build();
    }

    private PdpV3InfoTextProperty transformPdpV3InfoTextProperty(PdpComponentizationInfoTextResponse pdpComponentizationInfoTextResponse) {
        return PdpV3InfoTextProperty.create()
                .setCollapsedText(pdpComponentizationInfoTextResponse.collapsed)
                .setExpandedText(pdpComponentizationInfoTextResponse.expanded)
                .build();
    }

    private List<PdpV3DescriptorsProperty> tarnsformPdpV3DescriptorsPropertyList(@Nullable List<PdpV3DescriptorResponse> pdpV3DescriptorResponseList) {
        List<PdpV3DescriptorsProperty> pdpV3DescriptorsPropertyList = null;
        if (pdpV3DescriptorResponseList != null) {
            pdpV3DescriptorsPropertyList = new ArrayList<>(0);
            for (PdpV3DescriptorResponse pdpV3DescriptorResponse : pdpV3DescriptorResponseList) {
                pdpV3DescriptorsPropertyList.add(PdpV3DescriptorsProperty.create()
                        .setTitle(pdpV3DescriptorResponse.title)
                        .setDescription(pdpV3DescriptorResponse.description)
                        .build());
            }
        }
        return pdpV3DescriptorsPropertyList;
    }

    @Nullable
    private PdpV3VatInfoComponent transformPdpV3VatInfoComponent(@Nullable String vatInfoText) {
        if (vatInfoText == null) {
            return null;
        }
        return PdpV3VatInfoComponent.create()
                .setPdpV3VatInfo(vatInfoText)
                .build();
    }

    private PdpV3BestPriceOnDemandComponent transformPdpV3BestPriceOnDemandComponent(PdpComponentizationComponentsResponse pdpComponentizationComponentsResponse) {
        @PdpV3ActionType String pdpV3ActionType = getPdpV3ActionType(pdpComponentizationComponentsResponse.props.actionType);
        String initialText = pdpComponentizationComponentsResponse.args.text == null ? null : pdpComponentizationComponentsResponse.args.text.initial;

        return PdpV3BestPriceOnDemandComponent.create()
                .setActionType(pdpV3ActionType)
                .setAction(pdpComponentizationComponentsResponse.props.action)
                .setInitialText(initialText)
                .build();
    }

    private PdpV3SizeSelectorComponent transformPdpV3SizeSelectorComponent(PdpComponentizationComponentsResponse pdpComponentizationComponentsResponse) {
        PdpV3ActionProperty pdpV3ActionProperty = transformPdpV3ActionProperty(pdpComponentizationComponentsResponse.props.sizeRecoLazy);
        List<PdpV3SizeProperty> pdpV3SizePropertyList = transformPdpV3SizeProperty(pdpComponentizationComponentsResponse.props.sizeList);
        return PdpV3SizeSelectorComponent.create()
                .setIsSbpEnabled(pdpComponentizationComponentsResponse.props.sbpEnabled)
                .setPdpV3SizePropertyList(pdpV3SizePropertyList)
                .setSizeRecomendationLazyLoad(pdpV3ActionProperty)
                .setSizeChartAction(pdpComponentizationComponentsResponse.props.sizechart.action)
                .setOutOfStockDescription(pdpComponentizationComponentsResponse.args.oosDesc)
                .setOutOfStockTitle(pdpComponentizationComponentsResponse.args.oosTitle)
                .setPersonalizedDescription(pdpComponentizationComponentsResponse.args.personalizedDesc)
                .setPersonalizedLabel(pdpComponentizationComponentsResponse.args.personalizedLabel)
                .setPersonalizedTitle(pdpComponentizationComponentsResponse.args.personalizedTitle)
                .setRecommendationIconInformationDescription(pdpComponentizationComponentsResponse.args.recoIconInfoDesc)
                .setRecommendationIconInformationText(pdpComponentizationComponentsResponse.args.recoIconInfoText)
                .setSizeChartTitleText(pdpComponentizationComponentsResponse.args.sizechartTitle)
                .build();
    }

    private PdpV3ActionProperty transformPdpV3ActionProperty(PdpComponentizationSizeRecoLazyResponse pdpComponentizationSizeRecoLazyResponse) {
        @PdpV3ActionType String pdpV3ActionType = getPdpV3ActionType
                (pdpComponentizationSizeRecoLazyResponse.actionType);

        return PdpV3ActionProperty.create()
                .setActionType(pdpV3ActionType)
                .setAction(pdpComponentizationSizeRecoLazyResponse.action)
                .build();
    }

    @Nullable
    private List<PdpV3SizeProperty> transformPdpV3SizeProperty(@Nullable List<PdpV3SizeResponse> pdpV3SizeResponseList) {
        if (pdpV3SizeResponseList == null) {
            return null;
        }
        List<PdpV3SizeProperty> pdpV3SizePropertyList = new ArrayList<>(0);
        for (PdpV3SizeResponse pdpV3SizeResponse : pdpV3SizeResponseList) {
            ProductSizeVariantId productSizeVariantId = ProductSizeVariantId.create(pdpV3SizeResponse.skuId);
            ProductId productId = ProductId.create(pdpV3SizeResponse.styleId);

            List<PdpV3WareHouse> pdpV3WareHouseList = null;
            if (pdpV3SizeResponse.warehouseList != null) {
                pdpV3WareHouseList = new ArrayList<>(0);
                for (String warehouse : pdpV3SizeResponse.warehouseList) {
                    pdpV3WareHouseList.add(PdpV3WareHouse.create(warehouse));
                }
            }

            @PdpV3ProductSupplyType
            String pdpV3ProductSupplyType;
            switch (pdpV3SizeResponse.supplyType) {
                case PdpV3ProductSupplyType.ON_HAND:
                    pdpV3ProductSupplyType = PdpV3ProductSupplyType.ON_HAND;
                    break;
                default:
                    pdpV3ProductSupplyType = PdpV3ProductSupplyType.UNKNOWN;
                    break;

            }

            Integer price = 0;
            Integer discountedPrice = 0;
//            if (pdpV3SizeResponse.price != null) {
//                try {
//                    price = Integer.parseInt(pdpV3SizeResponse.price.toString());
//                } catch (NumberFormatException e) {
//                    Log.e(PdpComponentizedModelTransformer.class.getSimpleName(), e.getMessage());
//                }
//            }
//            if (pdpV3SizeResponse.discountedPrice != null) {
//                try {
//                    discountedPrice = Integer.parseInt(pdpV3SizeResponse.discountedPrice.toString());
//                } catch (NumberFormatException e) {
//                    Log.e(PdpComponentizedModelTransformer.class.getSimpleName(), e.getMessage());
//                }
//            }

            pdpV3SizePropertyList.add(PdpV3SizeProperty.create()
                    .setProductSizeVariantId(productSizeVariantId)
                    .setProductId(productId)
                    .setInventoryCount(pdpV3SizeResponse.inventory)
                    .setRelatedSizeProductAction(pdpV3SizeResponse.action)
                    .setSizeLabel(pdpV3SizeResponse.label)
                    .setIsSizeAvailable(pdpV3SizeResponse.available)
                    .setSellerInformation(pdpV3SizeResponse.seller)
                    .setPdpV3ProductSupplyType(pdpV3ProductSupplyType)
                    .setPdpV3WareHouseList(pdpV3WareHouseList)
                    .setSizeType(null /*pdpV3SizeResponse.sizeType == null ? null : (pdpV3SizeResponse.sizeType.toString())*/)
                    .setPrice(price)
                    .setDiscountedPrice(discountedPrice)
                    .setOriginalStyle(null /*pdpV3SizeResponse.originalStyle == null ? null : (pdpV3SizeResponse.originalStyle.toString())*/)
                    .build());

        }
        return pdpV3SizePropertyList;
    }

//    private PdpV3ButtonsComponent transformPdpV3ButtonsComponent(PdpComponentizationComponentsResponse
//                                                                 pdpComponentizationComponentsResponse){
//
//        List<PdpV3SizeProperty> pdpV3SizePropertyList = transformPdpV3SizeProperty
//                (pdpComponentizationComponentsResponse.props.sizeList);
//        List<PdpV3ButtonStateProperty> pdpV3ButtonStatePropertyList = transformPdpV3ButtonStatePropertyList
//                (pdpComponentizationComponentsResponse.props.buttonStateList);
//        List<PdpV3DisplayDataProperty> pdpV3DisplayDataPropertyList = transformPdpV3DisplayDataPropertyList
//                (pdpComponentizationComponentsResponse.args.displayData);
//
//        return PdpV3ButtonsComponent.create()
//                .setIsSbpEnabled(pdpComponentizationComponentsResponse.props.sbpEnabled)
//                .setPdpV3SizePropertyList(pdpV3SizePropertyList)
//                .setPdpV3ButtonStatePropertyList(pdpV3ButtonStatePropertyList)
//                .setPdpV3DisplayDataPropertyList(pdpV3DisplayDataPropertyList)
//                .setSizeChartAction(pdpComponentizationComponentsResponse.props.sizechart.action)
//                .setSizeChartTitleText(pdpComponentizationComponentsResponse.args.sizechartTitle)
//                .build();
//    }
//
//    private List<PdpV3ButtonStateProperty> transformPdpV3ButtonStatePropertyList
//            (@Nullable List<PdpComponentizationButtonStateResponse> pdpComponentizationButtonStateResponseList){
//        if (pdpComponentizationButtonStateResponseList == null) {
//            return null;
//        }
//        List<PdpV3ButtonStateProperty> pdpV3ButtonStatePropertyList = new ArrayList<>(0);
//        for (PdpComponentizationButtonStateResponse pdpComponentizationButtonStateResponse
//                : pdpComponentizationButtonStateResponseList) {
//            pdpV3ButtonStatePropertyList.add(PdpV3ButtonStateProperty.create()
//                    .setButtonState(pdpComponentizationButtonStateResponse.state)
//                    .setPdpV3ButtonPropertyList(transformPdpV3ButtonPropertyList
//                            (pdpComponentizationButtonStateResponse.buttonList))
//                    .build());
//        }
//        return pdpV3ButtonStatePropertyList;
//    }
//
//    private List<PdpV3ButtonProperty> transformPdpV3ButtonPropertyList
//            (@Nullable List<PdpComponentizationButtonResponse> pdpComponentizationButtonResponseList) {
//        if (pdpComponentizationButtonResponseList == null) {
//            return null;
//        }
//        List<PdpV3ButtonProperty> pdpV3ButtonPropertyList = new ArrayList<>(0);
//        for (PdpComponentizationButtonResponse pdpComponentizationButtonResponse
//                : pdpComponentizationButtonResponseList) {
//            pdpV3ButtonPropertyList.add(PdpV3ButtonProperty.create()
//                    .setButtonLongPressAction(pdpComponentizationButtonResponse.longAction)
//                    .setButtonPressAction(pdpComponentizationButtonResponse.action)
//                    .setButtonType(pdpComponentizationButtonResponse.type)
//                    .build());
//        }
//        return pdpV3ButtonPropertyList;
//    }
//
//    private List<PdpV3DisplayDataProperty> transformPdpV3DisplayDataPropertyList(@Nullable
//            List<PdpComponentizationDisplayDataResponse> pdpComponentizationDisplayDataResponseList){
//        if(pdpComponentizationDisplayDataResponseList == null){
//            return null;
//        }
//        List<PdpV3DisplayDataProperty> pdpV3DisplayDataPropertyList = new ArrayList<>(0);
//        for(PdpComponentizationDisplayDataResponse pdpComponentizationDisplayDataResponse :
//                pdpComponentizationDisplayDataResponseList){
//            pdpV3DisplayDataPropertyList.add(PdpV3DisplayDataProperty.create()
//            .setButtonState(pdpComponentizationDisplayDataResponse.buyButtonState)
//            .setFirstButtonText(pdpComponentizationDisplayDataResponse.firstButtonText)
//            .setFirstButtonActionText(pdpComponentizationDisplayDataResponse.firstButtonActionText)
//            .setSecondButtonText(pdpComponentizationDisplayDataResponse.secondButtonText)
//            .setSecondButtonActionText(pdpComponentizationDisplayDataResponse.secondButtonActionText)
//            .setPersonalizedDescription(pdpComponentizationDisplayDataResponse.personalizedDesc)
//            .setPersonalizedLabel(pdpComponentizationDisplayDataResponse.personalizedLabel)
//            .setPersonalizedTitle(pdpComponentizationDisplayDataResponse.personalizedTitle)
//            .build());
//
//        }
//        return pdpV3DisplayDataPropertyList;
//    }
//
//    //endregion
//
//
//    //region PdpV3BrandCard transformer methods
//
//    private PdpV3BrandCard transformBrandCard(PdpComponentizationCardsResponse brandCard) {
//
//        @PdpV3ComponentType
//        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
//        PdpV3ProductDetailComponent pdpV3ProductDetailComponent = null;
//
//        if (CollectionUtils.hasElements(brandCard.componentsList)) {
//            final int brandIndexPos = 0;
//            @PdpV3ComponentType
//            final String componentType = brandCard.componentsList.get(brandIndexPos).type;
//            switch (componentType) {
//                case PdpV3ComponentType.MORE_INFO_COMPONENT_MORE_INFO:
//                    pdpV3ProductDetailComponent = transformPdpV3ProductDetailComponent(brandCard.componentsList.get(brandIndexPos).props.productDetailList);
//                    @PdpV3ComponentType
//                    String pdpV3ComponentType = PdpV3BrandComponentTypeUtil.from(componentType);
//                    componentPositionIndex.put(pdpV3ComponentType, brandIndexPos);
//                    break;
//            }
//        }
//
//        return PdpV3BrandCard.create()
//                .setComponentPositionsIndex(componentPositionIndex)
//                .setPdpV3ProductDetailComponent(pdpV3ProductDetailComponent)
//                .build();
//    }
//
//    private PdpV3ProductDetailComponent transformPdpV3ProductDetailComponent(@Nullable List
//            <PdpComponentizationProductDetailResponse> pdpComponentizationProductDetailResponseList) {
//
//        List<PdpV3ProductDetailProperty> pdpV3ProductDetailPropertyList = null;
//
//        if (pdpComponentizationProductDetailResponseList != null) {
//            pdpV3ProductDetailPropertyList = new ArrayList<>(0);
//            for (PdpComponentizationProductDetailResponse pdpComponentizationProductDetailResponse :
//                    pdpComponentizationProductDetailResponseList) {
//                pdpV3ProductDetailPropertyList.add(transformPdpV3ProductDetailProperty
//                        (pdpComponentizationProductDetailResponse));
//            }
//        }
//        return PdpV3ProductDetailComponent.create()
//                .setPdpV3ProductDetailPropertyList(pdpV3ProductDetailPropertyList)
//
//                .build();
//    }
//
//    private PdpV3ProductDetailProperty transformPdpV3ProductDetailProperty(PdpComponentizationProductDetailResponse
//
//                                                                                   pdpComponentizationProductDetailResponse) {
//
//        final String type = pdpComponentizationProductDetailResponse.type == null ? null : (pdpComponentizationProductDetailResponse.type).toString();
//        final String content = pdpComponentizationProductDetailResponse.content == null ? null : (pdpComponentizationProductDetailResponse.content).toString();
//
//        return PdpV3ProductDetailProperty.create()
//                .setPdpV3ProductDetailType(type)
//                .setPdpV3ProductDetailContent(content)
//                .setPdpV3ProductDetailDescription(pdpComponentizationProductDetailResponse.description)
//                .setPdpV3ProductDetailTitle(pdpComponentizationProductDetailResponse.title)
//                .build();
//    }
//
//    //endregion
//
//
//    //region PdpV3ServicabilityCard transformer methods
//
//    private PdpV3ServiceabilityCard transformServiceabilityCard(PdpComponentizationCardsResponse serviceabilityCard) {
//
//        @PdpV3ComponentType
//        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
//        PdpV3ServicabilityComponent pdpV3ServicabilityComponent = null;
//
//        if(CollectionUtils.hasElements(serviceabilityCard.componentsList)){
//            final int servicabilityIndexPos = 0;
//            @PdpV3ComponentType
//            final String componentType = serviceabilityCard.componentsList.get(servicabilityIndexPos).type;
//            switch (componentType) {
//                case PdpV3ComponentType.MORE_INFO_COMPONENT_MORE_INFO:
//                    pdpV3ServicabilityComponent = transformPdpV3ServicabilityComponent(serviceabilityCard.componentsList.get(servicabilityIndexPos));
//                    @PdpV3ComponentType
//                    String pdpV3ComponentType = PdpV3ServicabilityComponentTypeUtil.from(componentType);
//                    componentPositionIndex.put(pdpV3ComponentType, servicabilityIndexPos);
//                    break;
//            }
//        }
//
//        return PdpV3ServiceabilityCard.create()
//                .setComponentPositionsIndex(componentPositionIndex)
//                .setPdpV3ServicabilityComponent(pdpV3ServicabilityComponent)
//                .build();
//    }
//
//    private PdpV3ServicabilityComponent transformPdpV3ServicabilityComponent(PdpComponentizationComponentsResponse
//                                                                                     pdpComponentizationComponentsResponse){
//
//        PdpV3ServicabilityPlaceHolder pdpV3ServicabilityPlaceHolder =
//                transformPdpV3ServicabilityPlaceHolder(pdpComponentizationComponentsResponse.args.placehoder);
//
//        PdpV3ServicabilityTitle pdpV3ServicabilityTitle =
//                transformPdpV3ServicabilityTitle(pdpComponentizationComponentsResponse.args.title);
//
//        List<PdpV3ServicabilityDescription> pdpV3ServicabilityDescriptionList =
//                transformPdpV3ServicabilityDescriptionList(pdpComponentizationComponentsResponse.args.description);
//
//        PdpV3ServicabilityProperty pdpV3ServicabilityProperty = transformPdpV3ServicabilityProperty(pdpComponentizationComponentsResponse.props);
//
//        return PdpV3ServicabilityComponent.create(pdpV3ServicabilityProperty)
//                .setPdpV3ServicabilityDescriptionList(pdpV3ServicabilityDescriptionList)
//                .setPdpV3ServicabilityPlaceHolder(pdpV3ServicabilityPlaceHolder)
//                .setPdpV3ServicabilityTitle(pdpV3ServicabilityTitle)
//                .build();
//
//    }
//
//    private PdpV3ServicabilityProperty transformPdpV3ServicabilityProperty(PdpComponentizationPropsResponse
//                                                                                   pdpComponentizationPropsResponse){
//
//        List<PdpV3ServicabilityDescription> pdpV3ServicabilityDescriptorList =
//                transformPdpV3ServicabilityDescriptionList(pdpComponentizationPropsResponse.serviceability.descriptorList);
//
//        PdpComponentizationPayloadResponse pdpComponentizationPayloadResponse = pdpComponentizationPropsResponse.serviceability.payload;
//        PdpV3Pincode pdpV3Pincode = null;
//        List<PdpV3WareHouse> pdpV3WareHouseList = null;
//        PdpComponentizationFlagsResponse pdpComponentizationFlagsResponse = pdpComponentizationPropsResponse.serviceability.payload.options.flags;
//
//        if(StringUtils.isNotNull(pdpComponentizationPayloadResponse.pincode)){
//            pdpV3Pincode = PdpV3Pincode.create(pdpComponentizationPayloadResponse.pincode);
//        }
//
//        if(pdpComponentizationPayloadResponse.options.warehouseList != null){
//            pdpV3WareHouseList = new ArrayList<>(0);
//            for(String warehouse : pdpComponentizationPayloadResponse.options.warehouseList){
//                pdpV3WareHouseList.add(PdpV3WareHouse.create(warehouse));
//            }
//        }
//
//        return PdpV3ServicabilityProperty.create(pdpComponentizationPayloadResponse.options.price, pdpComponentizationPayloadResponse.options.price)
//                .setPdpV3ServicabilityAction(pdpComponentizationPropsResponse.serviceability.action)
//                .setPdpV3ServicabilityDescriptorList(pdpV3ServicabilityDescriptorList)
//                .setPdpV3Pincode(pdpV3Pincode)
//                .setPdpV3WareHouseList(pdpV3WareHouseList)
//                .setPdpV3ProductLeadTime(pdpComponentizationPayloadResponse.options.leadTime)
//                .setPdpV3ProductReturnPeriod(pdpComponentizationPayloadResponse.options.returnPeriod)
//                .setPdpV3ProductIsExchangeable(pdpComponentizationFlagsResponse.isExchangeable)
//                .setPdpV3ProductIsFragile(pdpComponentizationFlagsResponse.isFragile)
//                .setPdpV3ProductIsHazmat(pdpComponentizationFlagsResponse.isHazmat)
//                .setPdpV3ProductIsJewellery(pdpComponentizationFlagsResponse.isJewellery)
//                .setPdpV3ProductIsLarge(pdpComponentizationFlagsResponse.isLarge)
//                .setPdpV3ProductIsReturnable(pdpComponentizationFlagsResponse.isReturnable)
//                .setPdpV3ProductIsTryable(pdpComponentizationFlagsResponse.isTryable)
//                .setPdpV3CodeEnabled(pdpComponentizationFlagsResponse.codEnabled)
//                .build();
//    }
//
//    private List<PdpV3ServicabilityDescription> transformPdpV3ServicabilityDescriptionList(@Nullable
//                                                                                           List<String> descriptionList){
//
//        if(descriptionList == null){
//            return null;
//        }
//        List<PdpV3ServicabilityDescription> pdpV3ServicabilityDescriptionList = new ArrayList<>(0);
//        for(String description : descriptionList){
//            pdpV3ServicabilityDescriptionList.add(PdpV3ServicabilityDescription.create(description));
//        }
//        return pdpV3ServicabilityDescriptionList;
//    }
//
//    private PdpV3ServicabilityPlaceHolder transformPdpV3ServicabilityPlaceHolder(@Nullable String placeholder){
//        if(StringUtils.isNotNull(placeholder)){
//            return PdpV3ServicabilityPlaceHolder.create(placeholder);
//        }
//        return null;
//    }
//
//    private PdpV3ServicabilityTitle transformPdpV3ServicabilityTitle(@Nullable String title){
//        if(StringUtils.isNotNull(title)){
//            return PdpV3ServicabilityTitle.create(title);
//        }
//        return null;
//    }
//
//    //endregion
//
//
//    //region PdpV3SocialCard transformer methods
//
//    private PdpV3SocialCard transformSocialCard(PdpComponentizationCardsResponse socialCard) {
//
//        @PdpV3ComponentType
//        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
//        PdpV3LikersLazyComponent pdpV3LikersLazyComponent = null;
//        PdpV3CompleteLookComponent pdpV3CompleteLookComponent = null;
//
//        if (CollectionUtils.hasElements(socialCard.componentsList)) {
//            final int componentListSize = socialCard.componentsList.size();
//            for (int indexPos = 0; indexPos < componentListSize; indexPos++) {
//                PdpComponentizationComponentsResponse pdpComponentizationComponentsResponse
//                        = socialCard.componentsList.get(indexPos);
//                @PdpV3ComponentType
//                final String componentType = pdpComponentizationComponentsResponse.type;
//                switch (componentType) {
//                    case PdpV3ComponentType.SOCIAL_COMPONENT_LIKERS_LAZY:
//                        pdpV3LikersLazyComponent = transformPdpV3LikersLazyComponent(pdpComponentizationComponentsResponse.props.actionType,
//                                pdpComponentizationComponentsResponse.props.action,
//                                pdpComponentizationComponentsResponse.args.title);
//                        componentPositionIndex.put(PdpV3SocialComponentTypeUtil.from(componentType), indexPos);
//                        break;
//                    case PdpV3ComponentType.SOCIAL_COMPONENT_COMPLETE_LOOK:
//                        pdpV3CompleteLookComponent = transformPdpV3CompleteLookComponent(pdpComponentizationComponentsResponse.props.styleNote,
//                                pdpComponentizationComponentsResponse.args.title);
//                        componentPositionIndex.put(PdpV3SocialComponentTypeUtil.from(componentType), indexPos);
//                        break;
//                }
//            }
//        }
//
//        return PdpV3SocialCard.create()
//                .setComponentPositionsIndex(componentPositionIndex)
//                .setPdpV3LikersLazyComponent(pdpV3LikersLazyComponent)
//                .setPdpV3CompleteLookComponent(pdpV3CompleteLookComponent)
//                .build();
//    }
//
//    private PdpV3LikersLazyComponent transformPdpV3LikersLazyComponent(String actionType,
//                                                                       String action, String title) {
//
//        @PdpV3ActionType String pdpV3ActionType = getPdpV3ActionType(actionType);
//        PdpV3SocialTitle pdpV3SocialTitle = null;
//        if (StringUtils.isNotNullOrEmpty(title)) {
//            pdpV3SocialTitle = PdpV3SocialTitle.create(title);
//        }
//
//        return PdpV3LikersLazyComponent.create()
//                .setPdpV3ActionProperty(PdpV3ActionProperty.create()
//                        .setAction(action)
//                        .setActionType(pdpV3ActionType).build())
//                .setLikersTitle(pdpV3SocialTitle)
//                .build();
//    }
//
//    private PdpV3CompleteLookComponent transformPdpV3CompleteLookComponent(String styleNote, String title) {
//
//        PdpV3SocialTitle pdpV3SocialTitle = null;
//        PdpV3StyleNote pdpV3StyleNote = null;
//        if (StringUtils.isNotNullOrEmpty(title)) {
//            pdpV3SocialTitle = PdpV3SocialTitle.create(title);
//        }
//        if (StringUtils.isNotNullOrEmpty(styleNote)) {
//            pdpV3StyleNote = PdpV3StyleNote.create(title);
//        }
//
//        return PdpV3CompleteLookComponent.create()
//                .setPdpV3StyleNote(pdpV3StyleNote)
//                .setCompleteLookTitle(pdpV3SocialTitle)
//                .build();
//    }
//
//    //endregion
//
//
//    //region PdpV3RelatedCard transformer methods
//
//    private PdpV3RelatedCard transformRelatedCard(PdpComponentizationCardsResponse relatedCard) {
//
//        @PdpV3ComponentType
//        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
//        PdpV3RelatedPdpLazyComponent pdpV3RelatedPdpLazyComponent = null;
//        PdpV3CrossLinksComponent pdpV3CrossLinksComponent = null;
//        if (CollectionUtils.hasElements(relatedCard.componentsList)) {
//            final int componentListSize = relatedCard.componentsList.size();
//            for (int indexPos = 0; indexPos < componentListSize; indexPos++) {
//                @PdpV3ComponentType
//                final String componentType = relatedCard.componentsList.get(indexPos).type;
//                switch (componentType) {
//                    case PdpV3ComponentType.RELATED_COMPONENT_RELATED_PDP_LAZY:
//                        pdpV3RelatedPdpLazyComponent = transformPdpV3RelatedPdpLazyComponent(
//                                relatedCard.componentsList.get(indexPos).props.actionType,
//                                relatedCard.componentsList.get(indexPos).props.action);
//                        componentPositionIndex.put(PdpV3RelatedComponentTypeUtil.from(componentType),
//                                indexPos);
//                        break;
//                    case PdpV3ComponentType.RELATED_COPONENT_CROSS_LINKS:
//                        pdpV3CrossLinksComponent = transformPdpV3PdpV3CrossLinksComponent(
//                                relatedCard.componentsList.get(indexPos).props.crossLinksList);
//                        componentPositionIndex.put(PdpV3RelatedComponentTypeUtil.from(componentType),
//                                indexPos);
//                        break;
//                }
//            }
//        }
//
//        return PdpV3RelatedCard.create()
//                .setComponentPositionsIndex(componentPositionIndex)
//                .setPdpV3RelatedPdpLazyComponent(pdpV3RelatedPdpLazyComponent)
//                .setPdpV3CrossLinksComponent(pdpV3CrossLinksComponent)
//                .build();
//    }
//
//    private PdpV3RelatedPdpLazyComponent transformPdpV3RelatedPdpLazyComponent(String actionType,
//                                                                               String action) {
//
//        @PdpV3ActionType String pdpV3ActionType = getPdpV3ActionType(actionType);
//
//        return PdpV3RelatedPdpLazyComponent.create()
//                .setPdpV3ActionProperty(PdpV3ActionProperty.create()
//                        .setAction(action)
//                        .setActionType(pdpV3ActionType)
//                        .build())
//                .build();
//    }
//
//    @Nullable
//    private PdpV3CrossLinksComponent transformPdpV3PdpV3CrossLinksComponent(
//            @Nullable List<PdpComponentizationCrossLinksResponse> crossLinksList) {
//
//        if (crossLinksList == null) {
//            return null;
//        }
//
//        List<PdpV3CrossLinksProperty> crossLinksPropertyList = new ArrayList<>(0);
//        for (PdpComponentizationCrossLinksResponse pdpComponentizationCrossLinksResponse : crossLinksList) {
//            crossLinksPropertyList.add(PdpV3CrossLinksProperty.create()
//                    .setTitle(pdpComponentizationCrossLinksResponse.title)
//                    .setUrl(pdpComponentizationCrossLinksResponse.url)
//                    .build());
//        }
//
//        return PdpV3CrossLinksComponent.create()
//                .setPdpV3CrossLinksPropertyList(crossLinksPropertyList)
//                .build();
//    }
//
//    //endregion
//
//
//    //region PDPV3MoreInfoCard transformer methods
//
//    private PdpV3MoreInfoCard transformMoreInfoCard(PdpComponentizationCardsResponse moreInfoCard) {
//
//        @PdpV3ComponentType
//        LinkedHashMap<String, Integer> componentPositionIndex = new LinkedHashMap<>(0);
//        PdpV3MoreInfoComponent pdpV3MoreInfoComponent = null;
//        if (CollectionUtils.hasElements(moreInfoCard.componentsList)) {
//            final int moreInfoIndexPos = 0;
//            @PdpV3ComponentType
//            final String componentType = moreInfoCard.componentsList.get(moreInfoIndexPos).type;
//            switch (componentType) {
//                case PdpV3ComponentType.MORE_INFO_COMPONENT_MORE_INFO:
//                    pdpV3MoreInfoComponent = transformPdpV3MoreInfoComponent(moreInfoCard.componentsList.
//                                get(moreInfoIndexPos).props.moreInfoList);
//                    @PdpV3ComponentType
//                    String pdpV3ComponentType = PdpV3MoreInfoComponentTypeUtils.from(componentType);
//                    componentPositionIndex.put(pdpV3ComponentType, moreInfoIndexPos);
//                    break;
//            }
//        }
//
//        return PdpV3MoreInfoCard.create()
//                .setComponentPositionsIndex(componentPositionIndex)
//                .setPdpV3MoreInfoComponent(pdpV3MoreInfoComponent)
//                .build();
//    }
//
//    private PdpV3MoreInfoComponent transformPdpV3MoreInfoComponent(@Nullable List<PdpComponentizationMoreInfoResponse>
//                                                                           moreInfoList) {
//        List<PdpV3MoreInfoProperty> pdpV3MoreInfoPropertyList = new ArrayList<>(0);
//        if(moreInfoList != null) {
//            for (PdpComponentizationMoreInfoResponse pdpComponentizationMoreInfoResponse : moreInfoList) {
//                String action = null;
//                if (pdpComponentizationMoreInfoResponse.action != null) {
//                    action = pdpComponentizationMoreInfoResponse.action.toString();
//                }
//                pdpV3MoreInfoPropertyList.add(PdpV3MoreInfoProperty.create()
//                        .setAction(action)
//                        .setDescription(pdpComponentizationMoreInfoResponse.description)
//                        .setTitle(pdpComponentizationMoreInfoResponse.title)
//                        .build());
//            }
//
//        }
//        return PdpV3MoreInfoComponent.create()
//                .setPdpV3MoreInfoPropertyList(pdpV3MoreInfoPropertyList)
//                .build();
//    }

    //endregion

    //region Common helper methods
    @PdpV3ActionType
    private String getPdpV3ActionType(String actionType) {
        @PdpV3ActionType String pdpV3ActionType = PdpV3ActionType.UNKNOWN;
        if (StringUtils.isNotNullOrEmpty(actionType)) {
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