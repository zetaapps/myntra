package zeta.android.thunderbird.api.apify.pdpv3.common;

public class PdpPriceResponse {

    public final double mrp;

    public final double discounted;

    public final PdpDiscountResponse discount;

    public PdpPriceResponse(double mrp,
                            double discounted,
                            PdpDiscountResponse discount) {
        this.mrp = mrp;
        this.discounted = discounted;
        this.discount = discount;
    }
}
