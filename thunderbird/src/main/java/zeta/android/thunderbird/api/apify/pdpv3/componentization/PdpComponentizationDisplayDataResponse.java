package zeta.android.thunderbird.api.apify.pdpv3.componentization;


import com.google.gson.annotations.SerializedName;

public class PdpComponentizationDisplayDataResponse {
    public String firstButtonActionText;
    public String firstButtonText;
    public String secondButtonActionText;
    public String secondButtonText;
    @SerializedName("state")
    public int buyButtonState;
    public String buyDisableMessage;
}
