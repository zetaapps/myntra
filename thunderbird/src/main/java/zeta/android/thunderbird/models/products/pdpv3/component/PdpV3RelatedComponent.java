package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.ActionType;

@AutoValue
public abstract class PdpV3RelatedComponent implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3RelatedComponent.Builder();
    }

    public abstract boolean getHasColors();

    public abstract String getAction();

    @ActionType
    public abstract String getActionType();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setHasColors(boolean hasColors);

        public abstract Builder setAction(String action);

        public abstract Builder setActionType(@ActionType String actionType);

        public abstract PdpV3RelatedComponent build();
    }
}
