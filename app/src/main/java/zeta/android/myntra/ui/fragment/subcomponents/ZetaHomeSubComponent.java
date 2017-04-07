package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.home.HomeFragment;
import zeta.android.myntra.ui.fragment.home.modules.HomePresenterModule;

@FragmentScope
@Subcomponent(modules = {
        HomePresenterModule.class})
public interface ZetaHomeSubComponent {

    void inject(HomeFragment fragment);

}
