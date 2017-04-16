package zeta.android.myntra.tools;

import javax.annotation.ParametersAreNonnullByDefault;

import timber.log.Timber;
import zeta.android.myntra.ZetaApplication;
import zeta.android.myntra.sharedPref.DebugSharedPreferences;

@ParametersAreNonnullByDefault
public class DeveloperToolsImpl implements DeveloperTools {

    public DeveloperToolsImpl(DebugSharedPreferences preferences) {
        //no ops
    }

    @Override
    public void initialize(ZetaApplication application) {
        Timber.plant(new CrashlyticsTree());
    }

    @Override
    public void watchForMemoryLeaks(Object object) {
        //No ops
    }
}
