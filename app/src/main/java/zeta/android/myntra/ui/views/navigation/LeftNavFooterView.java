package zeta.android.myntra.ui.views.navigation;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class LeftNavFooterView extends FrameLayout {

    public LeftNavFooterView(@NonNull Context context) {
        super(context);
    }

    public LeftNavFooterView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftNavFooterView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
