package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class UserEmail implements StringId, Parcelable {

    public static UserEmail create(String email) {
        return new AutoValue_UserEmail(email);
    }
}
