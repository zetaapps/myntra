package zeta.android.thunderbird.api.apify.related.common;


import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3PriceResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3BrandResponse;

public class PdpV3RelatedProductsProductResponse {

    public final int id;

    public final String name;

    public final PdpV3PriceResponse price;

    public final PdpV3BrandResponse brand;

    public final PdpRelatedProductsDefaultImageResponse defaultImage;

    public final String info;

    public final String baseColour;


    public PdpV3RelatedProductsProductResponse(Integer id, String name, PdpV3PriceResponse price,
                                               PdpV3BrandResponse brand,
                                               PdpRelatedProductsDefaultImageResponse defaultImage,
                                               String info, String baseColour) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.defaultImage = defaultImage;
        this.info = info;
        this.baseColour = baseColour;
    }
}
