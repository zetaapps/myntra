package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpDiscountDataResponse {


    public int discountType;

    public double discountAmount;

    public int discountId;

    public int discountRuleId;

    public int discountPercent;

    public double discountModifiedDate;

    public PdpDiscountTextResponse discountText;

    public PdpDiscountToolTipTextResponse discountToolTipText;

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
