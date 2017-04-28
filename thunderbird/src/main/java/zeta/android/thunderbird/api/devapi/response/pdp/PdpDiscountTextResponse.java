package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpDiscountTextResponse {

    public final String text;

    public final boolean hasFreeItem;

    public PdpDiscountTextResponse(String text,
                                   boolean hasFreeItem) {
        this.text = text;
        this.hasFreeItem = hasFreeItem;
    }
}
