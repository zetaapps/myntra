package zeta.android.thunderbird.models.products.pdpv3.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class PdpV3ServicabilityPlaceHolder implements Parcelable, StringId {

    public static PdpV3ServicabilityPlaceHolder create(String pdpV3PlaceHolder) {
        return new AutoValue_PdpV3ServicabilityPlaceHolder(pdpV3PlaceHolder);
    }

}
