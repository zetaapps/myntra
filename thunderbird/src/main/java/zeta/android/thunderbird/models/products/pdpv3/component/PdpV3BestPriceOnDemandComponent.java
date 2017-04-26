package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ActionType;

@AutoValue
public abstract class PdpV3BestPriceOnDemandComponent implements Parcelable {

    public static PdpV3BestPriceOnDemandComponent.Builder create() {
        return new $AutoValue_PdpV3BestPriceOnDemandComponent.Builder();
    }

    @Nullable
    public abstract String getAction();

    @Nullable
    @PdpV3ActionType
    public abstract String getActionType();

    @Nullable
    public abstract String getInitialText();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setAction(@Nullable String action);

        public abstract Builder setActionType(@Nullable @PdpV3ActionType String actionType);

        public abstract Builder setInitialText(@Nullable String initialText);

        public abstract PdpV3BestPriceOnDemandComponent build();
    }

}
