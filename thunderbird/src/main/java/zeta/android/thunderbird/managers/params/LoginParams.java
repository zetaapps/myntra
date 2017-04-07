package zeta.android.thunderbird.managers.params;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.session.AccessToken;
import zeta.android.thunderbird.models.session.LoginType;
import zeta.android.thunderbird.models.session.UserId;
import zeta.android.thunderbird.models.session.UserMobileNumber;
import zeta.android.thunderbird.models.session.UserPassword;

@AutoValue
public abstract class LoginParams implements Parcelable {

    public static Builder create(@LoginType String loginType) {
        return new AutoValue_LoginParams.Builder()
                .setLoginType(loginType);
    }

    @LoginType
    public abstract String getLoginType();

    @Nullable
    public abstract UserId getUserId();

    @Nullable
    public abstract UserPassword getUserPassword();

    @Nullable
    public abstract UserMobileNumber getUserMobileNumber();

    @Nullable
    public abstract AccessToken getAccessToken();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setLoginType(@LoginType String loginType);

        public abstract Builder setUserId(@Nullable UserId userId);

        public abstract Builder setUserPassword(@Nullable UserPassword userPassword);

        public abstract Builder setUserMobileNumber(@Nullable UserMobileNumber userMobileNumber);

        public abstract Builder setAccessToken(@Nullable AccessToken accessToken);

        public abstract LoginParams build();
    }

}
