package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpDescriptor;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpPrice;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpSize;


public class ComponentizationProps {
    public Number id;
    public String name;
    @SerializedName("media")
    public List<ComponentizationMedium> mediumList = null;
    public Number count;
    public ComponentizationRelated related;
    public ComponentizationLikes likes;
    public String baseColour;
    public PdpPrice price;
    @SerializedName("descriptors")
    public List<PdpDescriptor> descriptorList = null;
    public ComponentizationBestPriceLoad bestPriceOnDemand;
    public Boolean sbpEnabled;
    @SerializedName("sizes")
    public List<PdpSize> sizeList = null;
    public ComponentizationSizeChart sizechart;
    public ComponentizationSizeRecoLazy sizeRecoLazy;
    @SerializedName("productDetails")
    public List<ComponentizationProductDetail> productDetailList = null;
    public ComponentizationOffers offer;
    @SerializedName("buttonStates")
    public List<ComponentizationButtonState> buttonStateList = null;
    public ComponentizationServiceability serviceability;
    public String actionType;
    public String action;
    @SerializedName("crossLinks")
    public List<ComponentizationCrossLinks> crossLinksList = null;
    @SerializedName("moreInfo")
    public List<ComponentizationMoreInfo> moreInfoList = null;
}
