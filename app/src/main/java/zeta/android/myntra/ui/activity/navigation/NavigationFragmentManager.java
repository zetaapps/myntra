package zeta.android.myntra.ui.activity.navigation;


import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.transition.Transition;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;

@ParametersAreNonnullByDefault
public class NavigationFragmentManager {

    @Nullable
    private View mLeftDrawer;

    @Nullable
    private View mRightDrawer;

    @Nullable
    private DrawerLayout mDrawerLayout;

    private int mContainerId;

    private FragmentManager mFragmentManager;

    @IntDef({AnimationType.SLIDE_RIGHT, AnimationType.SLIDE_BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationType {
        int SLIDE_RIGHT = 1;
        int SLIDE_BOTTOM = 2;
    }


    public void setRightDrawer(@Nullable View rightDrawer) {
        mRightDrawer = rightDrawer;
    }

    public void setLeftDrawer(@Nullable View leftDrawer) {
        mLeftDrawer = leftDrawer;
    }

    public void setLeftAndRightDrawer(@Nullable View leftDrawer,
                                      @Nullable View rightDrawer) {
        mLeftDrawer = leftDrawer;
        mRightDrawer = rightDrawer;
    }

    public void setDrawerLayout(@Nullable DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
    }

    public void setContainerId(@IdRes int containerId) {
        mContainerId = containerId;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    private static Transition getTransitionOrNull(Object object) {
        Transition transition = null;
        try {
            transition = (Transition) object;
        } catch (ClassCastException e) {
            // Do nothing
        }
        return transition;
    }

    public void addAsBaseFragment(Fragment fragment) {
        addAsBaseFragment(fragment, getDefaultTagForFragment(fragment));
    }

    public void addAsBaseFragment(Fragment fragment, String tag) {
        mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(mContainerId, fragment, tag);
        transaction.commit();
        mFragmentManager.executePendingTransactions();
        closeDrawer();
    }

    public void addAsBaseFragmentIfNecessary(Fragment fragment) {
        mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment != null && currentFragment.getClass().equals(fragment.getClass())) {
            // The current fragment (after popping the stack) is the same class as the fragment we'd
            // like to add, so we don't need to go any further.
            closeDrawer();
            return;
        }
        addAsBaseFragment(fragment);
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(fragment, getDefaultTagForFragment(fragment));
        transaction.commit();
    }

    public void addFragmentToBackStack(Fragment fragment) {
        addFragmentToBackStack(fragment, getDefaultTagForFragment(fragment));
    }

    public void addFragmentToBackStackWithoutReplace(Fragment fragment) {
        addFragmentToBackStackWithoutReplace(fragment, getDefaultTagForFragment(fragment));
    }

    public void addFragmentToBackStack(Fragment fragment, @AnimationType int animationType) {
        addFragmentToBackStack(fragment, animationType, getDefaultTagForFragment(fragment));
    }

    public void addFragmentToBackStack(Fragment fragment, @Nullable String tag) {
        //AnimationType.SLIDE_RIGHT -- is default one across the app
        addFragmentToBackStack(fragment, AnimationType.SLIDE_RIGHT, tag);
    }

    public void addFragmentToBackStackWithoutReplace(Fragment fragment, String tag) {
        //AnimationType.SLIDE_RIGHT -- is default one across the app
        addFragmentToBackStackWithoutReplace(fragment, AnimationType.SLIDE_RIGHT, tag);
    }

    public void addFragmentToBackStack(Fragment fragment,
                                       @AnimationType int animationType,
                                       @Nullable String tag) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        setCustomAnimation(transaction, animationType);
        transaction.replace(mContainerId, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
        mFragmentManager.executePendingTransactions();
        closeDrawer();
    }

    public void addFragmentToBackStackWithoutReplace(Fragment fragment,
                                                     @AnimationType int animationType,
                                                     String tag) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        setCustomAnimation(transaction, animationType);
        transaction.add(mContainerId, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
        mFragmentManager.executePendingTransactions();
        closeDrawer();
    }

    public void swapCurrentFragmentWithoutAnimation(Fragment fragment) {
        swapCurrentFragmentWithoutAnimation(fragment, getDefaultTagForFragment(fragment));
    }

    public void swapCurrentFragmentWithoutAnimation(Fragment fragment, String tag) {
        // Remove the current fragment and add the new fragment to the backstack.
        removeFragment();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(mContainerId, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
        mFragmentManager.executePendingTransactions();
        closeDrawer();
    }

    public void addFragmentToBase(Fragment fragment) {
        addFragmentToBase(fragment, getDefaultTagForFragment(fragment));
    }

    public void addFragmentToBase(Fragment fragment, String tag) {
        mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(mContainerId, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
        mFragmentManager.executePendingTransactions();
        closeDrawer();
    }

    public void clearToBaseFragment() {
        mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        closeDrawer();
    }

    private void closeDrawer() {
        if (mDrawerLayout != null &&
                ((mLeftDrawer != null && mDrawerLayout.isDrawerOpen(mLeftDrawer) ||
                        (mRightDrawer != null && mDrawerLayout.isDrawerOpen(mRightDrawer))))) {
            mDrawerLayout.closeDrawer(mLeftDrawer);
        }
    }

    private Fragment getCurrentFragment() {
        return mFragmentManager.findFragmentById(mContainerId);
    }

    public String getDefaultTagForFragment(Fragment fragment) {
        return ((Object) fragment).getClass().getSimpleName();
    }

    public void removeFragment() {
        mFragmentManager.popBackStackImmediate();
    }

    public void removeFragment(String name) {
        mFragmentManager.popBackStackImmediate(name, 0);
    }

    public void removeFragment(@NonNull Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    public void swapCurrentFragment(Fragment fragment) {
        swapCurrentFragment(fragment, getDefaultTagForFragment(fragment));
    }

    public void swapCurrentFragment(Fragment fragment, String tag) {
        if (mFragmentManager.getBackStackEntryCount() == 0) {
            // The current fragment is the base fragment, so we'll just add the new fragment as the
            // base to clear it out.
            addAsBaseFragment(fragment, tag);
            return;
        }

        // Remove the current fragment and add the new fragment to the backstack.
        removeFragment();
        addFragmentToBackStack(fragment, tag);
    }

    private void setCustomAnimation(final FragmentTransaction transaction,
                                    @AnimationType int animationType) {
        int enterAnimation;
        int exitAnimation;
        switch (animationType) {
            case AnimationType.SLIDE_BOTTOM:
                enterAnimation = R.anim.paper_slide_in_bottom;
                exitAnimation = R.anim.paper_slide_out_bottom;
                break;
            case AnimationType.SLIDE_RIGHT:
            default:
                enterAnimation = R.anim.paper_slide_in_right;
                exitAnimation = R.anim.paper_slide_out_right;
                break;
        }
        transaction.setCustomAnimations(enterAnimation,
                R.anim.abc_fade_out,
                R.anim.abc_fade_in,
                exitAnimation);
    }

}
