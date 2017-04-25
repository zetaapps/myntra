package zeta.android.myntra.ui.fragment.pdp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.f2prateek.bundler.FragmentBundlerCompat;
import com.github.metagalactic.views.ScalableImageView;
import com.github.metagalactic2.views.ExpandableImageView;
import com.github.metagalactic2.views.ExpandableImageViewPagerItem;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.appconfig.GlideConfigModule;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.fragment.pdp.presentation.ProductsPresentation;
import zeta.android.myntra.ui.fragment.pdp.presenter.ProductsDetailsPresenter;
import zeta.android.myntra.ui.fragment.pdp.presenter.ProductsPresenterParam;
import zeta.android.thunderbird.modules.ProductsModule;
import zeta.android.utils.device.DeviceUtils;
import zeta.android.utils.view.ViewUtils;

@ParametersAreNonnullByDefault
public class ProductDetailsFragment extends BaseNavigationFragment implements ProductsPresentation {

    private static final String ARG_BUNDLE_PDP_PARAMS = "ARG_BUNDLE_PDP_PARAMS";
    private static final String ARG_HOME_SAVED_STATE_PRESENTER = "ARG_PRODUCT_DETAILS_SAVED_STATE_PRESENTER";

    private Views mViews;

    //Saved data
    private Parcelable mSavedState;

    @Inject
    ProductsDetailsPresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_progress_bar)
        ProgressBar progressBar;

        @BindView(R.id.zeta_pdp_scroll_view)
        ScrollView scrollContainer;

        @BindView(R.id.zeta_pdp_image_view)
        ExpandableImageView expandableImageView;

        @BindView(R.id.zeta_pdp_title)
        TextView title;

        @BindView(R.id.zeta_pdp_price)
        TextView price;

        @BindView(R.id.zeta_pdp_description)
        TextView description;

        Views(View root) {
            super(root);
        }
    }

    public static ProductDetailsFragment newInstance(ProductsDetailsFragmentParam param) {
        return FragmentBundlerCompat.create(new ProductDetailsFragment())
                .put(ARG_BUNDLE_PDP_PARAMS, param)
                .build();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaProductsComponent(new ProductsModule()).inject(this);
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
        View rootView = inflater.inflate(R.layout.fragment_product_details, container, false);
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
            outState.putParcelable(ARG_HOME_SAVED_STATE_PRESENTER, mPresenter.getSavedState());
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
    public void showProgressBar(boolean show) {
        ViewUtils.setVisibility(mViews.progressBar, show);
    }

    @Override
    public void hideProgressBarAndShowContentContainer() {
        ViewUtils.showFirstAndHideOthers(mViews.scrollContainer, mViews.progressBar);
    }

    @Override
    public void showProductImage(List<ExpandableImageViewPagerItem> items) {
        final Resources resources = getResources();
        mViews.expandableImageView.setPagerHeightMin(resources
                .getDimensionPixelSize(R.dimen.pdp_image_pager_default_height));
        mViews.expandableImageView.setPagingHeightMax(resources
                .getDimensionPixelSize(R.dimen.pdp_image_pager_default_height_expanded));
        mViews.expandableImageView.setCollapsedNumberOfItemsPerPage(1);
        mViews.expandableImageView.setCollapsedViewWidth(1f);
        mViews.expandableImageView.setEndPagesCentered(true);
        mViews.expandableImageView.setImageUrls(items);
        mViews.expandableImageView.setHeroImagePlaceholderDrawable(
                ContextCompat.getDrawable(getContext(), R.drawable.search_results_image_loader));
        mViews.expandableImageView.refresh();
    }

    @Override
    public void showProductTitle(String title) {
        mViews.title.setText(title);
    }

    @Override
    public void showProductPrice(int price) {

    }

    @Override
    public void showProductDescription(String description) {
        mViews.description.setText(description);
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

    }

    //region internal helper methods
    private void loadImage(Context context,
                           String imageUrl,
                           ImageView imageView,
                           @Nullable Drawable placeholder) {
        if (imageUrl.equals(imageView.getTag())) {
            // We already have the image, no need to load it again.
            return;
        }
        //If we don't clear the tag, Glide will crash as Glide do not want us to have tag on image view
        // Clear the current tag and load the new image, The new tag will be set on success.
        imageView.setTag(null);
        Glide.with(context)
                .load(imageUrl)
                .centerCrop()
                .thumbnail(GlideConfigModule.SIZE_MULTIPLIER)
                .placeholder(placeholder)
                .dontAnimate()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e,
                                               String model,
                                               Target<GlideDrawable> target,
                                               boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource,
                                                   String model,
                                                   Target<GlideDrawable> target,
                                                   boolean isFromMemoryCache,
                                                   boolean isFirstResource) {
                        // Set the image URL as a tag so we know that the image with this URL has
                        // successfully loaded
                        imageView.setTag(imageUrl);
                        return false;
                    }
                })
                .into(imageView);
    }

    private void registerClickListeners() {
        mViews.expandableImageView.setListener(new ExpandableImageView.OnImageEventListener() {
            @Override
            public void onImageClicked(int i) {
                //TODO::
            }

            @Override
            public void onImagesSelected(int i, int i1) {
                //TODO::
            }

            @Override
            public void onClearImageFromYourFavoriteImageLibrary(ScalableImageView scalableImageView) {
                Glide.clear(scalableImageView);
            }

            @Override
            public void onLoadImageFromYourFavoriteImageLibrary(ScalableImageView imageView,
                                                                String imageUrl,
                                                                @Nullable Drawable placeholder) {
                loadImage(imageView.getContext(), imageUrl, imageView, placeholder);
            }
        });
    }

    private void unRegisterClickListeners() {
        mViews.expandableImageView.setListener(null);
    }

    private ProductsDetailsFragmentParam getProductDetailsParams() {
        return getArguments().getParcelable(ARG_BUNDLE_PDP_PARAMS);
    }

    private ProductsPresenterParam getPresenterParams() {
        ProductsDetailsFragmentParam productDetailsParams = getProductDetailsParams();
        return ProductsPresenterParam.create()
                .setProductId(productDetailsParams.getProductId())
                .setSavedState(mSavedState)
                .build();
    }
    //endregion
}
