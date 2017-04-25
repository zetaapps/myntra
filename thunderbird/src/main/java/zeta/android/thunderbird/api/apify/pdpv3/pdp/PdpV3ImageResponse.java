package zeta.android.thunderbird.api.apify.pdpv3.pdp;

public class PdpV3ImageResponse {

    public final String src;
    public final String secureSrc;

    public PdpV3ImageResponse(String src, String secureSrc) {
        this.src = src;
        this.secureSrc = secureSrc;
    }
}
