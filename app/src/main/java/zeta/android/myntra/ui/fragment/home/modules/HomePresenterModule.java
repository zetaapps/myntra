package zeta.android.myntra.ui.fragment.home.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.home.presenter.HomePresenter;

@Module
@FragmentScope
public class HomePresenterModule {

    @Provides
    HomePresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new HomePresenter(schedulerProvider);
    }

}
