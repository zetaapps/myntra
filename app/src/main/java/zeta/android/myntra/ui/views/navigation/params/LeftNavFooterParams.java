package zeta.android.myntra.ui.views.navigation.params;


import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LeftNavFooterParams {

    public static Builder create() {
        return new AutoValue_LeftNavFooterParams.Builder();
    }

    public abstract String getFooterContactUs();

    public abstract String getFooterMore();

    public abstract String getFooterDebugInfo();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setFooterContactUs(String footerContactUs);

        public abstract Builder setFooterMore(String footerMore);

        public  abstract Builder setFooterDebugInfo(String footerDebugInfo);

        public abstract LeftNavFooterParams build();
    }
}
