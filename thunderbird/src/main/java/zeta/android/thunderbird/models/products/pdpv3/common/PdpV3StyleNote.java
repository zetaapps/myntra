package zeta.android.thunderbird.models.products.pdpv3.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class PdpV3StyleNote implements Parcelable, StringId {

    public static PdpV3StyleNote create(String pdpV3StyleNote) {
        return new AutoValue_PdpV3StyleNote(pdpV3StyleNote);
    }

}
