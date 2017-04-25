package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3LikeProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3MediaProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3RelatedProperty;

@AutoValue
public abstract class PdpV3ImageComponent implements Parcelable {

    public static PdpV3ImageComponent.Builder create() {
        return new $AutoValue_PdpV3ImageComponent.Builder();
    }

    public abstract List<PdpV3MediaProperty> getImageAndVideoMediaProperty();

    @Nullable
    public abstract PdpV3RelatedProperty getRelatedProperty();

    @Nullable
    public abstract PdpV3LikeProperty getLikeProperty();

    @Nullable
    public abstract String getBaseColorProperty();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setImageAndVideoMediaProperty(List<PdpV3MediaProperty> media);

        public abstract Builder setRelatedProperty(@Nullable PdpV3RelatedProperty relatedComponent);

        public abstract Builder setLikeProperty(@Nullable PdpV3LikeProperty likeComponent);

        public abstract Builder setBaseColorProperty(@Nullable String baseColor);

        public abstract PdpV3ImageComponent build();
    }

}
