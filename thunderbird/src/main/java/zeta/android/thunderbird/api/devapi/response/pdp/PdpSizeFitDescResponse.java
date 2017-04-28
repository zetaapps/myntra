package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpSizeFitDescResponse {

    public final String descriptorType;

    public final String value;

    public PdpSizeFitDescResponse(String descriptorType,
                                  String value) {
        this.descriptorType = descriptorType;
        this.value = value;
    }
}
