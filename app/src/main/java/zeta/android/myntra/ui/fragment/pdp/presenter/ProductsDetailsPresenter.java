package zeta.android.myntra.ui.fragment.pdp.presenter;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.metagalactic2.views.ExpandableImageViewPagerItem;
import com.google.auto.value.AutoValue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.rx.subscriber.ZetaSubscriber;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.pdp.presentation.ProductsPresentation;
import zeta.android.thunderbird.managers.ProductsManager;
import zeta.android.thunderbird.managers.params.ProductDetailsParams;
import zeta.android.thunderbird.models.products.pdp.PdpModel;
import zeta.android.thunderbird.models.products.pdp.errors.PdpException;
import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class ProductsDetailsPresenter extends ZetaRxFragmentLifeCyclePresenter<ProductsPresentation> {

    private ProductsPresentation mPresentation;

    private ProductsManager mProductsManager;
    private ProductsPresenterParam mPresenterParam;

    //Saved data
    private PdpModel mSavedPdpModel;

    public ProductsDetailsPresenter(RxSchedulerProvider schedulerProvider, ProductsManager productsManager) {
        super(schedulerProvider);
        mProductsManager = productsManager;
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

    public void onCreate(ProductsPresenterParam presenterParam) {
        mPresenterParam = presenterParam;
        final Parcelable savedState = mPresenterParam.getSavedState();
        if (savedState != null) {
            setSavedState(savedState);
        }
    }

    @Override
    public void onCreateView(ProductsPresentation homePresentation) {
        mPresentation = homePresentation;
    }

    @Override
    public void onViewCreated() {
        if (hasProductDetailsData()) {
            showProductDetailsResult(mSavedPdpModel);
        } else {
            requestProductDetailsResponse(mPresenterParam.getProductId());
        }
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
        mProductsManager = null;
    }

    //region saved data
    public Parcelable getSavedState() {
        return SavedState.create()
                .setPdpModel(mSavedPdpModel)
                .build();
    }

    public void setSavedState(Parcelable savedState) {
        SavedState state = (SavedState) savedState;
        mSavedPdpModel = state.getPdpModel();
    }

    //endregion
    private void requestProductDetailsResponse(ProductId productId) {
        mPresentation.showProgressBar(true);
        final ProductDetailsParams productDetailsParams = ProductDetailsParams.create(productId).build();
        subscribe(mProductsManager.getProductDetails(productDetailsParams),
                new ZetaSubscriber<PdpModel, PdpException>() {

                    @Override
                    protected void onSuccess(PdpModel success) {
                        mSavedPdpModel = success;
                        showProductDetailsResult(success);
                    }

                    @Override
                    protected void onFailure(@Nullable PdpException failure) {
                        mPresentation.showProgressBar(false);
                    }

                    @Override
                    protected void onNoNetworkFailure() {
                        mPresentation.showProgressBar(false);
                        mPresentation.showSnackBarMessage(R.string.zeta_no_network);
                    }
                });
    }

    private boolean hasProductDetailsData() {
        return mSavedPdpModel != null;
    }

    private void showProductDetailsResult(PdpModel pdpModel) {
        mPresentation.hideProgressBarAndShowContentContainer();
        List<ExpandableImageViewPagerItem> items = new ArrayList<>();
        items.add(ExpandableImageViewPagerItem.create(pdpModel.getDefaultImageUrl().toString()));
        mPresentation.showProductImage(items);
        mPresentation.showProductTitle(pdpModel.getProductTitle());
        mPresentation.showProductDescription(pdpModel.getProductDescription());
    }

    //region saved instance
    @AutoValue
    static abstract class SavedState implements Parcelable {

        public static Builder create() {
            return new AutoValue_ProductsDetailsPresenter_SavedState.Builder();
        }

        @Nullable
        public abstract PdpModel getPdpModel();

        @AutoValue.Builder
        public static abstract class Builder {

            public abstract Builder setPdpModel(@Nullable PdpModel pdpModel);

            public abstract SavedState build();
        }
    }
    //end region

}
