package zeta.android.myntra.ui.fragment.navigation.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.navigation.presenter.NavigationLeftPresenter;
import zeta.android.thunderbird.managers.SessionManager;

@Module
@FragmentScope
public class NavigationLeftModule {

    @Provides
    NavigationLeftPresenter providesLeftNavPresenter(RxSchedulerProvider schedulerProvider) {
        return new NavigationLeftPresenter(schedulerProvider);
    }

}
