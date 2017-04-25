package zeta.android.thunderbird.api.apify.pdpv3.common;

public class PdpV3PriceResponse {

    public final double mrp;

    public final double discounted;

    public final PdpV3DiscountResponse discount;

    public PdpV3PriceResponse(double mrp,
                              double discounted,
                              PdpV3DiscountResponse discount) {
        this.mrp = mrp;
        this.discounted = discounted;
        this.discount = discount;
    }
}
