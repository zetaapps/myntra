package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.utils.lang.StringUtils;


@ParametersAreNonnullByDefault
public class PdpV3MoreInfoComponentTypeUtils {

    private static final String MORE_INFO_COMPONENT_MORE_INFO = "MORE_INFO";

    @PdpV3ComponentType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return PdpV3ComponentType.UNKNOWN;
        }

        switch (identifierType.toUpperCase()) {
            case MORE_INFO_COMPONENT_MORE_INFO:
                return PdpV3ComponentType.MORE_INFO_COMPONENT_MORE_INFO;
            default:
                return PdpV3ComponentType.UNKNOWN;
        }
    }

}
