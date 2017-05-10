package zeta.android.thunderbird.api.apify.pdpv3.related.componentization;


import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpRelatedProductsComponentizationCardsResponse {

    @Nullable
    @SerializedName("components")
    public final List<PdpRelatedProductsComponentizationComponentsResponse> pdpV3ComponentizationComponentsResponseList;

    public PdpRelatedProductsComponentizationCardsResponse(
            @Nullable List<PdpRelatedProductsComponentizationComponentsResponse>
                    pdpV3ComponentizationComponentsResponseList) {
        this.pdpV3ComponentizationComponentsResponseList = pdpV3ComponentizationComponentsResponseList;
    }

}