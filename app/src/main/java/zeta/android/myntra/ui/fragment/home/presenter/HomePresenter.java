package zeta.android.myntra.ui.fragment.home.presenter;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.auto.value.AutoValue;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.home.presentation.HomePresentation;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class HomePresenter extends ZetaRxFragmentLifeCyclePresenter<HomePresentation> {

    private HomePresentation mPresentation;
    private HomePresenterParam mPresenterParam;

    //Saved data

    public HomePresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mPresentation.inflateMenu(menu, inflater, R.menu.product_home_menu);
        mPresentation.showActionBarText(StringUtils.EMPTY_STRING);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        //TODO::
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                mPresentation.navigateToCartPage();
                return true;
            case R.id.action_search:
                mPresentation.navigateToSearchPage();
                return true;
        }
        return false;
    }

    public void onCreate(HomePresenterParam presenterParam) {
        mPresenterParam = presenterParam;
        final Parcelable savedState = mPresenterParam.getSavedState();
        if (savedState != null) {
            setSavedState(savedState);
        }
    }

    @Override
    public void onCreateView(HomePresentation homePresentation) {
        mPresentation = homePresentation;
    }

    @Override
    public void onViewCreated() {
        //TODO::
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
        //TODO::
    }
    //endregion

    //region saved instance
    @AutoValue
    static abstract class SavedState implements Parcelable {

        public static Builder create() {
            return new AutoValue_HomePresenter_SavedState.Builder();
        }

        @AutoValue.Builder
        public static abstract class Builder {

            public abstract SavedState build();
        }
    }
    //end region

}
