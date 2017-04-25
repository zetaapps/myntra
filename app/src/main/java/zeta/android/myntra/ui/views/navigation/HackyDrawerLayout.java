package zeta.android.myntra.ui.views.navigation;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

import javax.annotation.ParametersAreNonnullByDefault;

import timber.log.Timber;

/**
 * This class is a hacky fix for a support library bug triggered by child views that use multiple
 * pointers and call requestDisallowInterceptTouchEvent:
 * https://code.google.com/p/android/issues/detail?id=60464
 * <p>
 * This is a pretty common solution to the problem. See, for example:
 * http://grepcode.com/file/repo1.maven.org/maven2/com.github.lecho/hellocharts-library/1.5.0/lecho/lib/hellocharts/view/hack/HackyDrawerLayout.java
 */

@ParametersAreNonnullByDefault
public class HackyDrawerLayout extends DrawerLayout {

    private static final String TAG = HackyDrawerLayout.class.getSimpleName();

    public HackyDrawerLayout(Context context) {
        super(context);
    }

    public HackyDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HackyDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (Throwable t) {
            Timber.e(TAG, t.toString());
            return false;
        }
    }
}
