package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class PdpV3ServicabilityComponentTypeUtil {
    private static final String SERVICEABILITY_COMPONENT_SERVICEABILITY = "SERVICEABILITY";

    @PdpV3ComponentType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return PdpV3ComponentType.UNKNOWN;
        }

        switch (identifierType.toUpperCase()) {
            case SERVICEABILITY_COMPONENT_SERVICEABILITY:
                return PdpV3ComponentType.SERVICEABILITY_COMPONENT_SERVICEABILITY;
            default:
                return PdpV3ComponentType.UNKNOWN;
        }
    }
}
