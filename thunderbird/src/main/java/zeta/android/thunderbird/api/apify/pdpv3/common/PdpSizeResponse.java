package zeta.android.thunderbird.api.apify.pdpv3.common;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpSizeResponse {

    public final int skuId;
    public final int styleId;
    public final int inventory;
    public final String action;
    public final String label;
    public final boolean available;
    public final String seller;
    public final String supplyType;
    @Nullable
    @SerializedName("warehouses")
    public final List<String> warehouseList;
    public final Object sizeType;
    public final Object price;
    public final Object originalStyle;

    public PdpSizeResponse(int skuId, int styleId, int inventory, String action,
                           String label, boolean available, String seller,
                           String supplyType, @Nullable List<String> warehouseList,
                           Object sizeType, Object price, Object originalStyle) {
        this.skuId = skuId;
        this.styleId = styleId;
        this.inventory = inventory;
        this.action = action;
        this.label = label;
        this.available = available;
        this.seller = seller;
        this.supplyType = supplyType;
        this.warehouseList = warehouseList;
        this.sizeType = sizeType;
        this.price = price;
        this.originalStyle = originalStyle;
    }
}
