package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3InfoTextProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3PriceProperty;

@AutoValue
public abstract class PdpV3InfoComponent implements Parcelable {

    public static PdpV3InfoComponent.Builder create() {
        return new $AutoValue_PdpV3InfoComponent.Builder();
    }

    public abstract PdpV3InfoTextProperty getInfoTextProperty();

    public abstract PdpV3PriceProperty getPriceProperty();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPriceProperty(PdpV3PriceProperty priceProperty);

        public abstract Builder setInfoTextProperty(PdpV3InfoTextProperty infoTextProperty);

        public abstract PdpV3InfoComponent build();
    }

}
