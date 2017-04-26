package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3DescriptorResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3PriceResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3SizeResponse;

public class PdpComponentizationPropsResponse {

    public final int id;

    public final String name;

    @SerializedName("media")
    public final List<PdpComponentizationMediumResponse> mediumList;

    public final int count;

    public final PdpComponentizationRelatedResponse related;

    public final PdpComponentizationLikesResponse likes;

    public final String baseColour;

    public final PdpV3PriceResponse price;

    @SerializedName("descriptors")
    public final List<PdpV3DescriptorResponse> descriptorList;

    public final PdpComponentizationBestPriceLoadResponse bestPriceOnDemand;

    public final boolean sbpEnabled;

    @Nullable
    @SerializedName("sizes")
    public final List<PdpV3SizeResponse> sizeList;

    public final PdpComponentizationSizeChartResponse sizechart;

    public final PdpComponentizationSizeRecoLazyResponse sizeRecoLazy;

    @Nullable
    @SerializedName("productDetails")
    public final List<PdpComponentizationProductDetailResponse> productDetailList;

    public final PdpComponentizationOffersResponse offer;

    @Nullable
    @SerializedName("buttonStates")
    public final List<PdpComponentizationButtonStateResponse> buttonStateList;

    public final PdpComponentizationServiceabilityResponse serviceability;

    public final String actionType;

    public final String action;

    public final String styleNote;

    public final String vatInfo;

    @Nullable
    @SerializedName("crossLinks")
    public final List<PdpComponentizationCrossLinksResponse> crossLinksList;

    @Nullable
    @SerializedName("moreInfo")
    public final List<PdpComponentizationMoreInfoResponse> moreInfoList;

    public PdpComponentizationPropsResponse(int id, String name, List<PdpComponentizationMediumResponse> mediumList,
                                            int count, PdpComponentizationRelatedResponse related,
                                            PdpComponentizationLikesResponse likes, String baseColour,
                                            PdpV3PriceResponse price, List<PdpV3DescriptorResponse> descriptorList,
                                            PdpComponentizationBestPriceLoadResponse bestPriceOnDemand,
                                            boolean sbpEnabled,
                                            @Nullable List<PdpV3SizeResponse> sizeList,
                                            PdpComponentizationSizeChartResponse sizechart,
                                            PdpComponentizationSizeRecoLazyResponse sizeRecoLazy,
                                            @Nullable List<PdpComponentizationProductDetailResponse> productDetailList,
                                            PdpComponentizationOffersResponse offer,
                                            @Nullable List<PdpComponentizationButtonStateResponse> buttonStateList,
                                            PdpComponentizationServiceabilityResponse serviceability,
                                            String actionType, String action,
                                            String styleNote,
                                            String vatInfo,
                                            @Nullable List<PdpComponentizationCrossLinksResponse> crossLinksList,
                                            @Nullable List<PdpComponentizationMoreInfoResponse> moreInfoList) {
        this.id = id;
        this.name = name;
        this.mediumList = mediumList;
        this.count = count;
        this.related = related;
        this.likes = likes;
        this.baseColour = baseColour;
        this.price = price;
        this.descriptorList = descriptorList;
        this.bestPriceOnDemand = bestPriceOnDemand;
        this.sbpEnabled = sbpEnabled;
        this.sizeList = sizeList;
        this.sizechart = sizechart;
        this.sizeRecoLazy = sizeRecoLazy;
        this.productDetailList = productDetailList;
        this.offer = offer;
        this.buttonStateList = buttonStateList;
        this.serviceability = serviceability;
        this.actionType = actionType;
        this.action = action;
        this.styleNote = styleNote;
        this.vatInfo = vatInfo;
        this.crossLinksList = crossLinksList;
        this.moreInfoList = moreInfoList;
    }
}
