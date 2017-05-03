package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3DiscountProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3DiscountProperty.Builder();
    }

    public abstract String getDiscountLabel();

    public abstract String getDescription();

    @Nullable
    public abstract String getMyntraCrash();

    @Nullable
    public abstract String getMyntraCoupon();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setDiscountLabel(String discountLabel);

        public abstract Builder setDescription(String description);

        public abstract Builder setMyntraCrash(@Nullable String myntraCrash);

        public abstract Builder setMyntraCoupon(@Nullable String coupon);

        public abstract PdpV3DiscountProperty build();
    }
}
