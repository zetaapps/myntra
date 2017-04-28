package zeta.android.myntra.ui.fragment.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;

@ParametersAreNonnullByDefault
public class NavigationLeftDrawerFragment extends BaseNavigationFragment {

    private Views mViews;

    static class Views extends BaseViews {

        Views(View root) {
            super(root);
        }
    }

    public static NavigationLeftDrawerFragment newInstance() {
        return new NavigationLeftDrawerFragment();
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
