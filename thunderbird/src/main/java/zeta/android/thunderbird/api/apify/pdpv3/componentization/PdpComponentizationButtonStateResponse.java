package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpComponentizationButtonStateResponse {

    public final int state;

    @Nullable
    @SerializedName("buttons")
    public final List<PdpComponentizationButtonResponse> buttonList;

    public PdpComponentizationButtonStateResponse(int state,
                                                  @Nullable List<PdpComponentizationButtonResponse> buttonList) {
        this.state = state;
        this.buttonList = buttonList;
    }
}
