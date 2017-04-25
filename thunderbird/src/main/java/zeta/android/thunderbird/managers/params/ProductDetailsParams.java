package zeta.android.thunderbird.managers.params;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.common.ProductId;

@AutoValue
public abstract class ProductDetailsParams implements Parcelable {

    public static Builder create(ProductId productId) {
        return new AutoValue_ProductDetailsParams.Builder()
                .setProductId(productId);
    }

    public abstract ProductId getProductId();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setProductId(ProductId productId);

        public abstract ProductDetailsParams build();
    }

}
