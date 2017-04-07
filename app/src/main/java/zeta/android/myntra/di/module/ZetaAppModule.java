package zeta.android.myntra.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.providers.DefaultConnectivityProvider;
import zeta.android.myntra.providers.DefaultSharedPrefProvider;
import zeta.android.myntra.providers.DefaultStringResourceProvider;
import zeta.android.myntra.providers.interfaces.ConnectivityProvider;
import zeta.android.myntra.providers.interfaces.SharedPrefProvider;
import zeta.android.myntra.providers.interfaces.StringResourceProvider;
import zeta.android.myntra.rx.managers.RxSubscriptionManager;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.rx.providers.SchedulerProvider;

@Module
@Singleton
public class ZetaAppModule {

    private final Context appContext;
    private final Application application;

    public ZetaAppModule(Application application, Context appContext) {
        this.appContext = appContext;
        this.application = application;
    }

    @Provides
    Application providesApplication() {
        return application;
    }

    @Provides
    Context providesAppContext() {
        return appContext;
    }

    @Provides
    StringResourceProvider providesStringResourceProvider(Context context) {
        return new DefaultStringResourceProvider(context);
    }

    @Provides
    SharedPrefProvider providesSharedPrefProvider(Context context) {
        return new DefaultSharedPrefProvider(context);
    }

    @Provides
    ConnectivityProvider providesConnectivityProvider(Context context) {
        return new DefaultConnectivityProvider(context);
    }

    @Provides
    RxSubscriptionManager providesRxSubscriptionManager(RxSchedulerProvider rxSchedulerProvider) {
        return new RxSubscriptionManager(rxSchedulerProvider);
    }

    @Provides
    RxSchedulerProvider providesRxSchedulerProvider() {
        return new SchedulerProvider();
    }

}
