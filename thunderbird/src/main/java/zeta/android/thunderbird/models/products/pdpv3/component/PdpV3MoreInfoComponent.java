package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3MoreInfoProperty;

@AutoValue
public abstract class PdpV3MoreInfoComponent implements Parcelable {

    public static PdpV3MoreInfoComponent.Builder create() {
        return new $AutoValue_PdpV3MoreInfoComponent.Builder();
    }

    @Nullable
    public abstract List<PdpV3MoreInfoProperty> getPdpV3MoreInfoPropertyList();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3MoreInfoPropertyList(@Nullable List<PdpV3MoreInfoProperty> pdpV3MoreInfoPropertyList);

        public abstract PdpV3MoreInfoComponent build();
    }
}
