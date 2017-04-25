package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class UserLoginModel implements Parcelable {

    public static Builder create() {
        return new AutoValue_UserLoginModel.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract UserLoginModel build();
    }
}
