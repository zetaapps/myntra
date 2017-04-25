package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import android.support.annotation.Nullable;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3SocialTitle;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ActionProperty;

@AutoValue
public abstract class PdpV3LikersLazyComponent implements Parcelable {

    public static PdpV3LikersLazyComponent.Builder create() {
        return new $AutoValue_PdpV3LikersLazyComponent.Builder();
    }

    @Nullable
    public abstract PdpV3ActionProperty getPdpV3ActionProperty();

    @Nullable
    public abstract PdpV3SocialTitle getLikersTitle();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3ActionProperty(@Nullable PdpV3ActionProperty pdpV3ActionProperty);

        public abstract Builder setLikersTitle(@Nullable PdpV3SocialTitle title);

        public abstract PdpV3LikersLazyComponent build();
    }

}
