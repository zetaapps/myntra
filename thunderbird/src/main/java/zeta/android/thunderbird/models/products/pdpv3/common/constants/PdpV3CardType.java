package zeta.android.thunderbird.models.products.pdpv3.common.constants;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({PdpV3CardType.PRODUCT,
        PdpV3CardType.BRAND,
        PdpV3CardType.SERVICEABILITY,
        PdpV3CardType.SOCIAL,
        PdpV3CardType.RELATED,
        PdpV3CardType.MORE_INFO_CARD,
        PdpV3CardType.UNKNOWN})
public @interface PdpV3CardType {
    String PRODUCT = "PRODUCT";
    String BRAND = "BRAND";
    String SERVICEABILITY = "SERVICEABILITY_COMPONENT_SERVICEABILITY";
    String SOCIAL = "SOCIAL";
    String RELATED = "RELATED";
    String MORE_INFO_CARD = "MORE_INFO_CARD";
    String UNKNOWN = "UNKNOWN";
}
