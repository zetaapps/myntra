package zeta.android.myntra.di.module;

import android.content.Context;

import com.github.pedrovgs.lynx.LynxConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zeta.android.myntra.sharedPref.DebugSharedPreferences;
import zeta.android.myntra.tools.DeveloperTools;
import zeta.android.myntra.tools.DeveloperToolsImpl;

@Module
@Singleton
public class DebugModule {

    @Provides
    DeveloperTools providesDeveloperTools(DebugSharedPreferences preferences) {
        return new DeveloperToolsImpl(preferences);
    }

    @Provides
    DebugSharedPreferences providesDebugSharedPreferences(Context context) {
        return new DebugSharedPreferences(context);
    }

    @Provides
    public LynxConfig provideLynxConfig() {
        return new LynxConfig();
    }
}
