package zeta.android.thunderbird.api.idpapi.response.idp;

import com.google.gson.annotations.SerializedName;

public class IdpMetaResponse {

    @SerializedName("code")
    public final int responseCode;

    @SerializedName("token")
    public final String token;

    @SerializedName("xsrfToken")
    public final String xsrfToken;

    public IdpMetaResponse(int responseCode, String token, String xsrfToken) {
        this.responseCode = responseCode;
        this.token = token;
        this.xsrfToken = xsrfToken;
    }
}
