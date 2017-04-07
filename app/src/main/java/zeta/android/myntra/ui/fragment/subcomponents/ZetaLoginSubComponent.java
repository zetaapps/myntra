package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.login.LoginFragment;
import zeta.android.myntra.ui.fragment.login.modules.LoginPresenterModule;
import zeta.android.thunderbird.modules.SessionModule;

@FragmentScope
@Subcomponent(modules = {
        LoginPresenterModule.class,
        SessionModule.class})
public interface ZetaLoginSubComponent {

    void inject(LoginFragment fragment);

}
