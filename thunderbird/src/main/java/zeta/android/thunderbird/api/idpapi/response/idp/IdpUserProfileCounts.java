package zeta.android.thunderbird.api.idpapi.response.idp;

import com.google.gson.annotations.SerializedName;

public class IdpUserProfileCounts {

    @SerializedName("following")
    public final int following;

    @SerializedName("followers")
    public final int followers;

    public IdpUserProfileCounts(int following, int followers) {
        this.following = following;
        this.followers = followers;
    }
}


