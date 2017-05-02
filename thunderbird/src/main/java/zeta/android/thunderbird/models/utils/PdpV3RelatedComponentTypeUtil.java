package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class PdpV3RelatedComponentTypeUtil {

    private static final String RELATED_COMPONENT_RELATED_PDP_LAZY = "RELATED_PDP_LAZY";
    private static final String RELATED_COPONENT_CROSS_LINKS = "CROSS_LINKS";

    @PdpV3ComponentType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return PdpV3ComponentType.UNKNOWN;
        }

        switch (identifierType.toLowerCase()) {
            case RELATED_COMPONENT_RELATED_PDP_LAZY:
                return PdpV3ComponentType.RELATED_COMPONENT_RELATED_PDP_LAZY;
            case RELATED_COPONENT_CROSS_LINKS:
                return PdpV3ComponentType.RELATED_COPONENT_CROSS_LINKS;
            default:
                return PdpV3ComponentType.UNKNOWN;
        }
    }

}
