package zeta.android.myntra.ui.fragment.pdp.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.pdp.presenter.ProductsDetailsPresenter;
import zeta.android.thunderbird.managers.PdpManager;

@Module
@FragmentScope
public class ProductsPresenterModule {

    @Provides
    ProductsDetailsPresenter providesHomePresenter(RxSchedulerProvider schedulerProvider,
                                                   PdpManager productsManager) {
        return new ProductsDetailsPresenter(schedulerProvider, productsManager);
    }

}
