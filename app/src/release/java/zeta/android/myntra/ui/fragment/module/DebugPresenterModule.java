package zeta.android.myntra.ui.fragment.module;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.activity.presenter.DebugPresenter;

@Module
@FragmentScope
public class DebugPresenterModule {

    @Provides
    DebugPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new DebugPresenter(schedulerProvider);
    }

}
