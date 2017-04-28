package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpBackResponse {


    public String imageURL;

    public PdpResolutionsResponse resolutions;

    public String imageType;

    public PdpBackResponse(String imageURL,
                           PdpResolutionsResponse resolutions,
                           String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }
}