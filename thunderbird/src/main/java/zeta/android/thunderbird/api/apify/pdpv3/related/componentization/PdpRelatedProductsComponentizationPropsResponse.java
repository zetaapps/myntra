package zeta.android.thunderbird.api.apify.pdpv3.related.componentization;


import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.related.common.PdpRelatedProductsRelatedPropsResponse;

public class PdpRelatedProductsComponentizationPropsResponse {

    @Nullable
    @SerializedName("related")
    public final List<PdpRelatedProductsRelatedPropsResponse> pdpRelatedProductsRelatedPropsResponseList;

    public PdpRelatedProductsComponentizationPropsResponse(List<PdpRelatedProductsRelatedPropsResponse>
                                                                     pdpRelatedProductsRelatedPropsResponseList) {
        this.pdpRelatedProductsRelatedPropsResponseList = pdpRelatedProductsRelatedPropsResponseList;
    }
}