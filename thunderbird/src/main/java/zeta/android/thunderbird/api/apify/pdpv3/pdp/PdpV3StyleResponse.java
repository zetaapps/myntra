package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3DescriptorResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3PriceResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3SizeResponse;

public class PdpV3StyleResponse {

    public final int id;
    public final String name;
    public final Object colours;
    public final PdpV3PriceResponse price;
    public final PdpV3MediaResponse media;

    @Nullable
    @SerializedName("sizes")
    public final List<PdpV3SizeResponse> sizeList;
    public final PdpV3BrandResponse brand;

    @Nullable
    @SerializedName("descriptors")
    public final List<PdpV3DescriptorResponse> descriptorList;
    public final PdpV3FlagsResponse flags;
    public final PdpV3AnalyticsResponse analytics;

    public PdpV3StyleResponse(int id, String name,
                              Object colours,
                              PdpV3PriceResponse price,
                              PdpV3MediaResponse media,
                              @Nullable List<PdpV3SizeResponse> sizeList,
                              PdpV3BrandResponse brand,
                              @Nullable List<PdpV3DescriptorResponse> descriptorList,
                              PdpV3FlagsResponse flags,
                              PdpV3AnalyticsResponse analytics) {
        this.id = id;
        this.name = name;
        this.colours = colours;
        this.price = price;
        this.media = media;
        this.sizeList = sizeList;
        this.brand = brand;
        this.descriptorList = descriptorList;
        this.flags = flags;
        this.analytics = analytics;
    }
}
