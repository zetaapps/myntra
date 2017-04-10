package zeta.android.thunderbird.api.apify.pdpv3.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PdpSizeResponse {
    public int skuId;
    public int styleId;
    public int inventory;
    public String action;
    public String label;
    public boolean available;
    public String seller;
    public String supplyType;
    @SerializedName("warehouses")
    public List<String>  warehouseList = null;
    public Object sizeType;
    public Object price;
    public Object originalStyle;
}
