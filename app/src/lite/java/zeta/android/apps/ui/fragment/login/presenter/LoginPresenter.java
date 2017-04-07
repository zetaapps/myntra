package zeta.android.myntra.ui.fragment.login.presenter;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.login.presentation.LoginPresentation;
import zeta.android.thunderbird.managers.SessionManager;

@ParametersAreNonnullByDefault
public class LoginPresenter extends ZetaRxFragmentLifeCyclePresenter<LoginPresentation> {

    public LoginPresenter(RxSchedulerProvider schedulerProvider,
                          SessionManager sessionManager) {
        super(schedulerProvider);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onCreateView(LoginPresentation loginPresentation) {

    }

    @Override
    public void onViewCreated() {

    }
}
