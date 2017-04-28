package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpLeftResponse {

    public String imageURL;

    public PdpResolutionsResponse resolutions;

    public String imageType;

    public PdpLeftResponse(String imageURL,
                           PdpResolutionsResponse resolutions,
                           String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }

}