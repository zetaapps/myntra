package zeta.android.thunderbird.api.apify.pdpv3.common;

public class PdpDiscountResponse {

    public final String label;
    public final String description;
    public final Object myntCash;
    public final Object coupon;

    public PdpDiscountResponse(String label,
                               String description,
                               Object myntCash,
                               Object coupon) {
        this.label = label;
        this.description = description;
        this.myntCash = myntCash;
        this.coupon = coupon;
    }
}
