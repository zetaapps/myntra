package zeta.android.myntra.ui.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.ZetaApplication;
import zeta.android.myntra.di.component.ZetaAppComponent;

@ParametersAreNonnullByDefault
public abstract class DaggerAwareActivity extends AppCompatActivity {

    protected abstract void configureDependencies(ZetaAppComponent component);

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ZetaApplication application = (ZetaApplication) getApplication();
        configureDependencies(application.getZetaAppComponent());
    }
}
