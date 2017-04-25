package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpMoreInfoProperty implements Parcelable{

    public static Builder create() {
        return new $AutoValue_PdpMoreInfoProperty.Builder();
    }

    @Nullable
    public abstract String getTitle();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getAction();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setTitle(@Nullable String title);

        public abstract Builder setDescription(@Nullable String description);

        public abstract Builder setAction(@Nullable String action);

        public abstract PdpMoreInfoProperty build();
    }

}
