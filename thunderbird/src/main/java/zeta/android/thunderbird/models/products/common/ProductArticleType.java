package zeta.android.thunderbird.models.products.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class ProductArticleType implements Parcelable, StringId {

    public static ProductArticleType create(String articleType) {
        return new AutoValue_ProductArticleType(articleType);
    }
}
