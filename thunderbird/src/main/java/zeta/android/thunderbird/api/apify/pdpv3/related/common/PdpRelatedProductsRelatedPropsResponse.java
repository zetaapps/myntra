package zeta.android.thunderbird.api.apify.pdpv3.related.common;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpRelatedProductsRelatedPropsResponse {

    public final String type;

    @Nullable
    @SerializedName("products")
    public final List<PdpRelatedProductsProductResponse> pdpRelatedProductsProductResponseList;


    public PdpRelatedProductsRelatedPropsResponse(String type,
                                                  @Nullable List<PdpRelatedProductsProductResponse>
                                                          pdpRelatedProductsProductResponseList) {
        this.type = type;
        this.pdpRelatedProductsProductResponseList = pdpRelatedProductsProductResponseList;
    }

}