package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class PdpV3ComponentTypeUtil {

    private static final String PRODUCT = "PRODUCT";
    private static final String BRAND = "BRAND";
    private static final String SERVICEABILITY = "SERVICEABILITY";
    private static final String SOCIAL = "SOCIAL";
    private static final String RELATED = "RELATED";
    private static final String MORE_INFO_CARD = "MORE_INFO_CARD";

    @PdpV3CardType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return PdpV3CardType.UNKNOWN;
        }

        switch (identifierType.toLowerCase()) {
            case PRODUCT:
                return PdpV3CardType.BRAND;
            case BRAND:
                return PdpV3CardType.BRAND;
            case SERVICEABILITY:
                return PdpV3CardType.SERVICEABILITY;
            case SOCIAL:
                return PdpV3CardType.SOCIAL;
            case RELATED:
                return PdpV3CardType.RELATED;
            case MORE_INFO_CARD:
                return PdpV3CardType.MORE_INFO_CARD;
            default:
                return PdpV3CardType.UNKNOWN;
        }
    }
}
