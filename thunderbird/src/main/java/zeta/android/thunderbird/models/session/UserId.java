package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class UserId implements StringId, Parcelable {

    public static UserId create(String userId) {
        return new AutoValue_UserId(userId);
    }
}
