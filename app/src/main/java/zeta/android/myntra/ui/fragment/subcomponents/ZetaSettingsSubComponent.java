package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.settings.SettingsFragment;
import zeta.android.myntra.ui.fragment.settings.modules.SettingsPresenterModule;

@FragmentScope
@Subcomponent(modules = {
        SettingsPresenterModule.class})
public interface ZetaSettingsSubComponent {

    void inject(SettingsFragment fragment);

}
