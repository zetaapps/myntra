package zeta.android.myntra.ui.fragment.pdp;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.common.ProductId;

@AutoValue
public abstract class ProductsDetailsFragmentParam implements Parcelable {

    public static Builder create(ProductId productId) {
        return new AutoValue_ProductsDetailsFragmentParam.Builder()
                .setProductId(productId);
    }

    public abstract ProductId getProductId();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setProductId(ProductId productId);

        public abstract ProductsDetailsFragmentParam build();

    }

}
