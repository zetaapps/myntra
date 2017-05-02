package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class PdpV3BrandComponentTypeUtil {

    private static final String BRAND_COMPONENT_PRODUCT_DETAILS = "PRODUCT_DETAILS";

    @PdpV3ComponentType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return PdpV3ComponentType.UNKNOWN;
        }

        switch (identifierType.toLowerCase()) {
            case BRAND_COMPONENT_PRODUCT_DETAILS:
                return PdpV3ComponentType.BRAND_COMPONENT_PRODUCT_DETAILS;
            default:
                return PdpV3ComponentType.UNKNOWN;
        }
    }
}
