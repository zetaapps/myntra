package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.navigation.NavigationLeftDrawerFragment;
import zeta.android.myntra.ui.fragment.navigation.modules.NavigationLeftModule;
import zeta.android.thunderbird.modules.SessionModule;

@FragmentScope
@Subcomponent(modules = {
        NavigationLeftModule.class,
        SessionModule.class})
public interface ZetaLeftNavSubComponent {

    void inject(NavigationLeftDrawerFragment fragment);

}
