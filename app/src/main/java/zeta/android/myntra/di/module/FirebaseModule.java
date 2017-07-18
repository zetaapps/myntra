package zeta.android.myntra.di.module;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    @Provides
    FirebaseRemoteConfig providesFirebaseRemoteConfig() {
        return FirebaseRemoteConfig.getInstance();
    }

    @Provides
    FirebasePerformance providesFirebasePerformance() {
        return FirebasePerformance.getInstance();
    }
}


