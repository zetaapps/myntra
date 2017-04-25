package zeta.android.myntra.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.sharedPref.DebugSharedPreferences;
import zeta.android.myntra.sharedPref.DebugSharedPreferences.Environment;
import zeta.android.thunderbird.MyntraEngineCachePolicy;
import zeta.android.thunderbird.MyntraEngineConfig;
import zeta.android.thunderbird.MyntraEngineEnvironment;

@Singleton
@Module
public class ConfigModule {

    @Provides
    MyntraEngineConfig provideConfig(Context context, DebugSharedPreferences sharedPreferences) {
        //Debug app uses 10 min's max age cache policy
        final Environment devApiEnvironment = sharedPreferences.getCurrentDevApiEnvironment();
        final Environment idpApiEnvironment = sharedPreferences.getCurrentIdpApiEnvironment();
        final MyntraEngineCachePolicy cachePolicy = MyntraEngineCachePolicy.create(context.getCacheDir())
                .setCacheMaxAgeInSeconds(TimeUnit.MINUTES.toMinutes(10))
                .build();
        return MyntraEngineConfig.create()
                .setDevApiEnvironment(transform(devApiEnvironment))
                .setIdpApiEnvironment(transform(idpApiEnvironment))
                .setCachePolicy(cachePolicy)
                .build();
    }

    @MyntraEngineEnvironment.Environment
    private int transform(Environment env) {
        switch (env) {
            case Stage:
                return MyntraEngineEnvironment.Environment.STAGE;
            case UAT:
                return MyntraEngineEnvironment.Environment.UAT;
            default:
            case Production:
                return MyntraEngineEnvironment.Environment.PROD;
        }
    }

}
