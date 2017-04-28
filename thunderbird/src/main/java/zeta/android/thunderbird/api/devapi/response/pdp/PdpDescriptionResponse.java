package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpDescriptionResponse {


    public String descriptorType;

    public String value;

    public PdpDescriptionResponse(String descriptorType,
                                  String value) {
        this.descriptorType = descriptorType;
        this.value = value;
    }
}
