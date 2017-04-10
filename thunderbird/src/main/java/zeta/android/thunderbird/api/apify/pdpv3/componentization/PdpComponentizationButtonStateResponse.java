package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PdpComponentizationButtonStateResponse {
    public int state;
    @SerializedName("buttons")
    public List<PdpComponentizationButtonResponse> buttonList = null;
}
