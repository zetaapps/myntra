package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpStyleNoteResponse {

    public final String descriptorType;

    public final String value;

    public PdpStyleNoteResponse(String descriptorType,
                                String value) {
        this.descriptorType = descriptorType;
        this.value = value;
    }
}
