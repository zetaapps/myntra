package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {
    @SerializedName("videos")
    public List<Video> videoList = null;
    @SerializedName("axials")
    public List<Object> axialsList = null;
    @SerializedName("albums")
    public List<Album> albumList = null;
    @SerializedName("cinemagraphs")
    public List<Object> cinemagraphList = null;

}
