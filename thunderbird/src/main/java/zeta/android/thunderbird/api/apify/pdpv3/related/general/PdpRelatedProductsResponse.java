package zeta.android.thunderbird.api.apify.pdpv3.related.general;


import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.related.common.PdpRelatedProductsRelatedPropsResponse;

public class PdpRelatedProductsResponse {

    @Nullable
    @SerializedName("related")
    public final List<PdpRelatedProductsRelatedPropsResponse> pdpRelatedProductsRelatedPropsResponseList;


    public PdpRelatedProductsResponse(@Nullable List<PdpRelatedProductsRelatedPropsResponse>
                                                pdpRelatedProductsRelatedPropsResponseList) {
        this.pdpRelatedProductsRelatedPropsResponseList = pdpRelatedProductsRelatedPropsResponseList;
    }
}