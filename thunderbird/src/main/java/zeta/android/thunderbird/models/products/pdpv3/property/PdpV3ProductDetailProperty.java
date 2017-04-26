package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3ProductDetailProperty implements Parcelable {

    public static PdpV3ProductDetailProperty.Builder create() {
        return new $AutoValue_PdpV3ProductDetailProperty.Builder();
    }

    @Nullable
    public abstract String getPdpV3ProductDetailType();

    @Nullable
    public abstract String getPdpV3ProductDetailContent();

    @Nullable
    public abstract String getPdpV3ProductDetailTitle();

    @Nullable
    public abstract String getPdpV3ProductDetailDescription();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3ProductDetailType(@Nullable String pdpV3ProductDetailType);

        public abstract Builder setPdpV3ProductDetailContent(@Nullable String pdpV3ProductDetailContent);

        public abstract Builder setPdpV3ProductDetailTitle(@Nullable String pdpV3ProductDetailTitle);

        public abstract Builder setPdpV3ProductDetailDescription(@Nullable String pdpV3ProductDetailDescription);

        public abstract PdpV3ProductDetailProperty build();
    }

}
