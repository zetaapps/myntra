package zeta.android.myntra.ui.fragment.accounts.presenter;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.auto.value.AutoValue;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.accounts.presentation.AccountsPresentation;

@ParametersAreNonnullByDefault
public class AccountsPresenter extends ZetaRxFragmentLifeCyclePresenter<AccountsPresentation> {

    private AccountsPresentation mPresentation;
    private AccountsPresenterParam mPresenterParam;

    //Saved data

    public AccountsPresenter(RxSchedulerProvider schedulerProvider) {
        super(schedulerProvider);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //no op
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void onCreate(AccountsPresenterParam presenterParam) {
        mPresenterParam = presenterParam;
        final Parcelable savedState = mPresenterParam.getSavedState();
        if (savedState != null) {
            setSavedState(savedState);
        }
    }

    @Override
    public void onCreateView(AccountsPresentation accountsPresentation) {
        mPresentation = accountsPresentation;
    }

    @Override
    public void onViewCreated() {
       //TODO::
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
    }

    //region saved data
    public Parcelable getSavedState() {
        return SavedState.create()
                .build();
    }

    public void setSavedState(Parcelable savedState) {
        SavedState state = (SavedState) savedState;
        //TODO::
    }
    //endregion

    //region saved instance
    @AutoValue
    static abstract class SavedState implements Parcelable {

        public static Builder create() {
            return new AutoValue_AccountsPresenter_SavedState.Builder();
        }

        @AutoValue.Builder
        public static abstract class Builder {

            public abstract SavedState build();
        }
    }
    //end region

}
