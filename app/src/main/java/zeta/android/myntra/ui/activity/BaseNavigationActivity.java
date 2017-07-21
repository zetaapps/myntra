package zeta.android.myntra.ui.activity;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import zeta.android.myntra.ui.activity.helpers.CustomTabActivityHelper;
import zeta.android.myntra.ui.activity.navigation.NavigationFragmentManager;
import zeta.android.myntra.ui.activity.navigation.interfaces.DrawerToggleManager;
import zeta.android.myntra.ui.activity.navigation.interfaces.INavigationFragmentManager;
import zeta.android.myntra.ui.activity.navigation.interfaces.IToolBarManipulation;

@ParametersAreNonnullByDefault
public abstract class BaseNavigationActivity extends DaggerAwareActivity implements
        INavigationFragmentManager,
        IToolBarManipulation,
        DrawerToggleManager {

    @Inject
    protected NavigationFragmentManager mNavigationFragmentManager;

    @Inject
    protected CustomTabActivityHelper mCustomTabActivityHelper;

    //region INavigationFragmentManager
    @Override
    public NavigationFragmentManager getNavigationFragmentManager() {
        return mNavigationFragmentManager;
    }
    //endregion

}
