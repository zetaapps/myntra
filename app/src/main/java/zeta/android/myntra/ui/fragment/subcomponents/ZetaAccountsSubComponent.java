package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.accounts.AccountsFragment;
import zeta.android.myntra.ui.fragment.accounts.modules.AccountsPresenterModule;

@FragmentScope
@Subcomponent(modules = {
        AccountsPresenterModule.class})
public interface ZetaAccountsSubComponent {

    void inject(AccountsFragment fragment);

}
