package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpMediaResponse {

    @SerializedName("videos")
    @Nullable
    public final List<PdpVideoResponse> pdpVideoResponseList;

    @Nullable
    @SerializedName("axials")
    public final List<Object> axialsList = null;

    @Nullable
    @SerializedName("albums")
    public final List<PdpAlbumResponse> pdpAlbumResponseList;

    @SerializedName("cinemagraphs")
    public final List<Object> cinemagraphList;

    public PdpMediaResponse(@Nullable List<PdpVideoResponse> pdpVideoResponseList,
                            @Nullable List<PdpAlbumResponse> pdpAlbumResponseList,
                            List<Object> cinemagraphList) {
        this.pdpVideoResponseList = pdpVideoResponseList;
        this.pdpAlbumResponseList = pdpAlbumResponseList;
        this.cinemagraphList = cinemagraphList;
    }
}
