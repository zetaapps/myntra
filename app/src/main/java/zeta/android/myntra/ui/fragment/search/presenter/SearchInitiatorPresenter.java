package zeta.android.myntra.ui.fragment.search.presenter;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.auto.value.AutoValue;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.search.presentation.SearchInitiatorPresentation;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class SearchInitiatorPresenter extends ZetaRxFragmentLifeCyclePresenter<SearchInitiatorPresentation> {

    private SearchInitiatorPresentation mPresentation;
    private SearchPresenterParam mPresenterParam;

    public SearchInitiatorPresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mPresentation.inflateMenu(menu, inflater, R.menu.product_search_initiator_menu);
        mPresentation.showActionBarText(StringUtils.EMPTY_STRING);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        //TODO::
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void onCreate(SearchPresenterParam presenterParam) {
        mPresenterParam = presenterParam;
        final Parcelable savedState = mPresenterParam.getSavedState();
        if (savedState != null) {
            setSavedState(savedState);
        }
    }

    @Override
    public void onCreateView(SearchInitiatorPresentation searchInitiatorPresentation) {
        mPresentation = searchInitiatorPresentation;
    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresentation = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenterParam = null;
    }

    //region saved data
    public Parcelable getSavedState() {
        return SavedState.create()
                .build();
    }

    public void setSavedState(Parcelable savedState) {
        SavedState state = (SavedState) savedState;
    }
    //endregion

    //region saved instance
    @AutoValue
    static abstract class SavedState implements Parcelable {

        public static Builder create() {
            return new AutoValue_SearchInitiatorPresenter_SavedState.Builder();
        }

        @AutoValue.Builder
        public static abstract class Builder {

            public abstract SavedState build();
        }
    }
    //end region

}
