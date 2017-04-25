package zeta.android.thunderbird.models.products.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class ProductMasterCategory implements Parcelable, StringId {

    public static ProductMasterCategory create(String masterCategory) {
        return new AutoValue_ProductMasterCategory(masterCategory);
    }
}
