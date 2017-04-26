package zeta.android.thunderbird.models.products.pdpv3.cards;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.LinkedHashMap;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3CardType;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3BestPriceOnDemandComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ButtonsComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ImageComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3InfoComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3SizeSelectorComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3VatInfoComponent;

@AutoValue
public abstract class PdpV3ProductCard implements Parcelable {

    public static Builder create() {
        return new AutoValue_PdpV3ProductCard.Builder()
                .setPdpV3CardType(PdpV3CardType.PRODUCT);
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
    public abstract PdpV3ImageComponent getPdpV3ImageComponent();

    @Nullable
    public abstract PdpV3InfoComponent getPdpV3InfoComponent();

    @Nullable
    public abstract PdpV3VatInfoComponent getPdpV3VatInfoComponent();

    @Nullable
    public abstract PdpV3BestPriceOnDemandComponent getPdpV3BestPriceOnDemandComponent();

    @Nullable
    public abstract PdpV3SizeSelectorComponent getPdpV3SizeSelectorComponent();

    @Nullable
    public abstract PdpV3ButtonsComponent getPdpV3ButtonsComponent();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3CardType(@PdpV3CardType String cardType);

        public abstract Builder setComponentPositionsIndex(@PdpV3ComponentType LinkedHashMap<String, Integer> componentPositionsIndex);

        public abstract Builder setPdpV3ImageComponent(@Nullable PdpV3ImageComponent pdpV3ImageComponent);

        public abstract Builder setPdpV3InfoComponent(@Nullable PdpV3InfoComponent pdpV3InfoComponent);

        public abstract Builder setPdpV3VatInfoComponent(@Nullable PdpV3VatInfoComponent pdpV3VatInfoComponent);

        public abstract Builder setPdpV3BestPriceOnDemandComponent(@Nullable PdpV3BestPriceOnDemandComponent pdpV3BestPriceOnDemandComponent);

        public abstract Builder setPdpV3SizeSelectorComponent(@Nullable PdpV3SizeSelectorComponent pdpV3SizeSelectorComponent);

        public abstract Builder setPdpV3ButtonsComponent(@Nullable PdpV3ButtonsComponent pdpV3ButtonsComponent);

        public abstract PdpV3ProductCard build();
    }

}
