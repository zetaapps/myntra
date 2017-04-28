package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpDiscountToolTipTextResponse {

    public String text;

    public boolean hasFreeItem;

    public PdpDiscountToolTipTextResponse(String text,
                                          boolean hasFreeItem) {
        this.text = text;
        this.hasFreeItem = hasFreeItem;
    }
}