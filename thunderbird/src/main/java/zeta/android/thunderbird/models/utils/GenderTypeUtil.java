package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class GenderTypeUtil {

    private static final String MALE = "male";
    private static final String MAN = "man";
    private static final String WOMEN = "women";
    private static final String FEMALE = "female";
    private static final String UNKNOWN = "unknown";

    @GenderType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return GenderType.UNKNOWN;
        }

        switch (identifierType.toLowerCase()) {
            case MAN:
            case MALE:
                return GenderType.MALE;
            case WOMEN:
            case FEMALE:
                return GenderType.FEMALE;
            case UNKNOWN:
            default:
                return GenderType.UNKNOWN;
        }
    }
}
