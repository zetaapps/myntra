package zeta.android.myntra.eventBus;

import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.Subscribe;

public class NoSubscribersListener {
    private final NoEventSubscribersHandler handler;

    public NoSubscribersListener(NoEventSubscribersHandler handler) {
        this.handler = handler;
    }

    @Subscribe
    public void onEvent(NoSubscriberEvent event) {
        handler.handleNoEventSubscribers(event);
    }
}
