package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ActionType;

@AutoValue
public abstract class PdpV3RelatedProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3RelatedProperty.Builder();
    }

    public abstract boolean getHasColors();

    public abstract String getAction();

    @PdpV3ActionType
    public abstract String getActionType();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setHasColors(boolean hasColors);

        public abstract Builder setAction(String action);

        public abstract Builder setActionType(@PdpV3ActionType String actionType);

        public abstract PdpV3RelatedProperty build();
    }
}
