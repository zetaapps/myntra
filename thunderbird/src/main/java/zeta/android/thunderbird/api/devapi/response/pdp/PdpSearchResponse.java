package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpSearchResponse {

    public final String imageURL;

    public final PdpResolutionsResponse resolutions;

    public final String imageType;

    public PdpSearchResponse(String imageURL,
                             PdpResolutionsResponse resolutions,
                             String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }

}
