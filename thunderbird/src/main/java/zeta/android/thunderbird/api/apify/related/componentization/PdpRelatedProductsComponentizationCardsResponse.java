package zeta.android.thunderbird.api.apify.related.componentization;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpRelatedProductsComponentizationCardsResponse {

    @Nullable
    @SerializedName("components")
    public final List<PdpV3RelatedProductsComponentizationComponentsResponse> pdpV3ComponentizationComponentsResponseList;

    public PdpRelatedProductsComponentizationCardsResponse(
            @Nullable List<PdpV3RelatedProductsComponentizationComponentsResponse>
                    pdpV3ComponentizationComponentsResponseList) {
        this.pdpV3ComponentizationComponentsResponseList = pdpV3ComponentizationComponentsResponseList;
    }

}
