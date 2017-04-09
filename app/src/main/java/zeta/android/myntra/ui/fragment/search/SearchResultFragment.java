package zeta.android.myntra.ui.fragment.search;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.adapters.SearchResultAdapter;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.fragment.pdp.ProductDetailsFragment;
import zeta.android.myntra.ui.fragment.pdp.ProductsDetailsFragmentParam;
import zeta.android.myntra.ui.fragment.search.presentation.SearchResultPresentation;
import zeta.android.myntra.ui.fragment.search.presenter.SearchPresenterParam;
import zeta.android.myntra.ui.fragment.search.presenter.SearchResultPresenter;
import zeta.android.thunderbird.models.products.ProductGist;
import zeta.android.thunderbird.modules.SearchModule;
import zeta.android.utils.device.DeviceUtils;
import zeta.android.utils.view.ViewUtils;

import static zeta.android.myntra.ui.adapters.SearchResultAdapter.GRID_SPAN_COUNT;

@ParametersAreNonnullByDefault
public class SearchResultFragment extends BaseNavigationFragment implements SearchResultPresentation {

    private static final String ARG_SEARCH_RESULT_SAVED_STATE_PRESENTER = "ARG_SEARCH_RESULT_SAVED_STATE_PRESENTER";

    private static final int ITEM_PREFETCH = 4;

    private Views mViews;
    private GridLayoutManager mGridLayoutManager;
    private SearchResultAdapter mSearchResultAdapter;

    //Saved data
    private Parcelable mSavedState;

    @Inject
    SearchResultPresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_progress_bar)
        ProgressBar progressBar;

        @BindView(R.id.zeta_search_list_view)
        RecyclerView recyclerView;

        Views(View root) {
            super(root);
        }
    }

    public static SearchResultFragment newInstance() {
        return new SearchResultFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaSearchComponent(new SearchModule()).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
        if (savedInstance != null) {
            mSavedState = savedInstance.getParcelable(ARG_SEARCH_RESULT_SAVED_STATE_PRESENTER);
        }
        mPresenter.onCreate(getPresenterParams());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_result, container, false);
        mViews = new Views(rootView);
        mPresenter.onCreateView(this);
        initAdaptersAndViews();
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
            outState.putParcelable(ARG_SEARCH_RESULT_SAVED_STATE_PRESENTER, mPresenter.getSavedState());
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unRegisterClickListeners();
        mPresenter.onDestroyView();
        mGridLayoutManager = null;
        mSearchResultAdapter = null;
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
    public void showListView(boolean show) {
        ViewUtils.setVisibility(mViews.recyclerView, show);
    }

    @Override
    public void showListViewFooter(boolean show) {
        //Do nothing
    }

    @Override
    public void showListViewFooterRetry(boolean show) {
        //Do nothing
    }

    @Override
    public void updateImageAdapters(List<ProductGist> productGists, int previousSize) {
        mSearchResultAdapter.updateImagesModel(productGists, previousSize);
    }

    @Override
    public void toggleGridOrListLayout() {

    }

    @Override
    public void toggleGirdOrListMennu(MenuItem item) {
        switchIcon(item);
    }

    @Override
    public void navigateToCartPage() {
        openCustomTab("https://secure.myntra.com/checkout/cart", "");
    }

    @Override
    public void navigateToSearchPage() {

    }

    @Override
    public void navigateToProductDetailsPage(ProductsDetailsFragmentParam param) {
        getNavigationFragmentManager().addFragmentToBackStack(ProductDetailsFragment.newInstance(param));
    }

    //region internal helper methods
    private void initAdaptersAndViews() {
        final Context context = getContext();
        mGridLayoutManager = new GridLayoutManager(context, GRID_SPAN_COUNT);
        mViews.recyclerView.setHasFixedSize(true);
        mGridLayoutManager.setInitialPrefetchItemCount(ITEM_PREFETCH);
        mGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mViews.recyclerView.setLayoutManager(mGridLayoutManager);

        mSearchResultAdapter = new SearchResultAdapter();
        mViews.recyclerView.setAdapter(mSearchResultAdapter);
    }

    private void switchIcon(MenuItem item) {
        if (mGridLayoutManager.getSpanCount() == GRID_SPAN_COUNT) {
            item.setIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_view_module_white_24dp));
        } else {
            item.setIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_view_list_white_24dp));
        }
    }

    private void registerClickListeners() {
        mViews.recyclerView.addOnScrollListener(new ProductSummaryListScrollListener());
        mSearchResultAdapter.setAdapterClickListener(new SearchListAdapterListener());
    }

    private void unRegisterClickListeners() {
        mViews.recyclerView.clearOnScrollListeners();
        mSearchResultAdapter.setAdapterClickListener(null);
    }

    private SearchPresenterParam getPresenterParams() {
        return SearchPresenterParam.create()
                .setSavedState(mSavedState)
                .build();
    }
    //endregion

    //region listeners
    private class SearchListAdapterListener implements SearchResultAdapter.SearchAdapterListener {
        @Override
        public void onItemClick(ProductGist productGist) {
            mPresenter.onItemClick(productGist);
        }
    }

    private class ProductSummaryListScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            //Do nothing
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            int visibleItemCount = mGridLayoutManager.getChildCount();
            int totalItemCount = mGridLayoutManager.getItemCount();
            int firstVisibleItem = mGridLayoutManager.findFirstVisibleItemPosition();
            mPresenter.onPageScrolled(firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }
    //endregion

}
