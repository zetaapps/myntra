package zeta.android.thunderbird.api.idpapi.response.idp;

import com.google.gson.annotations.SerializedName;

public class IdpTokenResponse {

    @SerializedName("meta")
    public final IdpMetaResponse profileMeta;

    @SerializedName("notification")
    public final IdpNotificationResponse dataNotification;

    @SerializedName("data")
    public final IdpUserProfileDataResponse profileData;

    public IdpTokenResponse(IdpMetaResponse profileMeta,
                            IdpNotificationResponse dataNotification,
                            IdpUserProfileDataResponse profileData) {
        this.profileMeta = profileMeta;
        this.dataNotification = dataNotification;
        this.profileData = profileData;
    }
}
