package zeta.android.thunderbird.api.devapi.response.pdp;


import com.google.gson.annotations.SerializedName;

public class PdpArticleAttributesResponse {

    @SerializedName("Pattern")
    public String pattern;

    @SerializedName("Transparency")
    public String transparency;

    @SerializedName("Sleeve Length")
    public String sleeveLength;

    @SerializedName("Sleeve Styling")
    public String sleeveStyling;

    @SerializedName("taxMaterial")
    public String taxMaterial;

    @SerializedName("Closure")
    public String closure;

    @SerializedName("Occasion")
    public String occasion;

    @SerializedName("Main Trend")
    public String mainTrend;

    @SerializedName("Print or Pattern Type")
    public String printOrPatternType;

    @SerializedName("Wash Care")
    public String washCare;

    @SerializedName("Fabric Type")
    public String fabricType;

    @SerializedName("Sub Trend")
    public String subTrend;

    @SerializedName("Weave Type")
    public String weaveType;

    @SerializedName("Type")
    public String type;

    @SerializedName("Surface Styling")
    public String surfaceStyling;

    @SerializedName("Length")
    public String length;

    @SerializedName("Lining")
    public String lining;

    @SerializedName("Neck")
    public String neck;

    @SerializedName("Fabric")
    public String fabric;

    public PdpArticleAttributesResponse(String pattern,
                                        String transparency,
                                        String sleeveLength,
                                        String sleeveStyling,
                                        String taxMaterial,
                                        String closure,
                                        String occasion,
                                        String mainTrend,
                                        String printOrPatternType,
                                        String washCare,
                                        String fabricType,
                                        String subTrend,
                                        String weaveType,
                                        String type,
                                        String surfaceStyling,
                                        String length,
                                        String lining,
                                        String neck,
                                        String fabric) {

        this.pattern = pattern;
        this.transparency = transparency;
        this.sleeveLength = sleeveLength;
        this.sleeveStyling = sleeveStyling;
        this.taxMaterial = taxMaterial;
        this.closure = closure;
        this.occasion = occasion;
        this.mainTrend = mainTrend;
        this.printOrPatternType = printOrPatternType;
        this.washCare = washCare;
        this.fabricType = fabricType;
        this.subTrend = subTrend;
        this.weaveType = weaveType;
        this.type = type;
        this.surfaceStyling = surfaceStyling;
        this.length = length;
        this.lining = lining;
        this.neck = neck;
        this.fabric = fabric;


    }
}
