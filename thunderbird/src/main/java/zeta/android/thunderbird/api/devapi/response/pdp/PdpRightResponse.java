package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpRightResponse {

    public final String imageURL;

    public final PdpResolutionsResponse resolutions;

    public final String imageType;

    public PdpRightResponse(String imageURL,
                            PdpResolutionsResponse resolutions,
                            String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }
}
