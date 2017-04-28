package zeta.android.thunderbird.api.devapi.response.pdp;

import java.net.URL;

public class PdpDefaultStyleImagesResponse {

    public final URL imageURL;

    public final PdpResolutionsResponse resolutions;

    public final String imageType;

    public PdpDefaultStyleImagesResponse(URL imageURL,
                                         PdpResolutionsResponse resolutions,
                                         String imageType) {
        this.imageURL = imageURL;
        this.resolutions = resolutions;
        this.imageType = imageType;
    }
}
