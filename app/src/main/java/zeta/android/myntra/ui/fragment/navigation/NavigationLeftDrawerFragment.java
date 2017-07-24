package zeta.android.myntra.ui.fragment.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.accounts.AccountsFragment;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.fragment.home.HomeFragment;
import zeta.android.myntra.ui.fragment.myorders.MyOrderFragment;
import zeta.android.myntra.ui.fragment.navigation.presentation.NavigationLeftPresentation;
import zeta.android.myntra.ui.fragment.navigation.presenter.NavigationLeftPresenter;
import zeta.android.myntra.ui.fragment.navigation.presenter.NavigationLeftPresenterParam;
import zeta.android.myntra.ui.fragment.pdp.presenter.ProductsPresenterParam;
import zeta.android.myntra.ui.fragment.settings.SettingsFragment;
import zeta.android.myntra.ui.views.navigation.LeftNavFooterView;
import zeta.android.myntra.ui.views.navigation.LeftNavHeaderView;
import zeta.android.thunderbird.modules.SessionModule;
import zeta.android.utils.device.DeviceUtils;

@ParametersAreNonnullByDefault
public class NavigationLeftDrawerFragment extends BaseNavigationFragment implements NavigationLeftPresentation {

    private static final String ARG_LEFT_NAV_SAVED_STATE_PRESENTER = "ARG_LEFT_NAV_SAVED_STATE_PRESENTER";

    private Views mViews;

    @Inject
    NavigationLeftPresenter mPresenter;

    //Saved data
    private Parcelable mSavedState;

    static class Views extends BaseViews {

        @BindView(R.id.left_nav_header_view)
        LeftNavHeaderView headerView;

        @BindView(R.id.left_nav_footer_view)
        LeftNavFooterView footerView;

        @BindView(R.id.nav_right_primary_home)
        TextView homeTv;

        @BindView(R.id.nav_right_primary_categories)
        TextView categoriesTv;

        @BindView(R.id.nav_right_primary_giftcards)
        TextView giftCardsTv;

        @BindView(R.id.nav_right_primary_refer_and_earn)
        TextView referAndEarnTv;

        @BindView(R.id.nav_right_secondary_settings)
        TextView settingsTv;

        @BindView(R.id.nav_right_secondary_about)
        TextView aboutTv;

        Views(View root) {
            super(root);
        }
    }

    public static NavigationLeftDrawerFragment newInstance() {
        return new NavigationLeftDrawerFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaLeftNavSubComponent(new SessionModule()).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
        if (savedInstance != null) {
            mSavedState = savedInstance.getParcelable(ARG_LEFT_NAV_SAVED_STATE_PRESENTER);
        }
        mPresenter.onCreate(getPresenterParams());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_navigation_left_drawer,
                container, false);
        mViews = new Views(rootView);
        mPresenter.onCreateView(this);
        registerClickListeners();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (!DeviceUtils.hasNougat()) {
            outState.putParcelable(ARG_LEFT_NAV_SAVED_STATE_PRESENTER, mPresenter.getSavedState());
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unRegisterClickListeners();
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
    public void showSnackBarMessage(@StringRes int message) {
        Snackbar.make(mViews.getRootView(), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        if (onSavedInstanceStateCalled()) {
            return;
        }
        getNavigationFragmentManager().addAsBaseFragment(HomeFragment.newInstance());
    }

    @Override
    public void navigateToCategories() {
        if (onSavedInstanceStateCalled()) {
            return;
        }
        //TODO::Categories
        getNavigationFragmentManager().addAsBaseFragment(AccountsFragment.newInstance());
    }

    @Override
    public void navigateToGiftCards() {
        if (onSavedInstanceStateCalled()) {
            return;
        }
        //TODO::Gift cards
        getNavigationFragmentManager().addAsBaseFragment(MyOrderFragment.newInstance());
    }

    @Override
    public void navigateToReferAndEarn() {
        if (onSavedInstanceStateCalled()) {
            return;
        }
        //TODO::Refer and earn
        getNavigationFragmentManager().addAsBaseFragment(MyOrderFragment.newInstance());
    }

    @Override
    public void navigateToSettings() {
        if (onSavedInstanceStateCalled()) {
            return;
        }
        getNavigationFragmentManager().addAsBaseFragment(SettingsFragment.newInstance());
    }

    @Override
    public void navigateToAbout() {
        if (onSavedInstanceStateCalled()) {
            return;
        }
        //TODO::About
        getNavigationFragmentManager().addAsBaseFragment(SettingsFragment.newInstance());
    }

    //region helper methods
    private void registerClickListeners() {
        mViews.homeTv.setOnClickListener(v -> mPresenter.onHomeClicked());
        mViews.categoriesTv.setOnClickListener(v -> mPresenter.onCategoriesClicked());
        mViews.giftCardsTv.setOnClickListener(v -> mPresenter.onGiftCardClicked());
        mViews.referAndEarnTv.setOnClickListener(v -> mPresenter.onReferAndEarnClicked());
        mViews.settingsTv.setOnClickListener(v -> mPresenter.onSettingsClicked());
        mViews.aboutTv.setOnClickListener(v -> mPresenter.onAboutClicked());
    }

    private void unRegisterClickListeners() {
        mViews.homeTv.setOnClickListener(null);
        mViews.categoriesTv.setOnClickListener(null);
        mViews.giftCardsTv.setOnClickListener(null);
        mViews.referAndEarnTv.setOnClickListener(null);

        mViews.settingsTv.setOnClickListener(null);
        mViews.aboutTv.setOnClickListener(null);
    }

    private NavigationLeftPresenterParam getPresenterParams() {
        return NavigationLeftPresenterParam.create()
                .setSavedState(mSavedState)
                .build();
    }
    //endregion

}
