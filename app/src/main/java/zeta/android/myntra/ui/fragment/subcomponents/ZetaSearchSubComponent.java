package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.search.SearchResultFragment;
import zeta.android.myntra.ui.fragment.search.modules.SearchResultPresenterModule;
import zeta.android.thunderbird.modules.SearchModule;

@FragmentScope
@Subcomponent(modules = {
        SearchResultPresenterModule.class,
        SearchModule.class})
public interface ZetaSearchSubComponent {

    void inject(SearchResultFragment fragment);

}
