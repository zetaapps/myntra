package zeta.android.thunderbird.api.apify.related.componentization;

public class PdpV3RelatedProductsComponentizationComponentsResponse {

    public final String type;

    public final String viewType;

    public final PdpV3RelatedProductsComponentizationPropsResponse props;

    public final PdpV3RelatedProductsComponentizationArgsResponse args;

    public PdpV3RelatedProductsComponentizationComponentsResponse(String type,
                                                                  String viewType,
                                                                  PdpV3RelatedProductsComponentizationPropsResponse props,
                                                                  PdpV3RelatedProductsComponentizationArgsResponse args) {
        this.type = type;
        this.viewType = viewType;
        this.props = props;
        this.args = args;
    }

}
