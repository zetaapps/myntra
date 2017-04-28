package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpMaterialsCareDescResponse {

    public String descriptorType;

    public String value;

    public PdpMaterialsCareDescResponse(String descriptorType,
                                        String value) {
        this.descriptorType = descriptorType;
        this.value = value;
    }
}