package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpMoreInfoProperty;

@AutoValue
public abstract class PdpMoreInfoComponent implements Parcelable {

    public static PdpMoreInfoComponent.Builder create() {
        return new $AutoValue_PdpMoreInfoComponent.Builder();
    }

    @Nullable
    public abstract List<PdpMoreInfoProperty> getPdpMoreInfoPropertyList();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpMoreInfoPropertyList(@Nullable List<PdpMoreInfoProperty> pdpMoreInfoPropertyList);

        public abstract PdpMoreInfoComponent build();
    }
}
