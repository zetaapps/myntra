package zeta.android.myntra.views.common;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.views.common.utils.ZetaFontUtils;

/**
 * A custom TextView that uses the Myntra fonts. The font style can be set via the
 * custom "fontStyle" attribute. In XML, this takes the following values:
 * <p>
 * - REGULAR
 * - REGULAR_BOLD
 * - REGULAR_ITALICS
 * - REGULAR_LEITURA
 */

@ParametersAreNonnullByDefault
public class ZetaTextView extends AppCompatTextView {

    public ZetaTextView(Context context) {
        super(context);
        init(context, null);
    }

    public ZetaTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZetaTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            setTypeface(ZetaFontUtils.getTypeface(context, attrs));
        }
    }

}
