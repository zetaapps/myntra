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
public class LeftNavSubMenuView extends FrameLayout {
    
    
    private LeftNavSubMenuView.Views mViews;
    @Nullable
    private LeftNavSubMenuView.LeftNavSubMenuViewClickListener mListener;

    static class Views extends BaseViews {

        @BindView(R.id.header_menu_title)
        TextView menuTitle;

        Views(View view) {
            super(view);
        }
    }

    public interface LeftNavSubMenuViewClickListener {
        void onHeaderTitleClicked();
    }
    
    public LeftNavSubMenuView(@NonNull Context context) {
        super(context);
    }

    public LeftNavSubMenuView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftNavSubMenuView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnClickListener(LeftNavSubMenuView.LeftNavSubMenuViewClickListener listener) {
        mListener = listener;
    }

    public void setData(LeftNavHeaderParams params) {
        mViews.menuTitle.setText(params.getHeaderTitle());
        ViewUtils.setToVisible(mViews.menuTitle);
    }

    private void init() {
        inflate(getContext(), R.layout.view_left_nav_header, this);
        mViews = new LeftNavSubMenuView.Views(this);
        mViews.menuTitle.setOnClickListener(v -> {
            if (mListener == null) {
                return;
            }
            mListener.onHeaderTitleClicked();
        });
    }

}
