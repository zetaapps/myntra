package zeta.android.thunderbird.api.apify.related.general;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.related.common.PdpV3RelatedProductsRelatedPropsResponse;

public class PdpV3RelatedProductsResponse {

    @Nullable
    @SerializedName("related")
    public final List<PdpV3RelatedProductsRelatedPropsResponse> pdpV3RelatedProductsRelatedPropsResponseList;


    public PdpV3RelatedProductsResponse(@Nullable List<PdpV3RelatedProductsRelatedPropsResponse>
                                                pdpV3RelatedProductsRelatedPropsResponseList) {
        this.pdpV3RelatedProductsRelatedPropsResponseList = pdpV3RelatedProductsRelatedPropsResponseList;
    }
}
