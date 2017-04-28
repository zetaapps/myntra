package zeta.android.thunderbird.api.devapi.response.pdp;

import com.google.gson.annotations.SerializedName;

public class PdpArticleAttributesResponse {

    @SerializedName("Pattern")
    public final String pattern;

    @SerializedName("Transparency")
    public final String transparency;

    @SerializedName("Sleeve Length")
    public final String sleeveLength;

    @SerializedName("Sleeve Styling")
    public final String sleeveStyling;

    @SerializedName("taxMaterial")
    public final String taxMaterial;

    @SerializedName("Closure")
    public final String closure;

    @SerializedName("Occasion")
    public final String occasion;

    @SerializedName("Main Trend")
    public final String mainTrend;

    @SerializedName("Print or Pattern Type")
    public final String printOrPatternType;

    @SerializedName("Wash Care")
    public final String washCare;

    @SerializedName("Fabric Type")
    public final String fabricType;

    @SerializedName("Sub Trend")
    public final String subTrend;

    @SerializedName("Weave Type")
    public final String weaveType;

    @SerializedName("Type")
    public final String type;

    @SerializedName("Surface Styling")
    public final String surfaceStyling;

    @SerializedName("Length")
    public final String length;

    @SerializedName("Lining")
    public final String lining;

    @SerializedName("Neck")
    public final String neck;

    @SerializedName("Fabric")
    public final String fabric;

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
