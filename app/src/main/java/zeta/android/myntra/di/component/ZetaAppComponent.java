package zeta.android.myntra.di.component;

import javax.inject.Singleton;

import dagger.Component;
import zeta.android.myntra.ZetaApplication;
import zeta.android.myntra.di.module.ConfigModule;
import zeta.android.myntra.di.module.DebugModule;
import zeta.android.myntra.di.module.EventBusModule;
import zeta.android.myntra.di.module.EventBusNoSubscriberModule;
import zeta.android.myntra.di.module.FirebaseModule;
import zeta.android.myntra.di.module.NetworkModule;
import zeta.android.myntra.di.module.OkHttpInterceptorsModule;
import zeta.android.myntra.di.module.SessionTokenModule;
import zeta.android.myntra.di.module.ZetaAppModule;
import zeta.android.myntra.di.modules.ExternalLibModules;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaAccountsSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaHomeSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaLoginSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaMyOrdersSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaProductsSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaRightNavLoggedInSessionSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaSearchInitiatorSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaSearchSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaSettingsSubComponent;
import zeta.android.thunderbird.MyntraEngineModule;
import zeta.android.thunderbird.modules.ProductsModule;
import zeta.android.thunderbird.modules.SearchModule;
import zeta.android.thunderbird.modules.SessionModule;

@Singleton
@Component(modules = {
        DebugModule.class,
        ConfigModule.class,
        FirebaseModule.class,
        NetworkModule.class,
        ZetaAppModule.class,
        EventBusModule.class,
        ExternalLibModules.class,
        SessionTokenModule.class,
        MyntraEngineModule.class,
        OkHttpInterceptorsModule.class,
        EventBusNoSubscriberModule.class,
})
public interface ZetaAppComponent {

    ZetaLoginSubComponent zetaLoginComponent(SessionModule sessionModule);

    ZetaHomeSubComponent zetaHomeComponent();

    ZetaAccountsSubComponent zetaAccountsComponent();

    ZetaMyOrdersSubComponent zetaMyOrdersComponent();

    ZetaSettingsSubComponent zetaSettingsComponent();

    ZetaSearchSubComponent zetaSearchComponent(SearchModule searchModule);

    ZetaSearchInitiatorSubComponent zetaSearchInitiatorComponent();

    ZetaProductsSubComponent zetaProductsComponent(ProductsModule productModule);

    ZetaRightNavLoggedInSessionSubComponent zetaZetaRightNavLoggedInSessionComponent(SessionModule sessionModule);

    NavigationActivityComponent navigationActivity();

    DebugComponent debugComponent();

    void inject(ZetaApplication targetApplication);

}
