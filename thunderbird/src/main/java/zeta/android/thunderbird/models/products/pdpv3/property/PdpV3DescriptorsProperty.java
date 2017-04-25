package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3DescriptorsProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3DescriptorsProperty.Builder();
    }

    public abstract String getTitle();

    public abstract String getDescription();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setTitle(String title);

        public abstract Builder setDescription(String description);

        public abstract PdpV3DescriptorsProperty build();
    }
}
