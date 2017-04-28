package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpDiscountDataResponse {

    public final int discountType;

    public final double discountAmount;

    public final int discountId;

    public final int discountRuleId;

    public final int discountPercent;

    public final double discountModifiedDate;

    public final PdpDiscountTextResponse discountText;

    public final PdpDiscountToolTipTextResponse discountToolTipText;

    public PdpDiscountDataResponse(int discountType,
                                   double discountAmount,
                                   int discountId,
                                   int discountRuleId,
                                   int discountPercent,
                                   double discountModifiedDate,
                                   PdpDiscountTextResponse discountText,
                                   PdpDiscountToolTipTextResponse discountToolTipText) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
        this.discountId = discountId;
        this.discountRuleId = discountRuleId;
        this.discountPercent = discountPercent;
        this.discountModifiedDate = discountModifiedDate;
        this.discountText = discountText;
        this.discountToolTipText = discountToolTipText;
    }
}
