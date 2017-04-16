package zeta.android.myntra;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import dagger.Lazy;
import io.fabric.sdk.android.Fabric;
import rx.plugins.RxJavaHooks;
import zeta.android.myntra.di.component.DaggerZetaAppComponent;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.di.module.ZetaAppModule;
import zeta.android.myntra.externallibs.ExternalLibs;
import zeta.android.myntra.rx.handlers.NetworkConnectivityErrorHandler;
import zeta.android.myntra.tools.DeveloperTools;

@ParametersAreNonnullByDefault
public class ZetaApplication extends Application {

    @Inject
    public Lazy<ExternalLibs> mExternalLibs;

    @Inject
    public Lazy<DeveloperTools> mDeveloperTools;

    private ZetaAppComponent mZetaAppComponent;

    public static void watchForMemoryLeaks(Context context, Object object) {
        ZetaApplication application = (ZetaApplication) context.getApplicationContext();
        application.mDeveloperTools.get().watchForMemoryLeaks(object);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        final Context applicationContext = getApplicationContext();
        mZetaAppComponent = DaggerZetaAppComponent.builder()
                .zetaAppModule(new ZetaAppModule(this, applicationContext))
                .build();
        mZetaAppComponent.inject(this);
        mDeveloperTools.get().initialize(this);
        mExternalLibs.get().initialize(applicationContext);

        //Crashlytics
        Fabric.with(applicationContext, new Crashlytics());

        //Just to log the Rx Global errors.
        RxJavaHooks.setOnError(new NetworkConnectivityErrorHandler());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //Do cleans ups
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        //Do cleans ups
    }

    //region Dependency Injection
    public ZetaAppComponent getZetaAppComponent() {
        return mZetaAppComponent;
    }
    //endregion
}
