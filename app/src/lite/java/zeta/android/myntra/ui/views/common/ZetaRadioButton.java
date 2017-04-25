package zeta.android.myntra.ui.views.common;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A custom RadioButton that uses the Myntra fonts. The font style can be set via the
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
public class ZetaRadioButton extends AppCompatRadioButton {

    public ZetaRadioButton(Context context) {
        super(context);
        init(context, null);
    }

    public ZetaRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ZetaRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //TODO:: lite specific fonts
    }
}
