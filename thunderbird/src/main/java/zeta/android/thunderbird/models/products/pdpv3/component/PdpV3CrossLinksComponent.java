package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3CrossLinksProperty;

@AutoValue
public abstract class PdpV3CrossLinksComponent implements Parcelable {

    public static PdpV3CrossLinksComponent.Builder create() {
        return new $AutoValue_PdpV3CrossLinksComponent.Builder();
    }

    @Nullable
    public abstract List<PdpV3CrossLinksProperty> getPdpV3CrossLinksPropertyList();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3CrossLinksPropertyList(@Nullable List<PdpV3CrossLinksProperty> pdpV3CrossLinksPropertyList);

        public abstract PdpV3CrossLinksComponent build();
    }
}
