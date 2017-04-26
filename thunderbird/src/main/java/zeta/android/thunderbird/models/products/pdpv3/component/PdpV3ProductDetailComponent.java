package zeta.android.thunderbird.models.products.pdpv3.component;


import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ProductDetailProperty;

@AutoValue
public abstract class PdpV3ProductDetailComponent implements Parcelable {

    public static PdpV3CrossLinksComponent.Builder create() {
        return new $AutoValue_PdpV3CrossLinksComponent.Builder();
    }

    @Nullable
    public abstract List<PdpV3ProductDetailProperty> getPdpV3ProductDetailPropertyList();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3ProductDetailPropertyList(@Nullable List<PdpV3ProductDetailProperty> pdpV3ProductDetailPropertyList);

        public abstract PdpV3ProductDetailComponent build();

    }

}
