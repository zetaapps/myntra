package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3PriceProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3PriceProperty.Builder();
    }

    public abstract int getMrpPrice();

    public abstract int getDiscountedPrice();

    public abstract PdpV3DiscountProperty getDiscountProperty();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setMrpPrice(int mrpPrice);

        public abstract Builder setDiscountedPrice(int discountedPrice);

        public abstract Builder setDiscountProperty(PdpV3DiscountProperty discount);

        public abstract PdpV3PriceProperty build();
    }
}
