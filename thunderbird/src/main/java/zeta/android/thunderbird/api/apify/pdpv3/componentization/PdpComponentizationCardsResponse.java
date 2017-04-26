package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpComponentizationCardsResponse {

    public final String type;

    public final PdpComponentizationArgsResponse args;

    @Nullable
    @SerializedName("components")
    public final List<PdpComponentizationComponentsResponse> componentsList;

    public PdpComponentizationCardsResponse(PdpComponentizationArgsResponse args,
                                            String type,
                                            @Nullable List<PdpComponentizationComponentsResponse> componentsList) {
        this.args = args;
        this.type = type;
        this.componentsList = componentsList;
    }
}
