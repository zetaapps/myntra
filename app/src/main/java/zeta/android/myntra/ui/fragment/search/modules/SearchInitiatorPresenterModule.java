package zeta.android.myntra.ui.fragment.search.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.search.presenter.SearchInitiatorPresenter;

@Module
@FragmentScope
public class SearchInitiatorPresenterModule {

    @Provides
    SearchInitiatorPresenter providesSearchInitiatorPresenter(RxSchedulerProvider schedulerProvider) {
        return new SearchInitiatorPresenter(schedulerProvider);
    }

}
