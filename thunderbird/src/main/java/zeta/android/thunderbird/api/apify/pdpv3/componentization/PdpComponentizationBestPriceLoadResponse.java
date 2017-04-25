package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationBestPriceLoadResponse {

    public final String action;

    public final String actionType;

    public PdpComponentizationBestPriceLoadResponse(String action,
                                                    String actionType) {
        this.action = action;
        this.actionType = actionType;
    }
}
