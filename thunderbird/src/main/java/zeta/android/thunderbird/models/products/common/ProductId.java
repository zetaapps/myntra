package zeta.android.thunderbird.models.products.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.IntegerId;

@AutoValue
public abstract class ProductId implements Parcelable, IntegerId {

    public static ProductId create(int id) {
        return new AutoValue_ProductId(id);
    }
}
