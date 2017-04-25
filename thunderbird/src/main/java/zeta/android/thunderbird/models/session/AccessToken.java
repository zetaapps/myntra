package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class AccessToken implements StringId, Parcelable {

    public static AccessToken create(String accessToken) {
        return new AutoValue_AccessToken(accessToken);
    }
}
