package zeta.android.myntra.di.component;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.DebugFragment;
import zeta.android.myntra.ui.fragment.module.DebugPresenterModule;

@FragmentScope
@Subcomponent(modules = {DebugPresenterModule.class})
public interface DebugComponent {

    void inject(DebugFragment fragment);
}
