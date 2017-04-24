package zeta.android.thunderbird.models.products.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class ProductBrand implements Parcelable, StringId {

    public static ProductBrand create(String brand) {
        return new AutoValue_ProductBrand(brand);
    }
}
