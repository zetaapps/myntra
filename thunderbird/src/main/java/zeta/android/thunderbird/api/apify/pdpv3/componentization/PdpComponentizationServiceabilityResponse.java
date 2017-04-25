package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpComponentizationServiceabilityResponse {

    public final String action;

    @Nullable
    @SerializedName("descriptors")
    public final List<String> descriptorList;

    public final PdpComponentizationPayloadResponse payload;

    public PdpComponentizationServiceabilityResponse(String action,
                                                     @Nullable List<String> descriptorList,
                                                     PdpComponentizationPayloadResponse payload) {
        this.action = action;
        this.descriptorList = descriptorList;
        this.payload = payload;
    }
}
