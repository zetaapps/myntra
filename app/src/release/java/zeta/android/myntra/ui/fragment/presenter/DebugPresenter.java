package zeta.android.myntra.ui.activity.presenter;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.activity.presentation.DebugPresentation;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;

@ParametersAreNonnullByDefault
public class DebugPresenter extends ZetaRxFragmentLifeCyclePresenter<DebugPresentation> {

    public DebugPresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onCreateView(DebugPresentation homePresentation) {

    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
