package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Album {
    public String name;
    @SerializedName("images")
    public List<Image> imageList = null;

}
