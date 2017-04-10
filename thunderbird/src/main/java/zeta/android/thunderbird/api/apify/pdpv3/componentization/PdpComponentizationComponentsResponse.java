package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationComponentsResponse {

    public final String type;

    public final String viewType;

    public final PdpComponentizationPropsResponse props;

    public final PdpComponentizationArgsResponse args;

    public PdpComponentizationComponentsResponse(String type,
                                                 String viewType,
                                                 PdpComponentizationPropsResponse props,
                                                 PdpComponentizationArgsResponse args) {
        this.type = type;
        this.viewType = viewType;
        this.props = props;
        this.args = args;
    }
}
