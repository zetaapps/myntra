package zeta.android.myntra.ui.fragment.search;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.fragment.search.presentation.SearchInitiatorPresentation;
import zeta.android.myntra.ui.fragment.search.presenter.SearchInitiatorPresenter;
import zeta.android.myntra.ui.fragment.search.presenter.SearchPresenterParam;
import zeta.android.utils.device.DeviceUtils;
import zeta.android.utils.view.ViewUtils;

@ParametersAreNonnullByDefault
public class SearchInitiatorFragment extends BaseNavigationFragment implements SearchInitiatorPresentation {

    private static final String ARG_SEARCH_INITIATOR_SAVED_STATE_PRESENTER = "ARG_SEARCH_INITIATOR_SAVED_STATE_PRESENTER";
    private Views mViews;

    //Saved data
    private Parcelable mSavedState;

    @Inject
    SearchInitiatorPresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_progress_bar)
        ProgressBar progressBar;

        @BindView(R.id.zeta_search_list_view)
        RecyclerView recyclerView;

        Views(View root) {
            super(root);
        }
    }

    public static SearchInitiatorFragment newInstance() {
        return new SearchInitiatorFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaSearchInitiatorComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
        if (savedInstance != null) {
            mSavedState = savedInstance.getParcelable(ARG_SEARCH_INITIATOR_SAVED_STATE_PRESENTER);
        }
        mPresenter.onCreate(getPresenterParams());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_initiator, container, false);
        mViews = new Views(rootView);
        mPresenter.onCreateView(this);
        registerClickListeners();
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
        if (!DeviceUtils.hasNougat()) {
            outState.putParcelable(ARG_SEARCH_INITIATOR_SAVED_STATE_PRESENTER, mPresenter.getSavedState());
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unRegisterClickListeners();
        mPresenter.onDestroyView();
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

    private void registerClickListeners() {
        //TODO::
    }

    private void unRegisterClickListeners() {
        mViews.recyclerView.clearOnScrollListeners();
    }

    private SearchPresenterParam getPresenterParams() {
        return SearchPresenterParam.create()
                .setSavedState(mSavedState)
                .build();
    }
    //endregion

}
