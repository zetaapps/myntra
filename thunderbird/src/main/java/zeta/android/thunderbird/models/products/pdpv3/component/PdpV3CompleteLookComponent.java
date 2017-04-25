package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3SocialTitle;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3StyleNote;

@AutoValue
public abstract class PdpV3CompleteLookComponent implements Parcelable {

    public static PdpV3CompleteLookComponent.Builder create() {
        return new $AutoValue_PdpV3CompleteLookComponent.Builder();
    }

    @Nullable
    public abstract PdpV3StyleNote getPdpV3StyleNote();

    @Nullable
    public abstract PdpV3SocialTitle getSocialTitle();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3StyleNote(@Nullable PdpV3StyleNote pdpV3StyleNote);

        public abstract Builder setSocialTitle(@Nullable PdpV3SocialTitle completelookTitle);

        public abstract PdpV3CompleteLookComponent build();
    }

}
