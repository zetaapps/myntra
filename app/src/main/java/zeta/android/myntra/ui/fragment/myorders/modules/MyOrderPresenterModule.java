package zeta.android.myntra.ui.fragment.myorders.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.myorders.presenter.MyOrderPresenter;

@Module
@FragmentScope
public class MyOrderPresenterModule {

    @Provides
    MyOrderPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider) {
        return new MyOrderPresenter(schedulerProvider);
    }

}
