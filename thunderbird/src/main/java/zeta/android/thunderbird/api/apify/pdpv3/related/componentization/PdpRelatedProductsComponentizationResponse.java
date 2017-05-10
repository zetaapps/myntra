package zeta.android.thunderbird.api.apify.pdpv3.related.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpRelatedProductsComponentizationResponse {

    @SerializedName("cards")
    public final List<PdpRelatedProductsComponentizationCardsResponse> cardsList;

    public PdpRelatedProductsComponentizationResponse(
            List<PdpRelatedProductsComponentizationCardsResponse>
                    pdpRelatedProductsComponentizationCardsResponseList) {
        cardsList = pdpRelatedProductsComponentizationCardsResponseList;
    }

}