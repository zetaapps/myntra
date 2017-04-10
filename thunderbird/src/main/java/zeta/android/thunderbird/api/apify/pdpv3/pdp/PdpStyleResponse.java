package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpDescriptorResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpPriceResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpSizeResponse;

public class PdpStyleResponse {

    public final int id;
    public final String name;
    public final Object colours;
    public final PdpPriceResponse price;
    public final PdpMediaResponse media;

    @Nullable
    @SerializedName("sizes")
    public final List<PdpSizeResponse> sizeList;
    public final PdpBrandResponse brand;

    @Nullable
    @SerializedName("descriptors")
    public final List<PdpDescriptorResponse> descriptorList;
    public final PdpFlagsResponse flags;
    public final PdpAnalyticsResponse analytics;

    public PdpStyleResponse(int id, String name,
                            Object colours,
                            PdpPriceResponse price,
                            PdpMediaResponse media,
                            @Nullable List<PdpSizeResponse> sizeList,
                            PdpBrandResponse brand,
                            @Nullable List<PdpDescriptorResponse> descriptorList,
                            PdpFlagsResponse flags,
                            PdpAnalyticsResponse analytics) {
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
