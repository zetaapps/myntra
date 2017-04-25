package zeta.android.myntra.externallibs;

import android.content.Context;

import com.facebook.FacebookSdk;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ExternalLibImpl implements ExternalLibs {

    @Override
    public void initialize(Context applicationContext) {
        //Facebook
        FacebookSdk.sdkInitialize(applicationContext);
    }
}
