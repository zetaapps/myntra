package zeta.android.myntra.ui.views.navigation.params;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LeftNavSubMenuParams {
    public static LeftNavSubMenuParams.Builder create() {

        return new AutoValue_LeftNavSubMenuParams.Builder();

    }

    public abstract String getSubMenuGiftCards();

    public abstract String getSubMenuReferAndEarn();

    public abstract String getSubMenuSettings();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setSubMenuGiftCards(String subMenuGiftCards);

        public abstract Builder setSubMenuReferAndEarn(String subMenuReferAndEarn);

        public abstract Builder setSubMenuSettings(String subMenuSettings);

        public abstract LeftNavSubMenuParams build();
    }
}