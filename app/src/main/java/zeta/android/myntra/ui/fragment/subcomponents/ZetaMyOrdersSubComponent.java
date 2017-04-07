package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.myorders.MyOrderFragment;
import zeta.android.myntra.ui.fragment.myorders.modules.MyOrderPresenterModule;

@FragmentScope
@Subcomponent(modules = {
        MyOrderPresenterModule.class})
public interface ZetaMyOrdersSubComponent {

    void inject(MyOrderFragment fragment);

}
