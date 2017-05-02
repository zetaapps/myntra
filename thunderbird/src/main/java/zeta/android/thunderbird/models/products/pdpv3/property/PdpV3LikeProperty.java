package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3LikeProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3LikeProperty.Builder();
    }

    public abstract String getIsLiked();

    public abstract String getLikeCount();

    public abstract String getLikeAction();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setIsLiked(String liked);

        public abstract Builder setLikeCount(String likeCount);

        public abstract Builder setLikeAction(String action);

        public abstract PdpV3LikeProperty build();
    }
}
