package zeta.android.myntra.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.eventBus.DebugNoEventSubscribersHandler;
import zeta.android.myntra.eventBus.NoEventSubscribersHandler;

@Module
@Singleton
public class EventBusNoSubscriberModule {

    @Provides
    NoEventSubscribersHandler providerNoEventSubscribersHandler() {
        return new DebugNoEventSubscribersHandler();
    }

}
