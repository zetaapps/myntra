package zeta.android.thunderbird.api.apify.pdpv3.pdp;

public class PdpV3FlagsResponse {

    public final boolean exchangeable;
    public final boolean returnable;
    public final boolean pickupEnabled;
    public final boolean tryable;
    public final boolean large;
    public final boolean hazmat;
    public final boolean fragile;
    public final boolean jewellery;
    public final boolean outOfStock;

    public PdpV3FlagsResponse(boolean exchangeable,
                              boolean returnable,
                              boolean pickupEnabled,
                              boolean tryable,
                              boolean large,
                              boolean hazmat,
                              boolean fragile,
                              boolean jewellery,
                              boolean outOfStock) {
        this.exchangeable = exchangeable;
        this.returnable = returnable;
        this.pickupEnabled = pickupEnabled;
        this.tryable = tryable;
        this.large = large;
        this.hazmat = hazmat;
        this.fragile = fragile;
        this.jewellery = jewellery;
        this.outOfStock = outOfStock;
    }
}
