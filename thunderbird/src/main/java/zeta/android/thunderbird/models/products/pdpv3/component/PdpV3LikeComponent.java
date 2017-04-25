package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PdpV3LikeComponent implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3LikeComponent.Builder();
    }

    public abstract boolean getIsLiked();

    public abstract String getLikeCount();

    public abstract String getLikeAction();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setIsLiked(boolean liked);

        public abstract Builder setLikeCount(String likeCount);

        public abstract Builder setLikeAction(String action);

        public abstract PdpV3LikeComponent build();
    }
}
