package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class UserPassword implements StringId, Parcelable {

    public static UserPassword create(String password) {
        return new AutoValue_UserPassword(password);
    }
}
