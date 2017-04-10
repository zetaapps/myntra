package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationButtonResponse {

    public final String type;
    public final String action;
    public final String longAction;

    public PdpComponentizationButtonResponse(String type,
                                             String action,
                                             String longAction) {
        this.type = type;
        this.action = action;
        this.longAction = longAction;
    }
}
