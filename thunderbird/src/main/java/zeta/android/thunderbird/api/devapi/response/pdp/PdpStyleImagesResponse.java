package zeta.android.thunderbird.api.devapi.response.pdp;

import com.google.gson.annotations.SerializedName;

public class PdpStyleImagesResponse {

    @SerializedName("default")
    public PdpDefaultStyleImagesResponse defaultImages;

    public String sizeRepresentation;

    public PdpSearchResponse search;

    public PdpBackResponse back;

    public PdpLeftResponse left;

    public PdpFrontResponse front;

    public PdpRightResponse right;

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
