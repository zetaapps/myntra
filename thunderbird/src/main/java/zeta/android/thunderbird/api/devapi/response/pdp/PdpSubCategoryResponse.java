package zeta.android.thunderbird.api.devapi.response.pdp;



public class PdpSubCategoryResponse {

    public int id;

    public String typeName;

    public boolean active;

    public boolean socialSharingEnabled;

    public boolean isReturnable;

    public boolean isExchangeable;

    public boolean pickupEnabled;

    public boolean isTryAndBuyEnabled;

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
