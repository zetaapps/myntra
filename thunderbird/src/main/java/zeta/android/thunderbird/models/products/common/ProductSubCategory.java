package zeta.android.thunderbird.models.products.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class ProductSubCategory implements Parcelable, StringId {

    public static ProductSubCategory create(String subCategory) {
        return new AutoValue_ProductSubCategory(subCategory);
    }
}
