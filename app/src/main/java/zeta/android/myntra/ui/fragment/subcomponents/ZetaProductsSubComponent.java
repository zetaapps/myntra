package zeta.android.myntra.ui.fragment.subcomponents;

import dagger.Subcomponent;
import zeta.android.myntra.di.scope.FragmentScope;
import zeta.android.myntra.ui.fragment.pdp.ProductDetailsFragment;
import zeta.android.myntra.ui.fragment.pdp.modules.ProductsPresenterModule;
import zeta.android.thunderbird.modules.ProductsModule;

@FragmentScope
@Subcomponent(modules = {
        ProductsPresenterModule.class,
        ProductsModule.class})
public interface ZetaProductsSubComponent {

    void inject(ProductDetailsFragment fragment);

}
