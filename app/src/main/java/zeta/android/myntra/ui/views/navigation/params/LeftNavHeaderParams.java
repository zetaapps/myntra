package zeta.android.myntra.ui.views.navigation.params;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LeftNavHeaderParams {

    public static Builder create() {
        return new AutoValue_LeftNavHeaderParams.Builder();
    }

    public abstract String getHeaderTitle();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setHeaderTitle(String headerTitle);

        public abstract LeftNavHeaderParams build();
    }
}
