package zeta.android.thunderbird.api.apify.pdpv3.pdp;

public class PdpImageResponse {

    public final String src;
    public final String secureSrc;

    public PdpImageResponse(String src, String secureSrc) {
        this.src = src;
        this.secureSrc = secureSrc;
    }
}
