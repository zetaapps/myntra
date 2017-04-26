package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationOffersResponse {

    public final String title;

    public final String description;

    public final int count;

    public final String action;

    public PdpComponentizationOffersResponse(String title,
                                             String description,
                                             int count,
                                             String action) {
        this.title = title;
        this.description = description;
        this.count = count;
        this.action = action;
    }
}
