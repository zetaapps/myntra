package zeta.android.myntra.views.common.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

import zeta.android.myntra.R;

/**
 * Helper class for retrieving the custom fonts
 */
public class ZetaFontUtils {

    public static final String FILE_NAME_MYNTRA_FONT_REGULAR = "fonts/Whitney-Book-Bas.otf";
    public static final String FILE_NAME_MYNTRA_FONT_REGULAR_BOLD = "fonts/Whitney-Semibold-Bas.otf";
    public static final String FILE_NAME_MYNTRA_FONT_REGULAR_ITALICS = "fonts/Whitney-BookItal-Bas.otf";
    public static final String FILE_NAME_MYNTRA_FONT_REGULAR_LEITURA = "fonts/Leitura-Display-Swashes.otf";

    private static final Map<Integer, Typeface> TYPEFACE_CACHE = new ArrayMap<>(5);

    @IntDef({FontStyle.REGULAR, FontStyle.REGULAR_BOLD, FontStyle.REGULAR_ITALICS, FontStyle.REGULAR_LEITURA})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontStyle {
        int REGULAR = 1;
        int REGULAR_BOLD = 2;
        int REGULAR_ITALICS = 3;
        int REGULAR_LEITURA = 4;
    }

    /**
     * Returns the custom typeface corresponding to the font style attribute found in the given
     * attribute set. If no font style can be found, the default ("regular") style of the typeface
     * is returned.
     *
     * @param context the context to retrieve the assets from
     * @param attrs   the attribute set containing the font style attribute
     * @return the desired custom typeface in the given font style
     */
    @UiThread
    public static Typeface getTypeface(Context context, @Nullable AttributeSet attrs) {
        if (attrs == null) {
            return ZetaFontUtils.getTypeface(context, FontStyle.REGULAR);
        }

        int defaultValue = 0;                                   // Corresponds to "default"
        Typeface typeface;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ZetaFont, 0, 0);
        if (a == null) {
            return ZetaFontUtils.getTypeface(context, FontStyle.REGULAR);
        }

        switch (a.getInteger(R.styleable.ZetaFont_fontStyle, defaultValue)) {
            case 0:
                typeface = ZetaFontUtils.getTypeface(context, FontStyle.REGULAR);
                break;
            case 1:
                typeface = ZetaFontUtils.getTypeface(context, FontStyle.REGULAR_BOLD);
                break;
            case 2:
                typeface = ZetaFontUtils.getTypeface(context, FontStyle.REGULAR_ITALICS);
                break;
            case 3:
                typeface = ZetaFontUtils.getTypeface(context, FontStyle.REGULAR_LEITURA);
                break;
            default:
                typeface = ZetaFontUtils.getTypeface(context, FontStyle.REGULAR);
                break;
        }
        a.recycle();
        return typeface;
    }

    /**
     * Returns the custom typeface corresponding to the given font style.
     *
     * @param context   the context to retrieve the assets from
     * @param fontStyle the font style of the custom typeface to retrieve
     * @return the desired custom typeface in the given font style
     */
    @UiThread
    public static Typeface getTypeface(Context context, @FontStyle int fontStyle) {
        Typeface cachedTypeface = TYPEFACE_CACHE.get(fontStyle);
        if (cachedTypeface != null) {
            return cachedTypeface;
        }

        Typeface typeface;
        AssetManager assets = context.getAssets();
        switch (fontStyle) {
            case FontStyle.REGULAR:
                typeface = Typeface.createFromAsset(assets, FILE_NAME_MYNTRA_FONT_REGULAR);
                break;
            case FontStyle.REGULAR_BOLD:
                typeface = Typeface.createFromAsset(assets, FILE_NAME_MYNTRA_FONT_REGULAR_BOLD);
                break;
            case FontStyle.REGULAR_ITALICS:
                typeface = Typeface.createFromAsset(assets, FILE_NAME_MYNTRA_FONT_REGULAR_ITALICS);
                break;
            case FontStyle.REGULAR_LEITURA:
                typeface = Typeface.createFromAsset(assets, FILE_NAME_MYNTRA_FONT_REGULAR_LEITURA);
                break;
            default:
                typeface = Typeface.createFromAsset(assets, FILE_NAME_MYNTRA_FONT_REGULAR);
                break;
        }
        TYPEFACE_CACHE.put(fontStyle, typeface);
        return typeface;
    }

}
