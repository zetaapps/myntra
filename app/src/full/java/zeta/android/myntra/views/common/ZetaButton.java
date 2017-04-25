package zeta.android.myntra.views.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.views.common.utils.ZetaFontUtils;

/**
 * A custom Button that uses the Myntra fonts. The font style can be set via the
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
public class ZetaButton extends AppCompatButton {

    public ZetaButton(Context context) {
        super(context);
        init(context, null);
    }

    public ZetaButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZetaButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        if (!isInEditMode()) {
            setTypeface(ZetaFontUtils.getTypeface(context, attrs));
        }
    }

}