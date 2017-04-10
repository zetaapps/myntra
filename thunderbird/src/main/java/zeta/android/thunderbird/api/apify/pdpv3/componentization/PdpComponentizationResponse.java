package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PdpComponentizationResponse {
    public final PdpComponentizationInfoResponse info;
    @SerializedName("cards")
    public final List<PdpComponentizationCardsResponse> cardsList;

    public PdpComponentizationResponse(PdpComponentizationInfoResponse pdpComponentizationInfoResponse,
                                       List<PdpComponentizationCardsResponse> pdpComponentizationCardsResponseList) {
        info = pdpComponentizationInfoResponse;
        cardsList = pdpComponentizationCardsResponseList;
    }
}
