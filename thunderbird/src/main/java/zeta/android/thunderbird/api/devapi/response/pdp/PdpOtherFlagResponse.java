package zeta.android.thunderbird.api.devapi.response.pdp;


public class PdpOtherFlagResponse {

    public String dataType;

    public String name;

    public String value;

    public PdpOtherFlagResponse(String dataType,
                                String name,
                                String value) {
        this.dataType = dataType;
        this.name = name;
        this.value = value;
    }
}
