package zeta.android.thunderbird.models.session;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SessionTokenModel implements Parcelable {

    public static Builder create() {
        return new AutoValue_SessionTokenModel.Builder();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract SessionTokenModel build();
    }
}
