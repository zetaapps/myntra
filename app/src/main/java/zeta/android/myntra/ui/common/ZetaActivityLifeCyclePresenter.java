package zeta.android.myntra.ui.common;

public interface ZetaActivityLifeCyclePresenter <Presentation> {

    void onCreate(Presentation presentation);

    void onPostResume();

    void onPause();

    void onDestroy();
}
