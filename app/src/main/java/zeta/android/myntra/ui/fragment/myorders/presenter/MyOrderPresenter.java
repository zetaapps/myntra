package zeta.android.myntra.ui.fragment.myorders.presenter;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.auto.value.AutoValue;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.rx.providers.RxSchedulerProvider;
import zeta.android.myntra.ui.common.ZetaRxFragmentLifeCyclePresenter;
import zeta.android.myntra.ui.fragment.myorders.presentation.MyOrderPresentation;

@ParametersAreNonnullByDefault
public class MyOrderPresenter extends ZetaRxFragmentLifeCyclePresenter<MyOrderPresentation> {

    private MyOrderPresentation mPresentation;
    private MyOrderPresenterParam mPresenterParam;

    //Saved data

    public MyOrderPresenter(RxSchedulerProvider schedulerProvider) {
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

    public void onCreate(MyOrderPresenterParam presenterParam) {
        mPresenterParam = presenterParam;
        final Parcelable savedState = mPresenterParam.getSavedState();
        if (savedState != null) {
            setSavedState(savedState);
        }
    }

    @Override
    public void onCreateView(MyOrderPresentation myOrderPresentation) {
        mPresentation = myOrderPresentation;
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
    }
    //endregion

    //region saved instance
    @AutoValue
    static abstract class SavedState implements Parcelable {

        public static Builder create() {
            return new AutoValue_MyOrderPresenter_SavedState.Builder();
        }

        @AutoValue.Builder
        public static abstract class Builder {

            public abstract SavedState build();
        }
    }
    //end region

}
