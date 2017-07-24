package zeta.android.myntra.ui.fragment.navigation.presenter;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.auto.value.AutoValue;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.navigation.presentation.NavigationLeftPresentation;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class NavigationLeftPresenter extends ZetaRxFragmentLifeCyclePresenter<NavigationLeftPresentation> {

    private NavigationLeftPresentation mPresentation;
    private NavigationLeftPresenterParam mPresenterParam;

    //Saved data

    public NavigationLeftPresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        mPresentation.inflateMenu(menu, inflater, R.menu.product_details_menu);
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

    public void onCreate(NavigationLeftPresenterParam presenterParam) {
        mPresenterParam = presenterParam;
        final Parcelable savedState = mPresenterParam.getSavedState();
        if (savedState != null) {
            setSavedState(savedState);
        }
    }

    @Override
    public void onCreateView(NavigationLeftPresentation leftNavPresentation) {
        mPresentation = leftNavPresentation;
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

    public void onHomeClicked() {
        mPresentation.navigateToHome();
    }

    public void onCategoriesClicked() {
        mPresentation.navigateToCategories();
    }

    public void onGiftCardClicked() {
        mPresentation.navigateToGiftCards();
    }

    public void onReferAndEarnClicked() {
        mPresentation.navigateToReferAndEarn();
    }

    public void onSettingsClicked() {
        mPresentation.navigateToSettings();
    }

    public void onAboutClicked() {
        mPresentation.navigateToAbout();
    }

    //region saved data
    public Parcelable getSavedState() {
        return SavedState.create()
                .build();
    }

    public void setSavedState(Parcelable savedState) {
        SavedState state = (SavedState) savedState;
        //TODO::Save data here
    }

    //endregion

    //region saved instance
    @AutoValue
    static abstract class SavedState implements Parcelable {

        public static Builder create() {
            return new AutoValue_NavigationLeftPresenter_SavedState.Builder();
        }

        @AutoValue.Builder
        public static abstract class Builder {

            public abstract SavedState build();
        }
    }
    //end region

}
