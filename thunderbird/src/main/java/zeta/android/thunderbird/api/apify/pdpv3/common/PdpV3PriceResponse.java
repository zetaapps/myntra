package zeta.android.thunderbird.api.apify.pdpv3.common;

public class PdpV3PriceResponse {

    public final int mrp;

    public final int discounted;

    public final PdpV3DiscountResponse discount;

    public PdpV3PriceResponse(int mrp,
                              int discounted,
                              PdpV3DiscountResponse discount) {
        this.mrp = mrp;
        this.discounted = discounted;
        this.discount = discount;
    }
}
