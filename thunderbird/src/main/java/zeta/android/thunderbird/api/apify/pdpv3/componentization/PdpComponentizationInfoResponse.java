package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationInfoResponse {

    public final int id;
    public final String name;
    public final String brand;
    public final String gender;
    public final String subCategory;
    public final String masterCategory;
    public final String articleType;

    public PdpComponentizationInfoResponse(int id, String name, String brand, String gender,
                                           String subCategory, String masterCategory,
                                           String articleType) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.gender = gender;
        this.subCategory = subCategory;
        this.masterCategory = masterCategory;
        this.articleType = articleType;
    }
}
