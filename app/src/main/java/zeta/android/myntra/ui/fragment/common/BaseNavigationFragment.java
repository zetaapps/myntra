package zeta.android.myntra.ui.fragment.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.myntra.receiver.ActionBroadcastReceiver;
import zeta.android.myntra.ui.activity.WebViewActivity;
import zeta.android.myntra.ui.activity.helpers.CustomTabActivityHelper;
import zeta.android.myntra.ui.activity.helpers.WebViewFallback;
import zeta.android.myntra.ui.activity.navigation.NavigationFragmentManager;
import zeta.android.myntra.ui.activity.navigation.interfaces.INavigationFragmentManager;
import zeta.android.myntra.ui.activity.navigation.interfaces.IToolBarManipulation;

@ParametersAreNonnullByDefault
public abstract class BaseNavigationFragment extends DaggerAwareFragment implements
        INavigationFragmentManager, IToolBarManipulation {

    private boolean mOnSaveInstanceStateCalled;

    private IToolBarManipulation mToolBarManipulation;
    private INavigationFragmentManager mNavigationFragmentManager;

    @IntDef({
            HasOptionsMenuOverride.NO_OVERRIDE,
            HasOptionsMenuOverride.OVERRIDE_TO_FALSE,
            HasOptionsMenuOverride.OVERRIDE_TO_TRUE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface HasOptionsMenuOverride {
        int NO_OVERRIDE = 1;
        int OVERRIDE_TO_FALSE = 2;
        int OVERRIDE_TO_TRUE = 3;
    }

    /**
     * A settable value that allows a parent Fragment to override a child Fragment's default
     * behavior for showing the options menu. This is useful when a child that normally take control
     * of the action bar is nested inside a parent that would like to take control instead. The
     * parent can call {@link #setHasOptionsMenuOverride(int)} to set the new desired behavior.
     */
    @HasOptionsMenuOverride
    private int mHasOptionsMenuOverride = HasOptionsMenuOverride.NO_OVERRIDE;

    @Override
    public void setHasOptionsMenu(boolean hasMenu) {
        boolean finalHasMenu;
        switch (mHasOptionsMenuOverride) {
            case HasOptionsMenuOverride.OVERRIDE_TO_FALSE:
                finalHasMenu = false;
                break;
            case HasOptionsMenuOverride.OVERRIDE_TO_TRUE:
                finalHasMenu = true;
                break;
            case HasOptionsMenuOverride.NO_OVERRIDE:
            default:
                finalHasMenu = hasMenu;
                break;

        }
        super.setHasOptionsMenu(finalHasMenu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mNavigationFragmentManager = (INavigationFragmentManager) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement NavigationFragmentManagerHolder");
        }

        try {
            mToolBarManipulation = (IToolBarManipulation) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement IToolBarManipulation");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnSaveInstanceStateCalled = false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mOnSaveInstanceStateCalled = true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //region INavigationFragmentManager
    @Override
    public NavigationFragmentManager getNavigationFragmentManager() {
        if (mNavigationFragmentManager == null) {
            return null;
        }
        return mNavigationFragmentManager.getNavigationFragmentManager();
    }
    //endregion

    //region IToolBarManipulation
    @Override
    public void showToolBarImage(String imageUrl) {
        if (mToolBarManipulation == null) {
            return;
        }
        mToolBarManipulation.showToolBarImage(imageUrl);
    }

    @Override
    public void setToolBarTitle(String title) {
        if (mToolBarManipulation == null) {
            return;
        }
        mToolBarManipulation.setToolBarTitle(title);
    }

    @Override
    public void setColorToToolbar(@ColorInt int toolbarIconsColor) {
        if (mToolBarManipulation == null) {
            return;
        }
        mToolBarManipulation.setColorToToolbar(toolbarIconsColor);
    }

    @Override
    public void updateToolbarTransparency(float interpolationRatio) {
        if (mToolBarManipulation == null) {
            return;
        }
        mToolBarManipulation.updateToolbarTransparency(interpolationRatio);
    }

    //endregion

    /**
     * Can be used to externally override the value typically set by
     * {@link #setHasOptionsMenu(boolean)}.
     *
     * @param optionsMenuOverride the override value
     */
    protected final void setHasOptionsMenuOverride(@HasOptionsMenuOverride int optionsMenuOverride) {
        mHasOptionsMenuOverride = optionsMenuOverride;
    }

    protected final boolean onSavedInstanceStateCalled() {
        return mOnSaveInstanceStateCalled;
    }

    protected void openCustomTab(String url, @Nullable String title) {
        Context context = getContext();
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        intentBuilder.setToolbarColor(ContextCompat.getColor(context, R.color.zeta_md_indigo_700));
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.zeta_md_indigo_500));
        if (title != null) {
            PendingIntent menuItemPendingIntent = createPendingIntent(context, ActionBroadcastReceiver.ACTION_MENU_ITEM);
            intentBuilder.addMenuItem(title, menuItemPendingIntent);
            intentBuilder.setShowTitle(true);
        }
        intentBuilder.addDefaultShareMenuItem();
        intentBuilder.enableUrlBarHiding();
        intentBuilder.setStartAnimations(context, R.anim.slide_in_right, R.anim.slide_out_right);
        intentBuilder.setExitAnimations(context, R.anim.slide_in_left, R.anim.slide_out_right);
        CustomTabActivityHelper.openCustomTab(getActivity(), intentBuilder.build(), Uri.parse(url), new WebViewFallback());

        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, Uri.parse(url).toString());
        getActivity().startActivity(intent);
    }

    private PendingIntent createPendingIntent(Context context, int actionSourceId) {
        Intent actionIntent = new Intent(context, ActionBroadcastReceiver.class);
        actionIntent.putExtra(ActionBroadcastReceiver.KEY_ACTION_SOURCE, actionSourceId);
        return PendingIntent.getBroadcast(context, actionSourceId, actionIntent, 0);
    }

}
