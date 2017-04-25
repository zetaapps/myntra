package zeta.android.myntra.ui.common;

import android.support.annotation.CallSuper;

import zeta.android.myntra.rx.managers.RxSubscriptionManager;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;

public abstract class ZetaRxFragmentLifeCyclePresenter<Presentation> extends RxSubscriptionManager
        implements ZetaFragmentLifeCyclePresenter<Presentation> {

    public ZetaRxFragmentLifeCyclePresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        cancelSubscriptions();
    }

    @Override
    public void onDestroy() {
        // no-op
    }
}
