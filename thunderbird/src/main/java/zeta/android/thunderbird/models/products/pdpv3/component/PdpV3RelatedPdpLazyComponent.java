package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ActionProperty;

@AutoValue
public abstract class PdpV3RelatedPdpLazyComponent implements Parcelable {
    public static PdpV3RelatedPdpLazyComponent.Builder create() {
        return new $AutoValue_PdpV3RelatedPdpLazyComponent.Builder();
    }

    @Nullable
    public abstract PdpV3ActionProperty getPdpV3ActionProperty();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3ActionProperty(@Nullable PdpV3ActionProperty pdpV3ActionProperty);

        public abstract PdpV3RelatedPdpLazyComponent build();
    }
}
