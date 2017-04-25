package zeta.android.thunderbird.models.session;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SessionModel implements Parcelable {

    public static Builder create() {
        return new AutoValue_SessionModel.Builder();
    }

    public abstract UserFirstName getFirstName();

    @Nullable
    public abstract UserLastName getLastName();

    public abstract UserProfileModel getProfileModel();

    @Nullable
    public abstract UserMobileNumber getMobileNumber();

    public abstract UserEmail getEmail();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setEmail(UserEmail email);

        public abstract Builder setFirstName(UserFirstName userFirstName);

        public abstract Builder setLastName(@Nullable UserLastName userLastName);

        public abstract Builder setMobileNumber(@Nullable UserMobileNumber mobileNumber);

        public abstract Builder setProfileModel(UserProfileModel userProfileModel);

        public abstract SessionModel build();
    }
}
