package zeta.android.thunderbird.models.products.pdpv3.cards;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.LinkedHashMap;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3CompleteLookComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3LikersLazyComponent;


@AutoValue
public abstract class PdpV3SocialCard implements Parcelable {

    public static Builder create() {
        return new AutoValue_PdpV3SocialCard.Builder()
                .setPdpV3CardType(PdpV3CardType.SOCIAL);
    }

    @PdpV3CardType
    public abstract String getPdpV3CardType();

    /**
     * Component position order to render in the UI elements.
     *
     * @return : Given the PdpV3CardType this should return the position.
     */
    @PdpV3ComponentType
    public abstract LinkedHashMap<String, Integer> getComponentPositionsIndex();

    @Nullable
    public abstract PdpV3LikersLazyComponent getPdpV3LikersLazyComponent();

    @Nullable
    public abstract PdpV3CompleteLookComponent getPdpV3CompleteLookComponent();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3CardType(@PdpV3CardType String cardType);

        public abstract Builder setComponentPositionsIndex(@PdpV3ComponentType LinkedHashMap<String, Integer> componentPositionsIndex);

        public abstract Builder setPdpV3LikersLazyComponent(@Nullable PdpV3LikersLazyComponent pdpV3LikersLazyComponent);

        public abstract Builder setPdpV3CompleteLookComponent(@Nullable PdpV3CompleteLookComponent pdpV3CompleteLookComponent);

        public abstract PdpV3SocialCard build();
    }

}
