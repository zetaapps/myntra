package zeta.android.myntra.ui.fragment.login.presenter;

import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.annotation.ParametersAreNonnullByDefault;

import timber.log.Timber;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.rx.subscriber.ZetaSubscriber;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.login.presentation.LoginPresentation;
import zeta.android.thunderbird.managers.SessionManager;
import zeta.android.thunderbird.managers.params.LoginParams;
import zeta.android.thunderbird.models.session.LoginType;
import zeta.android.thunderbird.models.session.SessionModel;
import zeta.android.thunderbird.models.session.UserId;
import zeta.android.thunderbird.models.session.UserPassword;
import zeta.android.thunderbird.models.session.errors.SessionException;

@ParametersAreNonnullByDefault
public class LoginPresenter extends ZetaRxFragmentLifeCyclePresenter<LoginPresentation> {

    private LoginPresentation mLoginPresentation;
    private SessionManager mSessionManager;

    public LoginPresenter(RxSchedulerProvider schedulerProvider,
                          SessionManager sessionManager) {
        super(schedulerProvider);
        mSessionManager = sessionManager;
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
        mLoginPresentation = loginPresentation;
    }

    @Override
    public void onViewCreated() {
        requestLogin();
    }

    private void requestLogin() {
        LoginParams loginParams = LoginParams.create(LoginType.MYNTRA)
                .setUserId(UserId.create("manjunath.c1@myntra.com"))
                .setUserPassword(UserPassword.create("Teddybear1"))
                .build();
        subscribe(mSessionManager.getSessionLoginDetails(loginParams),
                new ZetaSubscriber<SessionModel, SessionException>() {
                    @Override
                    protected void onSuccess(SessionModel success) {
                        Timber.d("onSuccess");
                    }

                    @Override
                    protected void onFailure(@Nullable SessionException failure) {
                        Timber.d("onFailure");
                    }

                    @Override
                    protected void onNoNetworkFailure() {
                        Timber.d("onNoNetworkFailure");
                    }
                });
    }
}
