package zeta.android.thunderbird.api.idpapi.response.params;

public class IdpMyntraLoginParams {

    public final String action;

    public final String userId;

    public final String password;

    public IdpMyntraLoginParams(String action, String userId, String password) {
        this.action = action;
        this.userId = userId;
        this.password = password;
    }
}
