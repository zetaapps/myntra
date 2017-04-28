package zeta.android.thunderbird.models.products.pdpv3.cards;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3LikeComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3MediaComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3RelatedComponent;

@AutoValue
public abstract class PdpV3ImageCard implements Parcelable {

    public static PdpV3ImageCard.Builder create() {
        return new $AutoValue_PdpV3ImageCard.Builder();
    }

    @PdpV3CardType
    public abstract String getCardType();

    public abstract List<PdpV3MediaComponent> getImageAndVideoMediaComponent();

    @Nullable
    public abstract PdpV3RelatedComponent getRelatedComponent();

    @Nullable
    public abstract PdpV3LikeComponent getLikeComponent();

    @Nullable
    public abstract String getBaseColor();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setCardType(@PdpV3CardType String cardType);

        public abstract Builder setImageAndVideoMediaComponent(List<PdpV3MediaComponent> media);

        public abstract Builder setRelatedComponent(@Nullable PdpV3RelatedComponent relatedComponent);

        public abstract Builder setLikeComponent(@Nullable PdpV3LikeComponent likeComponent);

        public abstract Builder setBaseColor(@Nullable String baseColor);

        public abstract PdpV3ImageCard build();
    }

}
