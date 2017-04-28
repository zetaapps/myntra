package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpMetaResponse {

    public final int code;

    public final String requestId;

    public PdpMetaResponse(int code,
                           String requestId) {
        this.code = code;
        this.requestId = requestId;
    }
}
