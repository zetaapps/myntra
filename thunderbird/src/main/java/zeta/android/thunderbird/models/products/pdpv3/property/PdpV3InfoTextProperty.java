package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3InfoTextProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3InfoTextProperty.Builder();
    }

    public abstract String getCollapsedText();

    public abstract String getExpandedText();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setCollapsedText(String collapsedText);

        public abstract Builder setExpandedText(String expandedText);

        public abstract PdpV3InfoTextProperty build();
    }
}
