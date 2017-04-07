package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class UserLastName implements StringId, Parcelable {

    public static UserLastName create(String lastName) {
        return new AutoValue_UserLastName(lastName);
    }
}
