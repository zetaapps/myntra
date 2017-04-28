package zeta.android.thunderbird.api.devapi.response.pdp;

import java.net.URL;

public class PdpDefaultStyleImagesResponse {


    public URL imageURL;

    public PdpResolutionsResponse resolutions;

    public String imageType;

    public PdpDefaultStyleImagesResponse(URL imageURL,
                              PdpResolutionsResponse resolutions,
                              String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }
}
