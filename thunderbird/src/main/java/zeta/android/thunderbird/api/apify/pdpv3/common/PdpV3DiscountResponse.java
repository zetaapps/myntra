package zeta.android.thunderbird.api.apify.pdpv3.common;

public class PdpV3DiscountResponse {

    public final String label;

    public final String description;

    public final String myntCash;

    public final String coupon;

    public PdpV3DiscountResponse(String label,
                                 String description,
                                 String myntCash,
                                 String coupon) {
        this.label = label;
        this.description = description;
        this.myntCash = myntCash;
        this.coupon = coupon;
    }
}
