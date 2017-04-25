package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class UserProfileModel implements Parcelable {

    public static Builder create() {
        return new AutoValue_UserProfileModel.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract UserProfileModel build();
    }
}
