package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PdpComponentizationCardsResponse {
    public PdpComponentizationArgsResponse args;
    public String type;
    @SerializedName("components")
    public List<PdpComponentizationComponentsResponse> componentsList = null;
}
