package zeta.android.myntra.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.externallibs.ExternalLibImpl;
import zeta.android.myntra.externallibs.ExternalLibs;

@Module
@Singleton
public class ExternalLibModules {

    @Provides
    ExternalLibs providesExternalLibs() {
        return new ExternalLibImpl();
    }

}
