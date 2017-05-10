package zeta.android.thunderbird.api.apify.related.common;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpV3RelatedProductsRelatedPropsResponse {

    public final String type;

    @Nullable
    @SerializedName("products")
    public final List<PdpV3RelatedProductsProductResponse> pdpV3RelatedProductsProductResponseList;


    public PdpV3RelatedProductsRelatedPropsResponse(String type,
                                                    @Nullable List<PdpV3RelatedProductsProductResponse>
                                                            pdpV3RelatedProductsProductResponseList) {
        this.type = type;
        this.pdpV3RelatedProductsProductResponseList = pdpV3RelatedProductsProductResponseList;
    }
}