package zeta.android.myntra.ui.fragment.navigation.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.navigation.presenter.NavigationRightLoggedInSessionPresenter;
import zeta.android.thunderbird.managers.SessionManager;

@Module
@FragmentScope
public class NavigationRightLoggedInSessionModule {

    @Provides
    NavigationRightLoggedInSessionPresenter providesRightNavLoggedInSessionPresenter(RxSchedulerProvider schedulerProvider,
                                                                                     SessionManager sessionManager) {
        return new NavigationRightLoggedInSessionPresenter(schedulerProvider, sessionManager);
    }

}
