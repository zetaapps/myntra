package zeta.android.thunderbird.api.idpapi.response.idp;


import com.google.gson.annotations.SerializedName;

public class IdpImageJsonEntryMap {

    @SerializedName("COVER")
    public final String cover;

    @SerializedName("COVER_DEFAULT")
    public final String coverDefault;

    @SerializedName("PROFILE")
    public final String profile;

    @SerializedName("PROFILE_DEFAULT")
    public final String profileDefault;

    public IdpImageJsonEntryMap(String cover,
                                String coverDefault,
                                String profile,
                                String profileDefault) {
        this.cover = cover;
        this.coverDefault = coverDefault;
        this.profile = profile;
        this.profileDefault = profileDefault;
    }


}
