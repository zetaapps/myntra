package zeta.android.thunderbird.models.products.pdpv3.errors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.util.Pair;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.common.errors.BaseException;

@ParametersAreNonnullByDefault
public class PdpV3Exception extends BaseException {

    public PdpV3Exception(@Nullable Pair<String, String> errorCodeAndParam) {
        super(errorCodeAndParam);
    }

    @PdpV3Error
    @NonNull
    @Override
    public String getErrorCode() {
        if (errorCode == null) {
            return PdpV3Error.UNKNOWN;
        }
        switch (errorCode) {
            case PdpV3Error.NO_PDP_V3_RESULT_FOUND:
                return PdpV3Error.NO_PDP_V3_RESULT_FOUND;
            default:
                return PdpV3Error.UNKNOWN;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({PdpV3Error.NO_PDP_V3_RESULT_FOUND, PdpV3Error.UNKNOWN})
    public @interface PdpV3Error {
        String NO_PDP_V3_RESULT_FOUND = "no pdp result found";
        String UNKNOWN = "UNKNOWN";
    }
}
