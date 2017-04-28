package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpOtherFlagResponse {

    public final String dataType;

    public final String name;

    public final String value;

    public PdpOtherFlagResponse(String dataType,
                                String name,
                                String value) {
        this.dataType = dataType;
        this.name = name;
        this.value = value;
    }
}
