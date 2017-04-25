package zeta.android.myntra.ui.fragment.accounts;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.accounts.presentation.AccountsPresentation;
import zeta.android.myntra.ui.fragment.accounts.presenter.AccountsPresenter;
import zeta.android.myntra.ui.fragment.accounts.presenter.AccountsPresenterParam;
import zeta.android.myntra.ui.fragment.common.BaseNavigationFragment;
import zeta.android.utils.view.ViewUtils;

@ParametersAreNonnullByDefault
public class AccountsFragment extends BaseNavigationFragment implements AccountsPresentation {

    private static final String ARG_ACCOUNTS_SAVED_STATE_PRESENTER = "ARG_ACCOUNTS_SAVED_STATE_PRESENTER";

    private Views mViews;

    //Saved data
    private Parcelable mSavedState;

    @Inject
    AccountsPresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_progress_bar)
        ProgressBar progressBar;

        @BindView(R.id.zeta_account_list_view)
        RecyclerView listView;

        Views(View root) {
            super(root);
        }
    }

    public static AccountsFragment newInstance() {
        return new AccountsFragment();
    }

    @Override
    public void configureDependencies(ZetaAppComponent component) {
        component.zetaAccountsComponent().inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
        if (savedInstance != null) {
            mSavedState = savedInstance.getParcelable(ARG_ACCOUNTS_SAVED_STATE_PRESENTER);
        }
        mPresenter.onCreate(getPresenterParams());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        mViews = new Views(rootView);
        mPresenter.onCreateView(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onViewCreated();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(ARG_ACCOUNTS_SAVED_STATE_PRESENTER, mPresenter.getSavedState());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
    public void showProgress(boolean show) {
        ViewUtils.setVisibility(mViews.progressBar, show);
    }

    @Override
    public void showSnackBarMessage(@StringRes int message) {
        Snackbar.make(mViews.getRootView(), getString(message), Snackbar.LENGTH_LONG).show();
    }

    //region internal helper methods
    private AccountsPresenterParam getPresenterParams() {
        return AccountsPresenterParam.create()
                .setSavedState(mSavedState)
                .build();
    }
    //endregion
}
