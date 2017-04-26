package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.thunderbird.models.products.common.ProductTitle;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3DescriptorsProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3InfoTextProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3PriceProperty;

@AutoValue
public abstract class PdpV3InfoComponent implements Parcelable {

    public static PdpV3InfoComponent.Builder create() {
        return new $AutoValue_PdpV3InfoComponent.Builder();
    }

    public abstract ProductId getProductId();

    public abstract ProductTitle getProductTitle();

    public abstract PdpV3InfoTextProperty getInfoTextProperty();

    public abstract PdpV3PriceProperty getPriceProperty();

    @Nullable
    public abstract List<PdpV3DescriptorsProperty> getPdpV3DescriptorsPropertyList();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setProductId(ProductId productId);

        public abstract Builder setProductTitle(ProductTitle productTitle);

        public abstract Builder setPriceProperty(PdpV3PriceProperty priceProperty);

        public abstract Builder setInfoTextProperty(PdpV3InfoTextProperty infoTextProperty);

        public abstract Builder setPdpV3DescriptorsPropertyList(@Nullable List<PdpV3DescriptorsProperty> pdpV3DescriptorsPropertyList);

        public abstract PdpV3InfoComponent build();
    }

}
