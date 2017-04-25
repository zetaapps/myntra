package zeta.android.myntra.ui.activity.presenter;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import zeta.android.myntra.BuildConfig;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.activity.presentation.NavigationPresentation;
import zeta.android.myntra.ui.common.ZetaRxActivityLifeCyclePresenter;

@ParametersAreNonnullByDefault
public class NavigationPresenter extends ZetaRxActivityLifeCyclePresenter<NavigationPresentation> {

    private NavigationPresentation mPresentation;

    @Inject
    public NavigationPresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void onCreate(NavigationPresentation navigationPresentation) {
        mPresentation = navigationPresentation;
        mPresentation.showDebugMenuItem(BuildConfig.DEBUG);
    }

    @Override
    public void onPostResume() {
        // no-op
    }

    @Override
    public void onPause() {
        // no-op
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresentation = null;
    }

    public void onMenuItemHomeSelected() {
        mPresentation.showBaseScreen();
    }

    public void onMenuItemAccountsSelected() {
        mPresentation.showAccountsScreen();
    }

    public void onMenuItemMyOrdersSelected() {
        mPresentation.showMyOrdersScreen();
    }

    public void onMenuItemReferAndEarnSelected() {
        mPresentation.showReferAndEarnScreen();
    }

    public void onMenuItemSettingsSelected() {
        mPresentation.showSettingsScreen();
    }

    public void onMenuItemDebugSelected() {
        mPresentation.showDebugScreen();
    }
}
