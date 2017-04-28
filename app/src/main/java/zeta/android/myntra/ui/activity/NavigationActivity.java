package zeta.android.myntra.ui.activity;

import android.app.ActivityManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import butterknife.BindView;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import timber.log.Timber;
import zeta.android.myntra.R;
import zeta.android.myntra.ZetaApplication;
import zeta.android.myntra.appconfig.GlideConfigModule;
import zeta.android.myntra.di.component.ZetaAppComponent;
import zeta.android.myntra.ui.activity.presentation.NavigationPresentation;
import zeta.android.myntra.ui.activity.presenter.NavigationPresenter;
import zeta.android.myntra.ui.common.BaseViews;
import zeta.android.myntra.ui.fragment.DebugFragment;
import zeta.android.myntra.ui.fragment.accounts.AccountsFragment;
import zeta.android.myntra.ui.fragment.home.HomeFragment;
import zeta.android.myntra.ui.fragment.login.NavigationLeftDrawerFragment;
import zeta.android.myntra.ui.fragment.myorders.MyOrderFragment;
import zeta.android.myntra.ui.fragment.navigation.NavigationRightGuestSessionDrawerFragment;
import zeta.android.myntra.ui.fragment.settings.SettingsFragment;
import zeta.android.myntra.util.deeplink.BranchDeepLinkUtil;
import zeta.android.utils.view.ViewUtils;

@ParametersAreNonnullByDefault
public class NavigationActivity extends BaseNavigationActivity implements NavigationPresentation {

    private static final String ACTION_SEARCH_OK_GOOGLE = "com.google.android.gms.actions.SEARCH_ACTION";

    private Views mViews;
    private ActionBarDrawerToggle mDrawerToggle;

    @Inject
    NavigationPresenter mPresenter;

    static class Views extends BaseViews {

        @BindView(R.id.zeta_drawer_layout)
        DrawerLayout drawerLayout;

        @BindView(R.id.zeta_app_bar_layout)
        AppBarLayout appBarLayout;

        @BindView(R.id.zeta_collapsing_image_view)
        ImageView collapsingImageView;

        @BindView(R.id.zeta_toolbar)
        Toolbar toolbar;

        @BindView(R.id.zeta_toolbar_edit_text)
        EditText toolbarEditText;

        @BindView(R.id.zeta_nav_view)
        NavigationView navigationView;

        @BindView(R.id.container)
        View fragmentContainer;

        ImageView headerImageView;

        TextView headerTitle;

        TextView headerEmail;

        NavigationLeftDrawerFragment leftDrawerFragment;

        NavigationRightGuestSessionDrawerFragment rightDrawerFragment;

        @SuppressWarnings("ConstantConditions")
        Views(AppCompatActivity root) {
            super(root.findViewById(R.id.zeta_drawer_layout));
            final View headerView = navigationView.getHeaderView(0);
            headerImageView = (ImageView) headerView.findViewById(R.id.header_image_view);
            headerTitle = (TextView) headerView.findViewById(R.id.header_title);
            headerEmail = (TextView) headerView.findViewById(R.id.header_email);

            leftDrawerFragment = (NavigationLeftDrawerFragment)
                    root.getSupportFragmentManager().findFragmentById(R.id.navigation_left_drawer);

            rightDrawerFragment = (NavigationRightGuestSessionDrawerFragment)
                    root.getSupportFragmentManager().findFragmentById(R.id.navigation_right_drawer);
        }
    }

    @Override
    protected void configureDependencies(ZetaAppComponent component) {
        component.navigationActivity().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        configureTaskDescription();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mViews = new Views(this);
        setSupportActionBar(mViews.toolbar);

        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        mNavigationFragmentManager.setFragmentManager(supportFragmentManager);
        mNavigationFragmentManager.setContainerId(R.id.container);
        mNavigationFragmentManager.setDrawerLayout(mViews.drawerLayout);
        //mNavigationFragmentManager.setDrawer(mViews.navigationView);

        mDrawerToggle = new ActionBarDrawerToggle(
                this, mViews.drawerLayout, mViews.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mViews.drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mPresenter.onCreate(this);

        mViews.navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            mNavigationFragmentManager.addAsBaseFragment(HomeFragment.newInstance());
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mPresenter.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ZetaApplication.watchForMemoryLeaks(getApplicationContext(), this);
        mPresenter.onDestroy();
        mPresenter = null;
        mViews.clear();
        mViews = null;
        mDrawerToggle = null;
    }

    @Override
    public void onBackPressed() {
        if (mViews != null && mViews.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mViews.drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle click events from option menus
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIncomingIntent(intent);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                mPresenter.onMenuItemHomeSelected();
                break;
            case R.id.nav_accounts:
                mPresenter.onMenuItemAccountsSelected();
                break;
            case R.id.nav_refer_and_earn:
                mPresenter.onMenuItemReferAndEarnSelected();
                break;
            case R.id.nav_my_orders:
                mPresenter.onMenuItemMyOrdersSelected();
                break;
            case R.id.nav_settings:
                mPresenter.onMenuItemSettingsSelected();
                break;
            case R.id.nav_debug:
                mPresenter.onMenuItemDebugSelected();
                break;
        }
        mViews.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //region NavigationPresentation
    @Override
    public void showDebugMenuItem(boolean show) {
        final Menu menu = mViews.navigationView.getMenu();
        menu.findItem(R.id.nav_debug).setVisible(show);
    }

    @Override
    public void showBaseScreen() {
        mNavigationFragmentManager.clearToBaseFragment();
    }

    @Override
    public void showDebugScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(DebugFragment.newInstance());
    }

    @Override
    public void showAccountsScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(AccountsFragment.newInstance());
    }

    @Override
    public void showMyOrdersScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(MyOrderFragment.newInstance());
    }

    @Override
    public void showReferAndEarnScreen() {

    }

    @Override
    public void showSettingsScreen() {
        mNavigationFragmentManager.addFragmentToBackStack(SettingsFragment.newInstance());
    }
    //endregion

    //region IToolBarManipulation
    @Override
    public void showToolBarImage(String imageUrl) {
        Glide.with(getApplicationContext())
                .load(imageUrl)
                .centerCrop()
                .thumbnail(GlideConfigModule.SIZE_MULTIPLIER)
                .into(mViews.collapsingImageView);
        ViewUtils.setToVisible(mViews.collapsingImageView);
    }

    @Override
    public void setToolBarTitle(String title) {
        ActionBar supportActionBar = getSupportActionBar();
        assert supportActionBar != null;
        supportActionBar.setTitle(title);
        mViews.toolbar.setTitle(title);
    }
    //endregion

    //region DrawerToggleManager
    @Override
    public void setDrawerIndicatorEnabled(boolean enable) {
        if (mDrawerToggle == null) {
            return;
        }
        mDrawerToggle.setDrawerIndicatorEnabled(enable);
    }
    //endregion

    @Override
    public void setColorToToolbar(@ColorInt int toolbarIconsColor) {
//        final PorterDuffColorFilter colorFilter
//                = new PorterDuffColorFilter(toolbarIconsColor, PorterDuff.Mode.MULTIPLY);
//        final Toolbar toolbar = mViews.toolbar;
//        for (int i = 0; i < toolbar.getChildCount(); i++) {
//            final View v = toolbar.getChildAt(i);
//            //Step 1 : Changing the color of back button (or open drawer button).
//            if (v instanceof ImageButton) {
//                //Action Bar back button
//                ((ImageButton) v).getDrawable().setColorFilter(colorFilter);
//            }
//            //Step 3: Changing the color of title and subtitle.
//            toolbar.setTitleTextColor(toolbarIconsColor);
//            toolbar.setSubtitleTextColor(toolbarIconsColor);
//        }
//        //Step 4: Changing the color of the Overflow Menu icon.
//        setOverflowButtonColor(toolbarIconsColor);
    }

    @Override
    public void updateToolbarTransparency(float interpolationRatio) {
//        int actionBarFinalColor = getActionBarColor();
//        Context applicationContext = getApplicationContext();
//        final Toolbar toolbar = mViews.toolbar;
//        interpolationRatio = interpolationRatio > 0.9 ? 1 : interpolationRatio;
//        if (interpolationRatio < 0.1) {
//            toolbar.setBackground(ContextCompat.getDrawable(applicationContext, R.color.zeta_aluminum_grey));
//            setColorToToolbar(ContextCompat.getColor(applicationContext, R.color.white));
//        } else {
//            int alpha = Math.round(255 * interpolationRatio);
//            int red = Color.red(actionBarFinalColor);
//            int green = Color.green(actionBarFinalColor);
//            int blue = Color.blue(actionBarFinalColor);
//            int finalColor = Color.argb(alpha, red, green, blue);
//            toolbar.setBackgroundColor(finalColor);
//            if (interpolationRatio > 0.9) {
//                setColorToToolbar(ContextCompat.getColor(applicationContext, R.color.white));
//            } else {
//                setColorToToolbar(ContextCompat.getColor(applicationContext, R.color.white));
//            }
//        }
    }

    private void setOverflowButtonColor(@ColorInt int overflowButtonColor) {
        final Toolbar toolbar = mViews.toolbar;
        Drawable drawable = toolbar.getOverflowIcon();
        if (drawable == null) {
            return;
        }
        DrawableCompat.setTint(drawable.mutate(), overflowButtonColor);
        toolbar.setOverflowIcon(drawable);
    }

    private int getActionBarColor() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    /**
     * Since the primary color is indigo_700 and
     * we want the overview TopBar color to be different and we override it to be white
     * Note: This can be removed if the app icon contrasts with primaryColor or we change
     * primaryColor to be different
     */
    private void configureTaskDescription() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            int topBarColor = ContextCompat.getColor(this, R.color.zeta_white);
            ActivityManager.TaskDescription taskDescription =
                    new ActivityManager.TaskDescription(null, null, topBarColor);
            setTaskDescription(taskDescription);
        }
    }

    private void handleIncomingIntent(Intent intent) {
        handleDeepLinkIfPresent(intent, true);
        handleVoiceSearchIfPresent(intent);
    }

    private void handleVoiceSearchIfPresent(@Nullable Intent intent) {
        if (intent == null) {
            // No voice search to handle
            return;
        }
        final Context appContext = getApplicationContext();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //SearchBroadcast.sendVoiceSearchBroadcast(appContext, query);
            //Handle voice search
        }
        if (ACTION_SEARCH_OK_GOOGLE.equals(intent.getAction())) {
            final String query = intent.getStringExtra(SearchManager.QUERY);
            //Handle voice search
        }
    }

    private void handleDeepLinkIfPresent(final Intent intent, boolean shouldCheckBranch) {
        final Uri intentDataUri = intent.getData();
        boolean willBeHandledByBranch = false;
        final Context appContext = getApplicationContext();

        if (shouldCheckBranch && intentDataUri != null) {
            willBeHandledByBranch = BranchDeepLinkUtil.processDeepLink(this,
                    Branch.getInstance(), intentDataUri,
                    new BranchDeepLinkUtil.BranchDeepLinkHandler() {
                        @Override
                        public void onBranchDeepLinkFound(Uri uri) {
                            Intent clonedIntent = new Intent(intent);
                            clonedIntent.setData(uri);
                            handleDeepLinkIfPresent(clonedIntent, false);
                        }

                        @Override
                        public void onBranchDeepLinkSDKError(BranchError error) {
                            Timber.e("Error from Branch SDK: " + error.getMessage());
                        }

                        @Override
                        public void onBranchDeepLinkPayloadParsingError(JSONException exception) {
                            Timber.e("Error parsing Branch payload: ", exception);
                        }
                    });
        }

        if (willBeHandledByBranch || intentDataUri == null) {
            //Deep-link is for Branch, or there's nothing to handle; Let's Bail!
            return;
        }

        handleDeepLink(appContext, intentDataUri);

        // Clear the deep link intentDataUri from the intent so it is not reused if the process is
        // recreated (we should just use the current app state at that point)
        intent.setData(null);
        setIntent(intent);
    }

    private void handleDeepLink(Context applicationContext, Uri data) {
        //TODO:: Handle deep link
    }

}
