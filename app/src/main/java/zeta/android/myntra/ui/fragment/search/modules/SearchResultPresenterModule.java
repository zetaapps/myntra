package zeta.android.myntra.ui.fragment.search.modules;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.fragment.search.presenter.SearchResultPresenter;
import zeta.android.thunderbird.managers.SearchManager;

@Module
@FragmentScope
public class SearchResultPresenterModule {

    @Provides
    SearchResultPresenter providesSearchResultPresenter(RxSchedulerProvider schedulerProvider,
                                                        SearchManager searchManager) {
        return new SearchResultPresenter(schedulerProvider, searchManager);
    }

}
