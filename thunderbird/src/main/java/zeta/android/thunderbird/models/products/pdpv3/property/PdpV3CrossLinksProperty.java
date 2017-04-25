package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import android.support.annotation.Nullable;

@AutoValue
public abstract class PdpV3CrossLinksProperty implements Parcelable{

    public static Builder create() {
        return new $AutoValue_PdpV3CrossLinksProperty.Builder();
    }

    @Nullable
    public abstract String getTitle();

    @Nullable
    public abstract String getUrl();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setTitle(@Nullable String title);

        public abstract Builder setUrl(@Nullable String url);

        public abstract PdpV3CrossLinksProperty build();
    }

}
