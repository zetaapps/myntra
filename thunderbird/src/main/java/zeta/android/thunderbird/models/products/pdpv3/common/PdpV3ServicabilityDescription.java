package zeta.android.thunderbird.models.products.pdpv3.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class PdpV3ServicabilityDescription implements Parcelable, StringId {

    public static PdpV3ServicabilityDescription create(String pdpV3ServicabilityDescription) {
        return new AutoValue_PdpV3ServicabilityDescription(pdpV3ServicabilityDescription);
    }

}
