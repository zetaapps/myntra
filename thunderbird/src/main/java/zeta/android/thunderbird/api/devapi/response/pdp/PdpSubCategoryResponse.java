package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpSubCategoryResponse {

    public final int id;

    public final String typeName;

    public final boolean active;

    public final boolean socialSharingEnabled;

    public final boolean isReturnable;

    public final boolean isExchangeable;

    public final boolean pickupEnabled;

    public final boolean isTryAndBuyEnabled;

    public PdpSubCategoryResponse(int id,
                                  String typeName,
                                  boolean active,
                                  boolean socialSharingEnabled,
                                  boolean isReturnable,
                                  boolean isExchangeable,
                                  boolean pickupEnabled,
                                  boolean isTryAndBuyEnabled) {
        this.id = id;
        this.typeName = typeName;
        this.active = active;
        this.socialSharingEnabled = socialSharingEnabled;
        this.isReturnable = isReturnable;
        this.isExchangeable = isExchangeable;
        this.pickupEnabled = pickupEnabled;
        this.isTryAndBuyEnabled = isTryAndBuyEnabled;
    }
}
