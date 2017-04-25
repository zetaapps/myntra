package zeta.android.thunderbird.models.products.pdpv3.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class PdpV3ServicabilityTitle implements Parcelable, StringId {

    public static PdpV3ServicabilityTitle create(String pdpV3ServicabilityTitle) {
        return new AutoValue_PdpV3ServicabilityTitle(pdpV3ServicabilityTitle);
    }

}

