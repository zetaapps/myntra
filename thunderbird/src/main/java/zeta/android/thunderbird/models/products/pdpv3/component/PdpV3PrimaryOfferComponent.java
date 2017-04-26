package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3BestPriceLazyLoadedProperty;

@AutoValue
public abstract class PdpV3PrimaryOfferComponent implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3PrimaryOfferComponent.Builder();
    }

    @Nullable
    public abstract PdpV3BestPriceLazyLoadedProperty getPdpV3BestPriceLazyLoadedProperty();

    @Nullable
    public abstract String getAction();

    @Nullable
    public abstract Integer getOfferCount();

    @Nullable
    public abstract String getBankOffer();

    @Nullable
    public abstract String getPrimaryOffer();

    @Nullable
    public abstract Integer getMaxDurationForOffer();

    @Nullable
    public abstract Integer getMinimumInterestRateForOffer();


    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3BestPriceLazyLoadedProperty(@Nullable PdpV3BestPriceLazyLoadedProperty pdpV3BestPriceLazyLoadedProperty);

        public abstract Builder setAction(@Nullable String action);

        public abstract Builder setOfferCount(@Nullable Integer offerCount);

        public abstract Builder setBankOffer(@Nullable String bankOffer);

        public abstract Builder setPrimaryOffer(@Nullable String primaryOffer);

        public abstract Builder setMaxDurationForOffer(@Nullable Integer maxDurationForOffer);

        public abstract Builder setMinimumInterestRateForOffer(@Nullable Integer minimumInterestRateForOffer);

        public abstract PdpV3PrimaryOfferComponent build();
    }


}



