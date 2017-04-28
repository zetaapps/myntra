package zeta.android.thunderbird.api.devapi.response.pdp;


public class PdpRightResponse {

    public String imageURL;

    public PdpResolutionsResponse resolutions;

    public String imageType;

    public PdpRightResponse(String imageURL,
                            PdpResolutionsResponse resolutions,
                            String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }
}
