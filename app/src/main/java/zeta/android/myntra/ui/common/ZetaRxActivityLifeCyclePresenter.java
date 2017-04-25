package zeta.android.myntra.ui.common;

import android.support.annotation.CallSuper;

import zeta.android.myntra.rx.managers.RxSubscriptionManager;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;

public abstract class ZetaRxActivityLifeCyclePresenter<Presentation> extends RxSubscriptionManager
        implements ZetaActivityLifeCyclePresenter<Presentation> {

    public ZetaRxActivityLifeCyclePresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @CallSuper
    @Override
    public void onDestroy() {
        cancelSubscriptions();
    }
}
