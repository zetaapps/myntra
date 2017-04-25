package zeta.android.thunderbird.models.products.pdpv3.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class PdpV3WareHouse implements Parcelable, StringId {

    public static PdpV3WareHouse create(String pdpV3WareHouse) {
        return new AutoValue_PdpV3WareHouse(pdpV3WareHouse);
    }

}
