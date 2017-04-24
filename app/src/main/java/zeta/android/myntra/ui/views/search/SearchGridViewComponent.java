package zeta.android.myntra.ui.views.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.annotation.ParametersAreNonnullByDefault;

import butterknife.BindView;
import zeta.android.myntra.R;
import zeta.android.myntra.appconfig.GlideConfigModule;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.views.helper.ViewAspectRatioMeasurer;
import zeta.android.thunderbird.models.products.common.ProductGist;
import zeta.android.utils.view.ViewUtils;

@ParametersAreNonnullByDefault
public class SearchGridViewComponent extends FrameLayout {

    //Aspect ratio for the 1*1 card
    public static final float ASPECT_RATIO = 0.8f;

    private int mApproximateCardHeight;
    private Point mMeasureSpec = new Point();
    private ViewAspectRatioMeasurer mMeasurer;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_product_grid_image)
        ImageView productGridImage;

        @BindView(R.id.zeta_product_grid_image_title)
        TextView imageGridTitle;

        @BindView(R.id.zeta_product_grid_image_subtitle)
        TextView imageGridSubTitle;

        Views(View rootView) {
            super(rootView);
        }
    }

    private Views mViews;

    public SearchGridViewComponent(Context context) {
        super(context);
        init();
    }

    public SearchGridViewComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchGridViewComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Point measureSpec = getMeasureSpec(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(measureSpec.x, measureSpec.y);
    }

    public void setItemData(ProductGist productGist) {
        Context context = getContext();
        Glide.with(context)
                .load(productGist.getProductImage())
                .thumbnail(GlideConfigModule.SIZE_MULTIPLIER)
                .crossFade()
                .placeholder(R.drawable.search_results_image_loader)
                .into(mViews.productGridImage);

        final String title = productGist.getProductTitle();
        mViews.imageGridTitle.setContentDescription(context.getString(R.string.zeta_product_image_cd, title));
        mViews.imageGridTitle.setText(title);
        mViews.imageGridSubTitle.setText(productGist.getProductBrand());
        ViewUtils.setMultipleToVisible(mViews.productGridImage, mViews.imageGridTitle, mViews.imageGridSubTitle);
    }

    private void init() {
        mMeasurer = new ViewAspectRatioMeasurer(ASPECT_RATIO);
        final Context context = getContext();
        inflate(context, R.layout.view_search_list_grid_item, this);
        mViews = new Views(this);

        // Get approximate (1x1) card height. This is based on the an estimate of the card width
        // (determined by dividing the full screen width by the number of columns) and the known
        // content aspect ratio
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int columns = resources.getInteger(R.integer.search_grid_view_columns);
        mApproximateCardHeight = Math.round(metrics.widthPixels / columns / ASPECT_RATIO);
    }

    private Point getMeasureSpec(int widthMeasureSpec, int heightMeasureSpec) {
        //Width is fixed, however height of the card view depends on ratio
        //We are calculating the height based on the aspect ratio.
        mMeasurer.measure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = mMeasurer.getMeasuredWidth();
        int measuredHeight = mMeasurer.getMeasuredHeight();

        int finalWidth = MeasureSpec.makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY);
        int finalHeight = MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY);
        mMeasureSpec.set(finalWidth, finalHeight);
        return mMeasureSpec;
    }

}
