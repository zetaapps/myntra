package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationOffersResponse {

    public final int count;
    public final String action;
    public final PdpComponentizationBestPriceLoadResponse bestPriceLazyLoaded;

    public PdpComponentizationOffersResponse(int count,
                                             String action,
                                             PdpComponentizationBestPriceLoadResponse bestPriceLazyLoaded) {
        this.count = count;
        this.action = action;
        this.bestPriceLazyLoaded = bestPriceLazyLoaded;
    }
}
