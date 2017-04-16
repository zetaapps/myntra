package zeta.android.myntra.externallibs;

import android.content.Context;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Initializer all 3rd Party library.
 */
@ParametersAreNonnullByDefault
public interface ExternalLibs {

    void initialize(Context applicationContext);

}
