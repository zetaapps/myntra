package zeta.android.myntra.ui.fragment.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.myntra.ui.fragment.login.presentation.LoginPresentation;
import zeta.android.myntra.ui.fragment.login.presenter.LoginPresenter;
import zeta.android.thunderbird.modules.SessionModule;

@ParametersAreNonnullByDefault
public class LoginFragment extends BaseNavigationFragment implements LoginPresentation {

    @Inject
    LoginPresenter mLoginPresenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaLoginComponent(new SessionModule()).inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mLoginPresenter.onCreateView(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLoginPresenter.onViewCreated();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mLoginPresenter.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
        mLoginPresenter = null;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showSnackBarMessage(@StringRes int message) {

    }
}
