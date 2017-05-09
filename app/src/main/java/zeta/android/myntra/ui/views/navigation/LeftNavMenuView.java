package zeta.android.myntra.ui.views.navigation;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import javax.annotation.ParametersAreNonnullByDefault;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.views.navigation.params.LeftNavHeaderParams;
import zeta.android.utils.view.ViewUtils;


@ParametersAreNonnullByDefault
public class LeftNavMenuView extends FrameLayout {
    
    private LeftNavMenuView.Views mViews;
    @Nullable
    private LeftNavMenuView.LeftNavMenuViewClickListener mListener;

    static class Views extends BaseViews {

        @BindView(R.id.header_menu_title)
        TextView menuTitle;

        Views(View view) {
            super(view);
        }
    }

    public interface LeftNavMenuViewClickListener {
        void onHeaderTitleClicked();
    }
    
    public LeftNavMenuView(@NonNull Context context) {
        super(context);
    }

    public LeftNavMenuView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftNavMenuView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnClickListener(LeftNavMenuView.LeftNavMenuViewClickListener listener) {
        mListener = listener;
    }

    public void setData(LeftNavHeaderParams params) {
        mViews.menuTitle.setText(params.getHeaderTitle());
        ViewUtils.setToVisible(mViews.menuTitle);
    }

    private void init() {
        inflate(getContext(), R.layout.view_left_nav_sub_menu, this);
        mViews = new LeftNavMenuView.Views(this);
        mViews.menuTitle.setOnClickListener(v -> {
            if (mListener == null) {
                return;
            }
            mListener.onHeaderTitleClicked();
        });
    }

}
