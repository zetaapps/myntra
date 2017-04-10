package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationPayloadResponse {

    public final String pincode;
    public final PdpComponentizationOptionsResponse options;

    public PdpComponentizationPayloadResponse(String pincode,
                                              PdpComponentizationOptionsResponse options) {
        this.pincode = pincode;
        this.options = options;
    }
}
