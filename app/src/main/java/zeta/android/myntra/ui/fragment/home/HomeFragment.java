package zeta.android.myntra.ui.fragment.home;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.fragment.home.presentation.HomePresentation;
import zeta.android.myntra.ui.fragment.home.presenter.HomePresenter;
import zeta.android.myntra.ui.fragment.home.presenter.HomePresenterParam;
import zeta.android.myntra.ui.fragment.search.SearchResultFragment;
import zeta.android.utils.view.ViewUtils;

@ParametersAreNonnullByDefault
public class HomeFragment extends BaseNavigationFragment implements HomePresentation {

    private static final String ARG_HOME_SAVED_STATE_PRESENTER = "ARG_ACCOUNTS_SAVED_STATE_PRESENTER";

    private Views mViews;

    //Saved data
    private Parcelable mSavedState;

    @Inject
    HomePresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_progress_bar)
        ProgressBar progressBar;

        @BindView(R.id.animation_view)
        LottieAnimationView animationView;

        @BindView(R.id.search_view_button)
        Button searchViewButton;

        Views(View root) {
            super(root);
        }
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaHomeComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
        if (savedInstance != null) {
            mSavedState = savedInstance.getParcelable(ARG_HOME_SAVED_STATE_PRESENTER);
        }
        mPresenter.onCreate(getPresenterParams());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mViews = new Views(rootView);
        mPresenter.onCreateView(this);
        registerClickListener();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onViewCreated();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        mPresenter.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mPresenter.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mPresenter.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(ARG_HOME_SAVED_STATE_PRESENTER, mPresenter.getSavedState());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onDestroyView();
        unRegisterClickListener();
        mViews.clear();
        mViews = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mPresenter = null;
    }

    @Override
    public void inflateMenu(Menu menu, MenuInflater inflater, @MenuRes int menuResId) {
        inflater.inflate(menuResId, menu);
    }

    @Override
    public void showActionBarText(String actionBarTitle) {
        setToolBarTitle(actionBarTitle);
    }

    @Override
    public void showProgress(boolean show) {
        ViewUtils.setVisibility(mViews.progressBar, show);
    }

    @Override
    public void showSnackBarMessage(@StringRes int message) {
        Snackbar.make(mViews.getRootView(), getString(message), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void navigateToCartPage() {
        openCustomTab("https://secure.myntra.com/checkout/cart", "");
    }

    @Override
    public void navigateToSearchPage() {
        getNavigationFragmentManager().addFragmentToBackStack(SearchResultFragment.newInstance());
    }


    //region internal helper methods
    private void registerClickListener() {
        mViews.searchViewButton.setOnClickListener(v ->
                getNavigationFragmentManager().addFragmentToBackStack(
                        SearchResultFragment.newInstance()));
    }

    private void unRegisterClickListener() {
        mViews.searchViewButton.setOnClickListener(null);
    }

    private HomePresenterParam getPresenterParams() {
        return HomePresenterParam.create()
                .setSavedState(mSavedState)
                .build();
    }
    //endregion
}
