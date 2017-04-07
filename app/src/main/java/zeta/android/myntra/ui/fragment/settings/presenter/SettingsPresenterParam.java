package zeta.android.myntra.ui.fragment.settings.presenter;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SettingsPresenterParam implements Parcelable {

    public static Builder create() {
        return new AutoValue_SettingsPresenterParam.Builder();
    }

    public Builder newBuilder() {
        return new AutoValue_SettingsPresenterParam.Builder(this);
    }

    @Nullable
    public abstract Parcelable getSavedState();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setSavedState(@Nullable Parcelable savedState);

        public abstract SettingsPresenterParam build();

    }

}
