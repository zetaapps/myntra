package zeta.android.thunderbird.models.products.pdpv3.cards;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType;

@AutoValue
public abstract class PdpV3ServiceabilityCard implements Parcelable {

    public static Builder create() {
        return new AutoValue_PdpV3ServiceabilityCard.Builder()
                .setPdpV3CardType(PdpV3CardType.SERVICEABILITY);
    }

    @PdpV3CardType
    public abstract String getPdpV3CardType();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3CardType(@PdpV3CardType String cardType);

        public abstract PdpV3ServiceabilityCard build();
    }

}
