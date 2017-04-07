package zeta.android.myntra.di.module;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.ui.activity.helpers.CustomTabActivityHelper;
import zeta.android.myntra.ui.activity.navigation.NavigationFragmentManager;

@Module
public class ActivityModule {

    @Provides
    NavigationFragmentManager providesNavigationFragmentManager() {
        return new NavigationFragmentManager();
    }

    @Provides
    CustomTabActivityHelper providesCustomTabActivityHelper() {
        return new CustomTabActivityHelper();
    }

}
