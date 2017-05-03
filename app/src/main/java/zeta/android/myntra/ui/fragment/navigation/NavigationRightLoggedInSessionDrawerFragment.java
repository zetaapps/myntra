package zeta.android.myntra.ui.fragment.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.fragment.navigation.presenter.NavigationRightLoggedInSessionPresenter;
import zeta.android.thunderbird.modules.SessionModule;

@ParametersAreNonnullByDefault
public class NavigationRightLoggedInSessionDrawerFragment extends BaseNavigationFragment {


    private static final String ARG_BUNDLE_PDP_PARAMS = "ARG_BUNDLE_PDP_PARAMS";
    private static final String ARG_HOME_SAVED_STATE_PRESENTER = "ARG_PRODUCT_DETAILS_SAVED_STATE_PRESENTER";

    private Views mViews;

    //Saved data
    private Parcelable mSavedState;

    @Inject
    NavigationRightLoggedInSessionPresenter mPresenter;

    static class Views extends BaseViews {

        Views(View root) {
            super(root);
        }
    }


    public static NavigationRightLoggedInSessionDrawerFragment newInstance() {
        return new NavigationRightLoggedInSessionDrawerFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaZetaRightNavLoggedInSessionComponent(new SessionModule()).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_navigation_right_logged_in_drawer, container, false);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
