package zeta.android.myntra.ui.fragment.accounts.presenter;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AccountsPresenterParam implements Parcelable {

    public static Builder create() {
        return new AutoValue_AccountsPresenterParam.Builder();
    }

    @Nullable
    public abstract Parcelable getSavedState();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setSavedState(@Nullable Parcelable savedState);

        public abstract AccountsPresenterParam build();

    }

}
