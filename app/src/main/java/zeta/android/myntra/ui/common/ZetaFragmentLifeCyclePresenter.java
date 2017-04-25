package zeta.android.myntra.ui.common;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public interface ZetaFragmentLifeCyclePresenter<Presentation> {

    void onCreateOptionsMenu(Menu menu, MenuInflater inflater);

    void onPrepareOptionsMenu(Menu menu);

    boolean onOptionsItemSelected(MenuItem item);

    void onCreateView(Presentation presentation);

    void onViewCreated();

    void onDestroyView();

    void onDestroy();

}
