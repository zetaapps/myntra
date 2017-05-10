package zeta.android.thunderbird.api.apify.pdpv3.related.componentization;

public class PdpRelatedProductsComponentizationComponentsResponse {

    public final String type;

    public final String viewType;

    public final PdpRelatedProductsComponentizationPropsResponse props;

    public final PdpRelatedProductsComponentizationArgsResponse args;

    public PdpRelatedProductsComponentizationComponentsResponse(String type,
                                                                  String viewType,
                                                                  PdpRelatedProductsComponentizationPropsResponse props,
                                                                  PdpRelatedProductsComponentizationArgsResponse args) {
        this.type = type;
        this.viewType = viewType;
        this.props = props;
        this.args = args;
    }

}