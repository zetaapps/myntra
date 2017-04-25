package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3ActionType;

@AutoValue
public abstract class PdpV3ActionProperty implements Parcelable {

    public static PdpV3ActionProperty.Builder create() {
        return new $AutoValue_PdpV3ActionProperty.Builder();
    }

    @Nullable
    @PdpV3ActionType
    public abstract String getActionType();

    @Nullable
    public abstract String getAction();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setActionType(@Nullable @PdpV3ActionType String title);

        public abstract Builder setAction(@Nullable String action);

        public abstract PdpV3ActionProperty build();
    }

}
