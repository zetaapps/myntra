package zeta.android.myntra.ui.fragment.settings.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.settings.presenter.SettingsPresenter;

@Module
@FragmentScope
public class SettingsPresenterModule {

    @Provides
    SettingsPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new SettingsPresenter(schedulerProvider);
    }

}
