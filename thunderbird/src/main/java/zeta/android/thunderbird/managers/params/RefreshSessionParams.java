package zeta.android.thunderbird.managers.params;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RefreshSessionParams implements Parcelable {

    public static Builder create() {
        return new AutoValue_RefreshSessionParams.Builder();
    }


    @AutoValue.Builder
    public static abstract class Builder {

        public abstract RefreshSessionParams build();
    }

}
