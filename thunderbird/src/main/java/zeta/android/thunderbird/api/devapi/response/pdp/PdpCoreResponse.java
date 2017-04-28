package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpCoreResponse {

    public String order;

    public String display;

    public String pdtDetail;

    public String pdtDeliveryOptions;

    public String pdtSimilar;

    public String pdtLike;

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
