package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationProductDetailResponse {

    public final Object type;

    public final Object content;

    public final String title;

    public final String description;

    public PdpComponentizationProductDetailResponse(Object type,
                                                    Object content,
                                                    String title,
                                                    String description) {
        this.type = type;
        this.content = content;
        this.title = title;
        this.description = description;
    }

}
