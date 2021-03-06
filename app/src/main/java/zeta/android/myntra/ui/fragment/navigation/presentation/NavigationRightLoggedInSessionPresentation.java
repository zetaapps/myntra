package zeta.android.myntra.ui.fragment.navigation.presentation;

import android.support.annotation.MenuRes;
import android.support.annotation.StringRes;
import android.view.Menu;
import android.view.MenuInflater;

import com.github.metagalactic2.views.ExpandableImageViewPagerItem;

import java.util.List;

public interface NavigationRightLoggedInSessionPresentation {

    void inflateMenu(Menu menu, MenuInflater inflater, @MenuRes int menuResId);

    void showActionBarText(String actionBarTitle);

    void showProgressBar(boolean show);

    void hideProgressBarAndShowContentContainer();

    void showProductImage(List<ExpandableImageViewPagerItem> items);

    void showProductTitle(String title);

    void showProductPrice(int price);

    void showProductDescription(String description);

    void showSnackBarMessage(@StringRes int message);

    void navigateToCartPage();

    void navigateToSearchPage();

}
