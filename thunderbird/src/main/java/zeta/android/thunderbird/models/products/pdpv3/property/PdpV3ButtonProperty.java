package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3ButtonProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3ButtonProperty.Builder();
    }

    @Nullable
    public abstract String getButtonType();

    @Nullable
    public abstract String getButtonPressAction();

    @Nullable
    public abstract String getButtonLongPressAction();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setButtonType(@Nullable String buttonType);

        public abstract Builder setButtonPressAction(@Nullable String discountedPrice);

        public abstract Builder setButtonLongPressAction(@Nullable String discount);

        public abstract PdpV3ButtonProperty build();
    }

}
