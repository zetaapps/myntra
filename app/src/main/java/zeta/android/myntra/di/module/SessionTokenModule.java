package zeta.android.myntra.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.providers.DefaultSessionTokenProvider;
import zeta.android.myntra.providers.interfaces.SharedPrefProvider;
import zeta.android.thunderbird.providers.SessionTokenProvider;

@Module
@Singleton
public class SessionTokenModule {

    @Provides
    SessionTokenProvider providesSessionTokenProvider(SharedPrefProvider sharedPrefProvider) {
        return new DefaultSessionTokenProvider(sharedPrefProvider);
    }

}
