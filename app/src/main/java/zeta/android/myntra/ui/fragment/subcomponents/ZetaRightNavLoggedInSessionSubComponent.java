package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.navigation.NavigationRightLoggedInSessionDrawerFragment;
import zeta.android.myntra.ui.fragment.navigation.modules.NavigationRightLoggedInSessionModule;
import zeta.android.thunderbird.modules.SessionModule;

@FragmentScope
@Subcomponent(modules = {
        NavigationRightLoggedInSessionModule.class,
        SessionModule.class})
public interface ZetaRightNavLoggedInSessionSubComponent {

    void inject(NavigationRightLoggedInSessionDrawerFragment fragment);

}
