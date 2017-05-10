package zeta.android.thunderbird.api.apify.related.componentization;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.related.componentization.PdpRelatedProductsComponentizationCardsResponse;

public class PdpV3RelatedProductsComponentizationResponse {

    @SerializedName("cards")
    public final List<PdpRelatedProductsComponentizationCardsResponse> cardsList;

    public PdpV3RelatedProductsComponentizationResponse(
                                       List<PdpRelatedProductsComponentizationCardsResponse>
                                               pdpRelatedProductsComponentizationCardsResponseList) {
        cardsList = pdpRelatedProductsComponentizationCardsResponseList;
    }

}
