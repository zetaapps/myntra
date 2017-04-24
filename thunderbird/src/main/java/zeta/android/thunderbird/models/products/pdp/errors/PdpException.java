package zeta.android.thunderbird.models.products.pdp.errors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.util.Pair;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.common.errors.BaseException;

@ParametersAreNonnullByDefault
public class PdpException extends BaseException {

    public PdpException(@Nullable Pair<String, String> errorCodeAndParam) {
        super(errorCodeAndParam);
    }

    @PdpError
    @NonNull
    @Override
    public String getErrorCode() {
        if (errorCode == null) {
            return PdpError.UNKNOWN;
        }
        switch (errorCode) {
            case PdpError.NO_PDP_RESULT_FOUND:
                return PdpError.NO_PDP_RESULT_FOUND;
            default:
                return PdpError.UNKNOWN;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({PdpError.NO_PDP_RESULT_FOUND, PdpError.UNKNOWN})
    public @interface PdpError {
        String NO_PDP_RESULT_FOUND = "no pdp result found";
        String UNKNOWN = "UNKNOWN";
    }
}
