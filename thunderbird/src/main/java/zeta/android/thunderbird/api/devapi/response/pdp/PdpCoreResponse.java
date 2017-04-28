package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpCoreResponse {

    public final String order;

    public final String display;

    public final String pdtDetail;

    public final String pdtDeliveryOptions;

    public final String pdtSimilar;

    public final String pdtLike;

    public PdpCoreResponse(String order,
                           String display,
                           String pdtDetail,
                           String pdtDeliveryOptions,
                           String pdtSimilar,
                           String pdtLike) {
        this.order = order;
        this.display = display;
        this.pdtDetail = pdtDetail;
        this.pdtDeliveryOptions = pdtDeliveryOptions;
        this.pdtSimilar = pdtSimilar;
        this.pdtLike = pdtLike;
    }
}
