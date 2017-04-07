package zeta.android.myntra.ui.fragment.myorders.presenter;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MyOrderPresenterParam implements Parcelable {

    public static Builder create() {
        return new AutoValue_MyOrderPresenterParam.Builder();
    }

    public Builder newBuilder() {
        return new AutoValue_MyOrderPresenterParam.Builder(this);
    }

    @Nullable
    public abstract Parcelable getSavedState();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setSavedState(@Nullable Parcelable savedState);

        public abstract MyOrderPresenterParam build();

    }

}
