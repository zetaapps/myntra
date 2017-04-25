package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationFlagsResponse {

    public final boolean isHazmat;

    public final boolean isFragile;

    public final boolean isJewellery;

    public final boolean isExchangeable;

    public final boolean pickupEnabled;

    public final boolean isTryable;

    public final boolean isLarge;

    public final boolean isReturnable;

    public final boolean codEnabled;

    public PdpComponentizationFlagsResponse(boolean isHazmat, boolean isFragile,
                                            boolean isJewellery, boolean isExchangeable,
                                            boolean pickupEnabled, boolean isTryable,
                                            boolean isLarge, boolean isReturnable,
                                            boolean codEnabled) {
        this.isHazmat = isHazmat;
        this.isFragile = isFragile;
        this.isJewellery = isJewellery;
        this.isExchangeable = isExchangeable;
        this.pickupEnabled = pickupEnabled;
        this.isTryable = isTryable;
        this.isLarge = isLarge;
        this.isReturnable = isReturnable;
        this.codEnabled = codEnabled;
    }
}
