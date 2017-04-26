package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3DisplayDataProperty implements Parcelable {

    public static PdpV3DisplayDataProperty.Builder create() {
        return new $AutoValue_PdpV3DisplayDataProperty.Builder();
    }

    @Nullable
    public abstract String getFirstButtonActionText();

    @Nullable
    public abstract String getFirstButtonText();

    @Nullable
    public abstract String getPersonalizedDescription();

    @Nullable
    public abstract String getPersonalizedLabel();

    @Nullable
    public abstract String getPersonalizedTitle();

    @Nullable
    public abstract String getSecondButtonActionText();

    @Nullable
    public abstract String getSecondButtonText();

    @Nullable
    public abstract Integer getButtonState();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setFirstButtonActionText(@Nullable String firstButtonActionText);

        public abstract Builder setFirstButtonText(@Nullable String firstButtonText);

        public abstract Builder setPersonalizedDescription(@Nullable String personalizedDescription);

        public abstract Builder setPersonalizedLabel(@Nullable String personalizedLabel);

        public abstract Builder setPersonalizedTitle(@Nullable String personalizedTitle);

        public abstract Builder setSecondButtonActionText(@Nullable String secondButtonActionText);

        public abstract Builder setSecondButtonText(@Nullable String secondButtonText);

        public abstract Builder setButtonState(@Nullable Integer buttonState);

        public abstract PdpV3DisplayDataProperty build();
    }
}
