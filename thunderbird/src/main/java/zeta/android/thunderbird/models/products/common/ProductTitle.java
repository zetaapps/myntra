package zeta.android.thunderbird.models.products.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class ProductTitle implements Parcelable, StringId {

    public static ProductTitle create(String title) {
        return new AutoValue_ProductTitle(title);
    }
}
