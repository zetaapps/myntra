package zeta.android.thunderbird.api.apify.pdpv3.pdp;

public class PdpAnalyticsResponse {

    public final String articleType;
    public final String subCategory;
    public final String masterCategory;
    public final String gender;
    public final String brand;

    public PdpAnalyticsResponse(String articleType, String subCategory,
                                String masterCategory, String gender, String brand) {
        this.articleType = articleType;
        this.subCategory = subCategory;
        this.masterCategory = masterCategory;
        this.gender = gender;
        this.brand = brand;
    }
}
