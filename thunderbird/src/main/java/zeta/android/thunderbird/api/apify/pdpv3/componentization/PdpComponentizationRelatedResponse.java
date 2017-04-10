package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationRelatedResponse {

    public final boolean hasColors;

    public final String action;

    public final String actionType;

    public PdpComponentizationRelatedResponse(boolean hasColors,
                                              String action,
                                              String actionType) {
        this.hasColors = hasColors;
        this.action = action;
        this.actionType = actionType;
    }
}
