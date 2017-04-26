package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3VatInfoComponent implements Parcelable {

    public static PdpV3VatInfoComponent.Builder create() {
        return new $AutoValue_PdpV3VatInfoComponent.Builder();
    }

    @Nullable
    public abstract String getPdpV3VatInfo();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3VatInfo(@Nullable String pdpV3VatInfo);

        public abstract PdpV3VatInfoComponent build();
    }

}
