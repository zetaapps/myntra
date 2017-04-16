package zeta.android.myntra.views.common;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.views.common.utils.ZetaFontUtils;

/**
 * A custom CheckBox that uses the Myntra fonts. The font style can be set via the
 * custom "fontStyle" attribute. In XML, this takes the following values:
 * <p>
 * - REGULAR
 * <br>
 * - REGULAR_BOLD
 * <br>
 * - REGULAR_ITALICS
 * <br>
 * - REGULAR_LEITURA
 */

@ParametersAreNonnullByDefault
public class ZetaCheckBox extends AppCompatCheckBox {

    public ZetaCheckBox(Context context) {
        super(context);
        init(context, null);
    }

    public ZetaCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZetaCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            setTypeface(ZetaFontUtils.getTypeface(context, attrs));
        }
    }
}