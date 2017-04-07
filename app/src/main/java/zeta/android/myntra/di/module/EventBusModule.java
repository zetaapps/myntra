package zeta.android.myntra.di.module;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.eventBus.NoEventSubscribersHandler;
import zeta.android.myntra.eventBus.NoSubscribersListener;

@Module
@Singleton
public class EventBusModule {

    @Provides
    @Singleton
    public EventBus provideEventBus(NoEventSubscribersHandler noEventSubscribersHandler) {
        final EventBus eventBus = EventBus.builder().installDefaultEventBus();
        eventBus.register(new NoSubscribersListener(noEventSubscribersHandler));
        return eventBus;
    }
}
