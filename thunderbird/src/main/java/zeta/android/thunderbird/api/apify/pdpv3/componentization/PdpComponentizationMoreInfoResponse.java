package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationMoreInfoResponse {

    public final String title;

    public final String description;

    public final Object action;

    public PdpComponentizationMoreInfoResponse(String title,
                                               String description,
                                               Object action) {
        this.title = title;
        this.description = description;
        this.action = action;
    }
}
