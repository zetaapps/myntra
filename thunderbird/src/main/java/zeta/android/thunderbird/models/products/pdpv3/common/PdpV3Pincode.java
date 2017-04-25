package zeta.android.thunderbird.models.products.pdpv3.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class PdpV3Pincode implements Parcelable, StringId {

    public static PdpV3Pincode create(String pdpV3Pincode) {
        return new AutoValue_PdpV3Pincode(pdpV3Pincode);
    }

}
