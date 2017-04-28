package zeta.android.thunderbird.api.devapi.response.pdp;

import com.google.gson.annotations.SerializedName;

public class PdpStyleImagesResponse {

    @SerializedName("default")
    public final PdpDefaultStyleImagesResponse defaultImages;

    public final String sizeRepresentation;

    public final PdpSearchResponse search;

    public final PdpBackResponse back;

    public final PdpLeftResponse left;

    public final PdpFrontResponse front;

    public final PdpRightResponse right;

    public PdpStyleImagesResponse(PdpDefaultStyleImagesResponse defaultImages,
                                  String sizeRepresentation,
                                  PdpSearchResponse search,
                                  PdpBackResponse back,
                                  PdpLeftResponse left,
                                  PdpFrontResponse front,
                                  PdpRightResponse right) {
        this.defaultImages = defaultImages;
        this.sizeRepresentation = sizeRepresentation;
        this.search = search;
        this.back = back;
        this.left = left;
        this.front = front;
        this.right = right;
    }
}
