package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpComponentizationOptionsResponse {

    public final int price;

    public final int mrp;

    @Nullable
    @SerializedName("warehouses")
    public final List<String> warehouseList;

    public final int leadTime;

    public final int returnPeriod;

    public final PdpComponentizationFlagsResponse flags;

    public PdpComponentizationOptionsResponse(int price,
                                              int mrp,
                                              @Nullable List<String> warehouseList,
                                              int leadTime,
                                              int returnPeriod,
                                              PdpComponentizationFlagsResponse flags) {
        this.price = price;
        this.mrp = mrp;
        this.warehouseList = warehouseList;
        this.leadTime = leadTime;
        this.returnPeriod = returnPeriod;
        this.flags = flags;
    }
}
