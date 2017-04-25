package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpAlbumResponse {

    public final String name;

    @Nullable
    @SerializedName("images")
    public final List<PdpV3ImageResponse> pdpImageResponseList;

    public PdpAlbumResponse(String name,
                            @Nullable List<PdpV3ImageResponse> pdpImageResponseList) {
        this.name = name;
        this.pdpImageResponseList = pdpImageResponseList;
    }
}
