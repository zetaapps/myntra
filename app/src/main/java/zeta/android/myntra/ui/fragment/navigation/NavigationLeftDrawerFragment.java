package zeta.android.myntra.ui.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.ParametersAreNonnullByDefault;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.views.navigation.LeftNavFooterView;
import zeta.android.myntra.ui.views.navigation.LeftNavHeaderView;
import zeta.android.myntra.ui.views.navigation.LeftNavMenuView;
import zeta.android.myntra.ui.views.navigation.LeftNavSubMenuView;

@ParametersAreNonnullByDefault
public class NavigationLeftDrawerFragment extends BaseNavigationFragment {

    private Views mViews;

    static class Views extends BaseViews {

        @BindView(R.id.left_nav_header_view)
        LeftNavHeaderView headerView;

        @BindView(R.id.left_nav_menu_view)
        LeftNavMenuView menuView;

        @BindView(R.id.left_nav_sub_menu_view)
        LeftNavSubMenuView subMenuView;

        @BindView(R.id.left_nav_footer_view)
        LeftNavFooterView footerView;

        Views(View root) {
            super(root);
        }
    }

    public static NavigationLeftDrawerFragment newInstance() {
        return new NavigationLeftDrawerFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        //TODO::
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_navigation_left_drawer, container, false);
        mViews = new Views(rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViews.clear();
        mViews = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
