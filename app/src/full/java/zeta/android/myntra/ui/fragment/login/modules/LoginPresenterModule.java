package zeta.android.myntra.ui.fragment.login.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.login.presenter.LoginPresenter;
import zeta.android.thunderbird.managers.SessionManager;

@Module
@FragmentScope
public class LoginPresenterModule {

    @Provides
    LoginPresenter providesLoginPresenter(RxSchedulerProvider schedulerProvider,
                                         SessionManager sessionManager) {
        return new LoginPresenter(schedulerProvider, sessionManager);
    }

}
