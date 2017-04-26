package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

public class PdpComponentizationDisplayDataResponse {

    public final String buyDisableMessage;

    public final String firstButtonActionText;

    public final String firstButtonText;

    public final  String personalizedDesc;

    public final String personalizedLabel;

    public final String personalizedTitle;

    public final String secondButtonActionText;

    public final String secondButtonText;

    @SerializedName("state")
    public final int buyButtonState;

    public PdpComponentizationDisplayDataResponse(String firstButtonActionText,
                                                  String firstButtonText,
                                                  String personalizedDesc,
                                                  String personalizedLabel,
                                                  String personalizedTitle,
                                                  String secondButtonActionText,
                                                  String secondButtonText,
                                                  int buyButtonState,
                                                  String buyDisableMessage) {
        this.firstButtonActionText = firstButtonActionText;
        this.firstButtonText = firstButtonText;
        this.personalizedDesc = personalizedDesc;
        this.personalizedLabel = personalizedLabel;
        this.personalizedTitle = personalizedTitle;
        this.secondButtonActionText = secondButtonActionText;
        this.secondButtonText = secondButtonText;
        this.buyButtonState = buyButtonState;
        this.buyDisableMessage = buyDisableMessage;
    }
}
