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
public class LeftNavFooterView extends FrameLayout {

    private LeftNavFooterView.Views mViews;
    @Nullable
    private LeftNavFooterView.LeftNavFooterViewClickListener mListener;

    static class Views extends BaseViews {

        @BindView(R.id.header_menu_title)
        TextView menuTitle;

        Views(View view) {
            super(view);
        }
    }

    public interface LeftNavFooterViewClickListener {
        void onHeaderTitleClicked();
    }
    
    public LeftNavFooterView(@NonNull Context context) {
        super(context);
    }

    public LeftNavFooterView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftNavFooterView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnClickListener(LeftNavFooterView.LeftNavFooterViewClickListener listener) {
        mListener = listener;
    }

    public void setData(LeftNavHeaderParams params) {
        mViews.menuTitle.setText(params.getHeaderTitle());
        ViewUtils.setToVisible(mViews.menuTitle);
    }

    private void init() {
        inflate(getContext(), R.layout.view_left_nav_footer, this);
        mViews = new LeftNavFooterView.Views(this);
        mViews.menuTitle.setOnClickListener(v -> {
            if (mListener == null) {
                return;
            }
            mListener.onHeaderTitleClicked();
        });
    }
}
