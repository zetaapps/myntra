package zeta.android.myntra.ui.fragment.accounts.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.accounts.presenter.AccountsPresenter;

@Module
@FragmentScope
public class AccountsPresenterModule {

    @Provides
    AccountsPresenter providesAccountsPresenter(RxSchedulerProvider schedulerProvider) {
        return new AccountsPresenter(schedulerProvider);
    }

}
