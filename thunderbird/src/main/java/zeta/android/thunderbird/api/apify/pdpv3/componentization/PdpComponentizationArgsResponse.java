package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import android.support.annotation.Nullable;

import java.util.List;

public class PdpComponentizationArgsResponse {

    public final boolean collapse;
    public final String oosDesc;
    public final String oosTitle;
    public final String personalizedDesc;
    public final String personalizedLabel;
    public final String personalizedTitle;
    public final String recoIconInfoDesc;
    public final String recoIconInfoText;
    public final String sizechartTitle;
    public final String bankOffer;
    public final int maxDuration;
    public final int minInterest;
    public final String primaryOffer;
    public final String placehoder;
    public final String title;
    @Nullable
    public final List<String> description;
    public final PdpComponentizationTextResponse text;
    public final PdpComponentizationInfoTextResponse infoText;
    @Nullable
    public final List<PdpComponentizationDisplayDataResponse> displayData;

    public PdpComponentizationArgsResponse(boolean collapse, String oosDesc,
                                           String oosTitle, String personalizedDesc,
                                           String personalizedLabel, String personalizedTitle,
                                           String recoIconInfoDesc, String recoIconInfoText,
                                           String sizechartTitle, String bankOffer,
                                           int maxDuration, int minInterest,
                                           String primaryOffer, String placehoder,
                                           String title,
                                           @Nullable List<String> description,
                                           PdpComponentizationTextResponse text,
                                           PdpComponentizationInfoTextResponse infoText,
                                           @Nullable List<PdpComponentizationDisplayDataResponse> displayData) {
        this.collapse = collapse;
        this.oosDesc = oosDesc;
        this.oosTitle = oosTitle;
        this.personalizedDesc = personalizedDesc;
        this.personalizedLabel = personalizedLabel;
        this.personalizedTitle = personalizedTitle;
        this.recoIconInfoDesc = recoIconInfoDesc;
        this.recoIconInfoText = recoIconInfoText;
        this.sizechartTitle = sizechartTitle;
        this.bankOffer = bankOffer;
        this.maxDuration = maxDuration;
        this.minInterest = minInterest;
        this.primaryOffer = primaryOffer;
        this.placehoder = placehoder;
        this.title = title;
        this.description = description;
        this.text = text;
        this.infoText = infoText;
        this.displayData = displayData;
    }

}
