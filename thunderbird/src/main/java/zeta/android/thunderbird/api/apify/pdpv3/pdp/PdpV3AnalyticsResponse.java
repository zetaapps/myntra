package zeta.android.thunderbird.api.apify.pdpv3.pdp;

public class PdpV3AnalyticsResponse {

    public final String articleType;
    public final String subCategory;
    public final String masterCategory;
    public final String gender;
    public final String brand;

    public PdpV3AnalyticsResponse(String articleType, String subCategory,
                                  String masterCategory, String gender, String brand) {
        this.articleType = articleType;
        this.subCategory = subCategory;
        this.masterCategory = masterCategory;
        this.gender = gender;
        this.brand = brand;
    }
}
