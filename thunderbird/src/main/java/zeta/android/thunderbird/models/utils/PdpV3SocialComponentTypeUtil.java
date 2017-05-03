package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class PdpV3SocialComponentTypeUtil {

    private static final String SOCIAL_COMPONENT_LIKERS_LAZY = "LIKERS_LAZY";
    private static final String SOCIAL_COMPONENT_COMPLETE_LOOK = "COMPLETE_LOOK";

    @PdpV3ComponentType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return PdpV3ComponentType.UNKNOWN;
        }

        switch (identifierType.toUpperCase()) {
            case SOCIAL_COMPONENT_LIKERS_LAZY:
                return PdpV3ComponentType.SOCIAL_COMPONENT_LIKERS_LAZY;
            case SOCIAL_COMPONENT_COMPLETE_LOOK:
                return PdpV3ComponentType.SOCIAL_COMPONENT_COMPLETE_LOOK;
            default:
                return PdpV3ComponentType.UNKNOWN;
        }
    }

}
