package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpDescriptorResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpPriceResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpSizeResponse;

public class PdpStyleResponse {
    public int id;
    public String name;
    public Object colours;
    public PdpPriceResponse price;
    public PdpMediaResponse media;
    @SerializedName("sizes")
    public List<PdpSizeResponse> sizeList = null;
    public PdpBrandResponse brand;
    @SerializedName("descriptors")
    public List<PdpDescriptorResponse> descriptorList = null;
    public PdpFlagsResponse flags;
    public PdpAnalyticsResponse analytics;
}
