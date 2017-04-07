package zeta.android.myntra.rx.providers;

import rx.Scheduler;

public interface RxSchedulerProvider {

    Scheduler schedulerMainThread();

    Scheduler schedulerBackgroundThread();
}
