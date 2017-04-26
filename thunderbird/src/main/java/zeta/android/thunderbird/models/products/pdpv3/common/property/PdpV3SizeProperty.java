package zeta.android.thunderbird.models.products.pdpv3.common.property;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.thunderbird.models.products.common.ProductSizeVariantId;
import zeta.android.thunderbird.models.products.common.ProductSizeSkuId;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3WareHouse;
import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ProductSupplyType;

@AutoValue
public abstract class PdpV3SizeProperty implements Parcelable {

    public static Builder create() {
        return new $AutoValue_PdpV3SizeProperty.Builder();
    }


    public abstract ProductSizeVariantId getProductSizeVariantId();

    public abstract ProductSizeSkuId getProductSizeSkuId();

    public abstract ProductId getProductId();

    @Nullable
    public abstract Integer getInventoryCount();

    @Nullable
    public abstract String getRelatedSizeProductAction();

    public abstract String getSizeLabel();

    public abstract Boolean getIsSizeAvailable();

    @Nullable
    public abstract String getSellerInformation();

    @Nullable
    @PdpV3ProductSupplyType
    public abstract String getPdpV3ProductSupplyType();

    @Nullable
    public abstract List<PdpV3WareHouse> getPdpV3WareHouseList();

    @Nullable
    public abstract String getSizeType();

    @Nullable
    public abstract Integer getPrice();

    @Nullable
    public abstract Integer getDiscountedPrice();

    @Nullable
    public abstract String getOriginalStyle();


    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setProductSizeVariantId(ProductSizeVariantId productSizeVariantId);

        public abstract Builder setProductSizeSkuId(ProductSizeSkuId productSizeSkuId);

        public abstract Builder setProductId(ProductId productId);

        public abstract Builder setInventoryCount(@Nullable Integer inventoryCount);

        public abstract Builder setRelatedSizeProductAction(@Nullable String relatedSizeProductAction);

        public abstract Builder setSizeLabel(String sizeLabel);

        public abstract Builder setIsSizeAvailable(Boolean isSizeAvailable);

        public abstract Builder setSellerInformation(@Nullable String sellerInformation);

        public abstract Builder setPdpV3ProductSupplyType(@Nullable @PdpV3ProductSupplyType String pdpV3ProductSupplyType);

        public abstract Builder setPdpV3WareHouseList(@Nullable List<PdpV3WareHouse> pdpV3WareHouseList);

        public abstract Builder setSizeType(@Nullable String sizeType);

        public abstract Builder setPrice(@Nullable Integer price);

        public abstract Builder setDiscountedPrice(@Nullable Integer discountedPrice);

        public abstract Builder setOriginalStyle(@Nullable String originalStyle);

        public abstract PdpV3SizeProperty build();

    }

}
