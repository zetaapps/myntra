package zeta.android.myntra.ui.fragment.navigation.presentation;

import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;
import android.view.Menu;
import android.view.MenuInflater;

import com.github.metagalactic2.views.ExpandableImageViewPagerItem;

import java.util.List;

public interface NavigationLeftPresentation {

    void inflateMenu(Menu menu, MenuInflater inflater, @MenuRes int menuResId);

    void showActionBarText(String actionBarTitle);

    void showSnackBarMessage(@StringRes int message);

    void navigateToHome();

    void navigateToCategories();

    void navigateToGiftCards();

    void navigateToReferAndEarn();

    void navigateToSettings();

    void navigateToAbout();

}
