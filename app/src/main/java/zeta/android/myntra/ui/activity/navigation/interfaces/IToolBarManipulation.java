package zeta.android.myntra.ui.activity.navigation.interfaces;

import android.support.annotation.ColorInt;

public interface IToolBarManipulation {

    void showToolBarImage(String imageUrl);

    void setToolBarTitle(String title);

    void setColorToToolbar(@ColorInt int toolbarIconsColor);

    void updateToolbarTransparency(float interpolationRatio);
}
