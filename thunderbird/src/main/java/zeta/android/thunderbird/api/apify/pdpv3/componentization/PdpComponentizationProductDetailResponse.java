package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationProductDetailResponse {

    public final String type;

    public final String content;

    public final String title;

    public final String description;

    public PdpComponentizationProductDetailResponse(String type,
                                                    String content,
                                                    String title,
                                                    String description) {
        this.type = type;
        this.content = content;
        this.title = title;
        this.description = description;
    }

}
