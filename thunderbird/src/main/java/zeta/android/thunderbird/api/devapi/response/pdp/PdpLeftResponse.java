package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpLeftResponse {

    public final String imageURL;

    public final PdpResolutionsResponse resolutions;

    public final String imageType;

    public PdpLeftResponse(String imageURL,
                           PdpResolutionsResponse resolutions,
                           String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }

}