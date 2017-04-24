package zeta.android.thunderbird.managers.params;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.thunderbird.models.session.UserFirstName;
import zeta.android.thunderbird.models.session.UserLastName;
import zeta.android.thunderbird.models.session.UserType;

@AutoValue
public abstract class SignInParams implements Parcelable {

    public static Builder create() {
        return new AutoValue_SignInParams.Builder();
    }

    @GenderType
    public abstract String getGenderType();

    @UserType
    public abstract String getUserType();

    public abstract UserFirstName getUserFirstName();

    public abstract UserLastName getUserLastName();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setGenderType(@GenderType String genderType);

        public abstract Builder setUserType(@UserType String userType);

        public abstract Builder setUserFirstName(UserFirstName firstName);

        public abstract Builder setUserLastName(UserLastName lastName);

        public abstract SignInParams build();
    }

}
