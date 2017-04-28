package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpMetaResponse {

    public int code;

    public String requestId;

    public PdpMetaResponse(int code,
                           String requestId) {
        this.code = code;
        this.requestId = requestId;
    }
}
