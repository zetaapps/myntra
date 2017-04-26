package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class PdpV3ButtonStateProperty implements Parcelable{

    public static Builder create() {
        return new $AutoValue_PdpV3ButtonStateProperty.Builder();
    }

    @Nullable
    public abstract Integer getButtonState();

    @Nullable
    public abstract List<PdpV3ButtonProperty> getPdpV3ButtonPropertyList();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setButtonState(@Nullable Integer buttonState);

        public abstract Builder setPdpV3ButtonPropertyList(@Nullable List<PdpV3ButtonProperty> pdpV3ButtonPropertyList);

        public abstract PdpV3ButtonStateProperty build();
    }

}
