package zeta.android.thunderbird.api.devapi.response.pdp;


public class PdpStyleOptionsResponse {

    public int id;

    public String name;

    public String value;

    public String unifiedSize;

    public String unifiedSizeValue;

    public String allSize;

    public int skuId;

    public PdpSkuAvailabilityDetailMapResponse skuAvailabilityDetailMap;

    public PdpWarehouseIdToItemCountMapResponse warehouseIdToItemCountMap;

    public int inventoryCount;

    public boolean available;

    public boolean active;

    public PdpStyleOptionsResponse(int id,
                                   String name,
                                   String value,
                                   String unifiedSize,
                                   String unifiedSizeValue,
                                   String allSize,
                                   int skuId,
                                   PdpSkuAvailabilityDetailMapResponse skuAvailabilityDetailMap,
                                   PdpWarehouseIdToItemCountMapResponse warehouseIdToItemCountMap,
                                   int inventoryCount,
                                   boolean available,
                                   boolean active) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.unifiedSize = unifiedSize;
        this.unifiedSizeValue = unifiedSizeValue;
        this.allSize = allSize;
        this.skuId = skuId;
        this.skuAvailabilityDetailMap = skuAvailabilityDetailMap;
        this.warehouseIdToItemCountMap = warehouseIdToItemCountMap;
        this.inventoryCount = inventoryCount;
        this.available = available;
        this.active = active;
    }
}
