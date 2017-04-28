package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpSkuAvailabilityDetailMapObjectResponse {

    public final int sellerid;

    public final int storeid;

    public final String sellername;

    public final int availableCount;

    public final int sellableInventoryCount;

    public final String availableInWarehouses;

    public final int leadTime;

    public final String supplyType;

    public PdpSkuAvailabilityDetailMapObjectResponse(int sellerid,
                                                     int storeid,
                                                     String sellername,
                                                     int availableCount,
                                                     int sellableInventoryCount,
                                                     String availableInWarehouses,
                                                     int leadTime, String supplyType) {
        this.sellerid = sellerid;
        this.storeid = storeid;
        this.sellername = sellername;
        this.availableCount = availableCount;
        this.sellableInventoryCount = sellableInventoryCount;
        this.availableInWarehouses = availableInWarehouses;
        this.leadTime = leadTime;
        this.supplyType = supplyType;
    }
}
