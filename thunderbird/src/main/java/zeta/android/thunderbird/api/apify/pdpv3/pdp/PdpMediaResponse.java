package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpMediaResponse {
    @SerializedName("videos")
    public List<PdpVideoResponse> pdpVideoResponseList = null;
    @SerializedName("axials")
    public List<Object> axialsList = null;
    @SerializedName("albums")
    public List<PdpAlbumResponse> pdpAlbumResponseList = null;
    @SerializedName("cinemagraphs")
    public List<Object> cinemagraphList = null;

}
