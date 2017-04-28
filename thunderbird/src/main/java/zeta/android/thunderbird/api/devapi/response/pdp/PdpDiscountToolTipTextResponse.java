package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpDiscountToolTipTextResponse {

    public final String text;

    public final boolean hasFreeItem;

    public PdpDiscountToolTipTextResponse(String text,
                                          boolean hasFreeItem) {
        this.text = text;
        this.hasFreeItem = hasFreeItem;
    }
}