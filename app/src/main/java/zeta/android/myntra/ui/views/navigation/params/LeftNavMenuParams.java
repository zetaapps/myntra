package zeta.android.myntra.ui.views.navigation.params;


import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LeftNavMenuParams {
    public static LeftNavMenuParams.Builder create() {

        return new AutoValue_LeftNavMenuParams.Builder();

    }

    public abstract String getMenuHome();

    public abstract String getMenuCategory();

    public abstract String getMenuGlobalTrends();

    public abstract String getMenuThemeStores();


    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setMenuHome(String menuHome);

        public abstract Builder setMenuCategory(String menuCategory);

        public abstract Builder setMenuGlobalTrends(String menuGlobalTrends);

        public abstract Builder setMenuThemeStores(String menuThemeStores);

        public abstract LeftNavMenuParams build();

    }
}
