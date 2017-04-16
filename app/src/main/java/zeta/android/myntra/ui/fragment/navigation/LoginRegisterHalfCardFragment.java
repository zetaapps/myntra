package zeta.android.myntra.ui.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;

@ParametersAreNonnullByDefault
public class LoginRegisterHalfCardFragment extends BaseNavigationFragment {

    public static LoginRegisterHalfCardFragment newInstance() {
        return new LoginRegisterHalfCardFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_login_register_half_card, container, false);
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