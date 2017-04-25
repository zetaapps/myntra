package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpV3MediaResponse {

    @SerializedName("videos")
    @Nullable
    public final List<PdpV3VideoResponse> pdpVideoResponseList;

    @Nullable
    @SerializedName("axials")
    public final List<Object> axialsList = null;

    @Nullable
    @SerializedName("albums")
    public final List<PdpAlbumResponse> pdpAlbumResponseList;

    @SerializedName("cinemagraphs")
    public final List<Object> cinemagraphList;

    public PdpV3MediaResponse(@Nullable List<PdpV3VideoResponse> pdpVideoResponseList,
                              @Nullable List<PdpAlbumResponse> pdpAlbumResponseList,
                              List<Object> cinemagraphList) {
        this.pdpVideoResponseList = pdpVideoResponseList;
        this.pdpAlbumResponseList = pdpAlbumResponseList;
        this.cinemagraphList = cinemagraphList;
    }
}
