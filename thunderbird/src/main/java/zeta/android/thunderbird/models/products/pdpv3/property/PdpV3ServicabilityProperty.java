package zeta.android.thunderbird.models.products.pdpv3.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3Pincode;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3ServicabilityDescription;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3WareHouse;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ServicabilityComponent;

@AutoValue
public abstract class PdpV3ServicabilityProperty implements Parcelable {

    public static PdpV3ServicabilityProperty.Builder create(Integer sellingPrice, Integer maximumRetailPrice) {
        return new $AutoValue_PdpV3ServicabilityProperty.Builder()
                .setPdpV3ProductSellingPrice(sellingPrice)
                .setPdpV3ProductMaximumRetailPrice(maximumRetailPrice);
    }

    @Nullable
    public abstract List<PdpV3ServicabilityDescription> getPdpV3ServicabilityDescriptorList();

    @Nullable
    public abstract String getPdpV3ServicabilityAction();

    @Nullable
    public abstract PdpV3Pincode getPdpV3Pincode();

    public abstract Integer getPdpV3ProductSellingPrice();

    public abstract Integer getPdpV3ProductMaximumRetailPrice();

    @Nullable
    public abstract List<PdpV3WareHouse> getPdpV3WareHouseList();

    @Nullable
    public abstract Integer getPdpV3ProductLeadTime();

    @Nullable
    public abstract Integer getPdpV3ProductReturnPeriod();

    @Nullable
    public abstract Boolean getPdpV3ProductIsHazmat();

    @Nullable
    public abstract Boolean getPdpV3ProductIsFragile();

    @Nullable
    public abstract Boolean getPdpV3ProductIsJewellery();

    @Nullable
    public abstract Boolean getPdpV3ProductIsExchangeable();

    @Nullable
    public abstract Boolean getPdpV3ProductPickupEnabled();

    @Nullable
    public abstract Boolean getPdpV3ProductIsTryable();

    @Nullable
    public abstract Boolean getPdpV3ProductIsLarge();

    @Nullable
    public abstract Boolean getPdpV3ProductIsReturnable();

    @Nullable
    public abstract Boolean getPdpV3CodeEnabled();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3ServicabilityDescriptorList(@Nullable List<PdpV3ServicabilityDescription> pdpV3ServicabilityDescriptorList);

        public abstract Builder setPdpV3ServicabilityAction(@Nullable String pdpV3Servicabilityaction);

        public abstract Builder setPdpV3Pincode(@Nullable PdpV3Pincode pdpV3Pincode);

        public abstract Builder setPdpV3ProductSellingPrice(Integer productSellingPrice);

        public abstract Builder setPdpV3ProductMaximumRetailPrice(Integer productMaximumRetailPrice);

        public abstract Builder setPdpV3WareHouseList(@Nullable List<PdpV3WareHouse> pdpV3WareHouseList);

        public abstract Builder setPdpV3ProductLeadTime(@Nullable Integer productSLeadTime);

        public abstract Builder setPdpV3ProductReturnPeriod(@Nullable Integer productReturnPeriod);

        public abstract Builder setPdpV3ProductIsHazmat(@Nullable Boolean isHazmat);

        public abstract Builder setPdpV3ProductIsFragile(@Nullable Boolean isFagile);

        public abstract Builder setPdpV3ProductIsJewellery(@Nullable Boolean isJewellery);

        public abstract Builder setPdpV3ProductIsExchangeable(@Nullable Boolean isExchangeable);

        public abstract Builder setPdpV3ProductPickupEnabled(@Nullable Boolean pickupEnabled);

        public abstract Builder setPdpV3ProductIsTryable(@Nullable Boolean isTryable);

        public abstract Builder setPdpV3ProductIsLarge(@Nullable Boolean isLarge);

        public abstract Builder setPdpV3ProductIsReturnable(@Nullable Boolean isReturnable);

        public abstract Builder setPdpV3CodeEnabled(@Nullable Boolean codeEnabled);

        public abstract PdpV3ServicabilityProperty build();
    }

}
