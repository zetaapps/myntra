package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationMoreInfoResponse {

    public final String title;

    public final String description;

    public final String action;

    public PdpComponentizationMoreInfoResponse(String title,
                                               String description,
                                               String action) {
        this.title = title;
        this.description = description;
        this.action = action;
    }
}
