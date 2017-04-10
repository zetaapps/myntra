package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpDescriptorResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpPriceResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpSizeResponse;


public class PdpComponentizationPropsResponse {
    public int id;
    public String name;
    @SerializedName("media")
    public List<PdpComponentizationMediumResponse> mediumList = null;
    public int count;
    public PdpComponentizationRelatedResponse related;
    public PdpComponentizationLikesResponse likes;
    public String baseColour;
    public PdpPriceResponse price;
    @SerializedName("descriptors")
    public List<PdpDescriptorResponse> descriptorList = null;
    public PdpComponentizationBestPriceLoadResponse bestPriceOnDemand;
    public boolean sbpEnabled;
    @SerializedName("sizes")
    public List<PdpSizeResponse> sizeList = null;
    public PdpComponentizationSizeChartResponse sizechart;
    public PdpComponentizationSizeRecoLazyResponse sizeRecoLazy;
    @SerializedName("productDetails")
    public List<PdpComponentizationProductDetailResponse> productDetailList = null;
    public PdpComponentizationOffersResponse offer;
    @SerializedName("buttonStates")
    public List<PdpComponentizationButtonStateResponse> buttonStateList = null;
    public PdpComponentizationServiceabilityResponse serviceability;
    public String actionType;
    public String action;
    @SerializedName("crossLinks")
    public List<PdpComponentizationCrossLinksResponse> crossLinksList = null;
    @SerializedName("moreInfo")
    public List<PdpComponentizationMoreInfoResponse> moreInfoList = null;
}
