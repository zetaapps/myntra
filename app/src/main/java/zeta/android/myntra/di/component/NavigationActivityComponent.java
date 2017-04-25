package zeta.android.myntra.di.component;

import dagger.Subcomponent;
import zeta.android.myntra.di.module.ActivityModule;
import zeta.android.myntra.di.scope.ActivityScope;
import zeta.android.myntra.ui.activity.NavigationActivity;

@ActivityScope
@Subcomponent(modules = {
        ActivityModule.class
})
public interface NavigationActivityComponent {

    void inject(NavigationActivity activity);

}