package zeta.android.thunderbird.api.devapi.response.pdp;



public class PdpSkuAvailabilityDetailMapObjectResponse {

    public int sellerid;

    public int storeid;

    public String sellername;

    public int availableCount;

    public int sellableInventoryCount;

    public String availableInWarehouses;

    public int leadTime;

    public String supplyType;

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
