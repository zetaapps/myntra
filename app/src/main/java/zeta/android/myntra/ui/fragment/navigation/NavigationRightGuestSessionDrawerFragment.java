package zeta.android.myntra.ui.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import javax.annotation.ParametersAreNonnullByDefault;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;

@ParametersAreNonnullByDefault
public class NavigationRightGuestSessionDrawerFragment extends BaseNavigationFragment {

    private Views mViews;

    static class Views extends BaseViews {

        @BindView(R.id.nav_right_guest_login_fragment)
        FrameLayout frameLayout;

        Views(View root) {
            super(root);
        }
    }


    public static NavigationRightGuestSessionDrawerFragment newInstance() {
        return new NavigationRightGuestSessionDrawerFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_navigation_right_guest_drawer, container, false);
        mViews = new Views(rootView);
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_right_guest_login_fragment, LoginRegisterHalfCardFragment.newInstance())
                .commit();
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
