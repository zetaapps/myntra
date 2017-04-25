package zeta.android.myntra.ui.fragment.module;

import com.github.pedrovgs.lynx.LynxConfig;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.sharedPref.DebugSharedPreferences;
import zeta.android.myntra.ui.activity.presenter.DebugPresenter;

@Module
@FragmentScope
public class DebugPresenterModule {

    @Provides
    DebugPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider,
                                         DebugSharedPreferences sharedPreferences,
                                         LynxConfig lynxConfig) {
        return new DebugPresenter(schedulerProvider, sharedPreferences, lynxConfig);
    }

}
