package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PdpComponentizationServiceabilityResponse {
    public String action;
    @SerializedName("descriptors")
    public List<String> descriptorList = null;
    public PdpComponentizationPayloadResponse payload;
}
