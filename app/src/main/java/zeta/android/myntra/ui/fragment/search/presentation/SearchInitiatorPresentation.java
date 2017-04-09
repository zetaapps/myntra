package zeta.android.myntra.ui.fragment.search.presentation;

import android.support.annotation.MenuRes;
import android.view.Menu;
import android.view.MenuInflater;

import zeta.android.myntra.ui.fragment.common.presentation.BasePresentation;

public interface SearchInitiatorPresentation extends BasePresentation {

    void inflateMenu(Menu menu, MenuInflater inflater, @MenuRes int menuResId);

    void showActionBarText(String actionBarTitle);

}
