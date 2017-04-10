package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ComponentizationOptions {
    public Number price;
    public Number mrp;
    @SerializedName("warehouses")
    public List<String> warehouseList = null;
    public Number leadTime;
    public Number returnPeriod;
    public ComponentizationFlags flags;
}
