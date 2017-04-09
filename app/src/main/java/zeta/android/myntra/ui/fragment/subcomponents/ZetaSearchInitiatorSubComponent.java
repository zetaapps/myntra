package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.search.SearchInitiatorFragment;
import zeta.android.myntra.ui.fragment.search.modules.SearchInitiatorPresenterModule;

@FragmentScope
@Subcomponent(modules = {
        SearchInitiatorPresenterModule.class})
public interface ZetaSearchInitiatorSubComponent {

    void inject(SearchInitiatorFragment fragment);

}
