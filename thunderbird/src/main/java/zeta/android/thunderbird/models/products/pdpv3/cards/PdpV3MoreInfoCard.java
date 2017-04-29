package zeta.android.thunderbird.models.products.pdpv3.cards;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.LinkedHashMap;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3MoreInfoComponent;

@AutoValue
public abstract class PdpV3MoreInfoCard implements Parcelable {

    public static Builder create() {
        return new AutoValue_PdpV3MoreInfoCard.Builder()
                .setPdpV3CardType(PdpV3CardType.MORE_INFO_CARD);
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
    public abstract PdpV3MoreInfoComponent getPdpV3MoreInfoComponent();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3CardType(@PdpV3CardType String cardType);

        public abstract Builder setComponentPositionsIndex(@PdpV3ComponentType LinkedHashMap<String, Integer> componentPositionsIndex);

        public abstract Builder setPdpV3MoreInfoComponent(@Nullable PdpV3MoreInfoComponent pdpV3MoreInfoComponent);

        public abstract PdpV3MoreInfoCard build();
    }

}
