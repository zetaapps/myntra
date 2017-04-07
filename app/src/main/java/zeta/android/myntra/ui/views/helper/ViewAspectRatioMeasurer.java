package zeta.android.myntra.ui.views.helper;

import android.view.View.MeasureSpec;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This class is a helper to measure views that require a specific aspect ratio.<br />
 * <br />
 * The measurement calculation is differing depending on whether the height and width
 * are fixed (match_parent or a dimension) or not (wrap_content)
 * <p/>
 * <pre>
 *                | Width fixed | Width dynamic |
 * ---------------+-------------+---------------|
 * Height fixed   |      1      |       2       |
 * ---------------+-------------+---------------|
 * Height dynamic |      3      |       4       |
 * </pre>
 * Everything is measured according to a specific aspect ratio.<br />
 * <br />
 * <ul>
 * <li>1: Both width and height fixed:   Fixed (Aspect ratio isn't respected)</li>
 * <li>2: Width dynamic, height fixed:   Set width depending on height</li>
 * <li>3: Width fixed, height dynamic:   Set height depending on width</li>
 * <li>4: Both width and height dynamic: Largest size possible</li>
 * </ul>
 * <p>
 * This was borrowed from
 * https://www.buzzingandroid.com/author/jesper/page/2/
 */

@ParametersAreNonnullByDefault
public class ViewAspectRatioMeasurer {
    private final double mAspectRatio;
    private Integer mMeasuredWidth = null;
    private Integer mMeasuredHeight = null;

    /**
     * Create a ViewAspectRatioMeasurer instance.<br/>
     * <br/>
     * Note: Don't construct a new instance everytime your <tt>View.onMeasure()</tt> method
     * is called.<br />
     * Instead, create one instance when your <tt>View</tt> is constructed, and
     * use this instance's <tt>measure()</tt> methods in the <tt>onMeasure()</tt> method.
     *
     * @param aspectRatio : aspect ratio
     */
    public ViewAspectRatioMeasurer(final double aspectRatio) {
        this.mAspectRatio = aspectRatio;
    }

    /**
     * Measure with the aspect ratio given at construction.<br />
     * <br />
     * After measuring, get the width and height with the {@link #getMeasuredWidth()}
     * and {@link #getMeasuredHeight()} methods, respectively.
     *
     * @param widthMeasureSpec  The width <tt>MeasureSpec</tt> passed in your <tt>View.onMeasure()</tt> method
     * @param heightMeasureSpec The height <tt>MeasureSpec</tt> passed in your <tt>View.onMeasure()</tt> method
     */
    public void measure(int widthMeasureSpec, int heightMeasureSpec) {
        measure(widthMeasureSpec, heightMeasureSpec, this.mAspectRatio);
    }

    /**
     * Measure with a specific aspect ratio<br />
     * <br />
     * After measuring, get the width and height with the {@link #getMeasuredWidth()}
     * and {@link #getMeasuredHeight()} methods, respectively.
     *
     * @param widthMeasureSpec  The width <tt>MeasureSpec</tt> passed in your <tt>View.onMeasure()</tt> method
     * @param heightMeasureSpec The height <tt>MeasureSpec</tt> passed in your <tt>View.onMeasure()</tt> method
     * @param aspectRatio       The aspect ratio to calculate measurements in respect to
     */
    public void measure(final int widthMeasureSpec, final int heightMeasureSpec, final double aspectRatio) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = widthMode == MeasureSpec.UNSPECIFIED ? Integer.MAX_VALUE : MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = heightMode == MeasureSpec.UNSPECIFIED ? Integer.MAX_VALUE : MeasureSpec.getSize(heightMeasureSpec);

        if (heightMode == MeasureSpec.EXACTLY && widthMode == MeasureSpec.EXACTLY) {
            /*
             * Possibility 1: Both width and height fixed
			 */
            mMeasuredWidth = widthSize;
            mMeasuredHeight = heightSize;

        } else if (heightMode == MeasureSpec.EXACTLY) {
            /*
             * Possibility 2: Width dynamic, height fixed
			 */
            mMeasuredWidth = (int) Math.min(widthSize, heightSize * aspectRatio);
            mMeasuredHeight = (int) (mMeasuredWidth / aspectRatio);

        } else if (widthMode == MeasureSpec.EXACTLY) {
            /*
             * Possibility 3: Width fixed, height dynamic
			 */
            mMeasuredHeight = (int) Math.min(heightSize, widthSize / aspectRatio);
            mMeasuredWidth = (int) (mMeasuredHeight * aspectRatio);

        } else {
            /*
			 * Possibility 4: Both width and height dynamic
			 */
            if (widthSize > heightSize * aspectRatio) {
                mMeasuredHeight = heightSize;
                mMeasuredWidth = (int) (mMeasuredHeight * aspectRatio);
            } else {
                mMeasuredWidth = widthSize;
                mMeasuredHeight = (int) (mMeasuredWidth / aspectRatio);
            }

        }
    }

    /**
     * Get the width measured in the latest call to <tt>measure()</tt>.
     */
    public int getMeasuredWidth() {
        if (mMeasuredWidth == null) {
            throw new IllegalStateException("You need to run measure() before trying to get measured dimensions");
        }
        return mMeasuredWidth;
    }

    /**
     * Get the height measured in the latest call to <tt>measure()</tt>.
     */
    public int getMeasuredHeight() {
        if (mMeasuredHeight == null) {
            throw new IllegalStateException("You need to run measure() before trying to get measured dimensions");
        }
        return mMeasuredHeight;
    }

}