package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PdpComponentizationOptionsResponse {
    public double price;
    public double mrp;
    @SerializedName("warehouses")
    public List<String> warehouseList = null;
    public int leadTime;
    public int returnPeriod;
    public PdpComponentizationFlagsResponse flags;
}
