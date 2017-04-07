package zeta.android.thunderbird.environments;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.MyntraEngineEnvironment.Environment;

import static zeta.android.thunderbird.MyntraEngineEnvironment.Environment.PROD;
import static zeta.android.thunderbird.MyntraEngineEnvironment.Environment.STAGE;
import static zeta.android.thunderbird.MyntraEngineEnvironment.Environment.UAT;

@ParametersAreNonnullByDefault
public class ApifyEnvironment implements BaseEnvironment {

    @Environment
    private final int mEnvironment;
    private final String mBaseUrl;

    private static String PROD_BASE_URL = "http://api.myntra.com/";
    private static String STAGE_BASE_URL = "http://api.myntra.com/";
    private static String UAT_BASE_URL = STAGE_BASE_URL;

    public ApifyEnvironment(@Environment int environment) {
        mEnvironment = environment;
        switch (environment) {
            case STAGE:
                mBaseUrl = PROD_BASE_URL;
                break;
            case UAT:
                mBaseUrl = UAT_BASE_URL;
                break;
            case PROD:
            default:
                mBaseUrl = PROD_BASE_URL;
                break;
        }
    }

    @Override
    @Environment
    public int getEnvironment() {
        return mEnvironment;
    }

    @Override
    public String getBaseUrl() {
        return mBaseUrl;
    }

    @Override
    @Nullable
    public String getKey() {
        return null;
    }

    @Override
    @Nullable
    public String getSecureKey() {
        return null;
    }
}
