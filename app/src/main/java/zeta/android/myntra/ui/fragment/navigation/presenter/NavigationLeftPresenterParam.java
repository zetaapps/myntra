package zeta.android.myntra.ui.fragment.navigation.presenter;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class NavigationLeftPresenterParam implements Parcelable {

    public static Builder create() {
        return new AutoValue_NavigationLeftPresenterParam.Builder();
    }

    @Nullable
    public abstract Parcelable getSavedState();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setSavedState(@Nullable Parcelable savedState);

        public abstract NavigationLeftPresenterParam build();

    }

}
