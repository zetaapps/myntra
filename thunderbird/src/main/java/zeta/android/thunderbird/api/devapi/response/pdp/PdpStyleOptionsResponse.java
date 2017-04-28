package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpStyleOptionsResponse {

    public final int id;

    public final String name;

    public final String value;

    public final String unifiedSize;

    public final String unifiedSizeValue;

    public final String allSize;

    public final int skuId;

    public final PdpSkuAvailabilityDetailMapResponse skuAvailabilityDetailMap;

    public final PdpWarehouseIdToItemCountMapResponse warehouseIdToItemCountMap;

    public final int inventoryCount;

    public final boolean available;

    public final boolean active;

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
