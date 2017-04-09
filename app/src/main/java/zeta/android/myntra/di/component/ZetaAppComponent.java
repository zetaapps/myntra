package zeta.android.myntra.di.component;

import javax.inject.Singleton;

import dagger.Component;
import zeta.android.myntra.ZetaApplication;
import zeta.android.myntra.di.module.ConfigModule;
import zeta.android.myntra.di.module.DebugModule;
import zeta.android.myntra.di.module.EventBusModule;
import zeta.android.myntra.di.module.EventBusNoSubscriberModule;
import zeta.android.myntra.di.module.NetworkModule;
import zeta.android.myntra.di.module.OkHttpInterceptorsModule;
import zeta.android.myntra.di.module.SessionTokenModule;
import zeta.android.myntra.di.module.ZetaAppModule;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaAccountsSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaHomeSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaSearchInitiatorSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaLoginSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaMyOrdersSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaProductsSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaSearchSubComponent;
import zeta.android.myntra.ui.fragment.subcomponents.ZetaSettingsSubComponent;
import zeta.android.thunderbird.MyntraEngineModule;
import zeta.android.thunderbird.modules.ProductsModule;
import zeta.android.thunderbird.modules.SearchModule;
import zeta.android.thunderbird.modules.SessionModule;

@Singleton
@Component(modules = {
        DebugModule.class,
        NetworkModule.class,
        EventBusModule.class,
        ZetaAppModule.class,
        OkHttpInterceptorsModule.class,
        EventBusNoSubscriberModule.class,
        ConfigModule.class,
        SessionTokenModule.class,
        MyntraEngineModule.class})
public interface ZetaAppComponent {

    ZetaLoginSubComponent zetaLoginComponent(SessionModule sessionModule);

    ZetaHomeSubComponent zetaHomeComponent();

    ZetaAccountsSubComponent zetaAccountsComponent();

    ZetaMyOrdersSubComponent zetaMyOrdersComponent();

    ZetaSettingsSubComponent zetaSettingsComponent();

    ZetaSearchSubComponent zetaSearchComponent(SearchModule searchModule);

    ZetaSearchInitiatorSubComponent zetaSearchInitiatorComponent();

    ZetaProductsSubComponent zetaProductsComponent(ProductsModule productModule);

    NavigationActivityComponent navigationActivity();

    zeta.android.myntra.di.component.DebugComponent debugComponent();

    void inject(ZetaApplication targetApplication);

}
