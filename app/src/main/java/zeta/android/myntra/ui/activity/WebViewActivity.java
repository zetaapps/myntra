package zeta.android.myntra.ui.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.R;
import zeta.android.utils.lang.StringUtils;

@ParametersAreNonnullByDefault
public class WebViewActivity extends AppCompatActivity {

    public static final String EXTRA_URL = "extra.url";
    public static final String COOKIE_DOMAIN = ".myntra.com";
    public static final String COOKIE_URL = "_x_myntra_initial_url";

    @SuppressWarnings("ConstantConditions")
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        String url = getIntent().getStringExtra(EXTRA_URL);
        setTitle(url);
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Set DOM storage enabled for Local Storage
        webSettings.setDomStorageEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setCookiesOnWebView(url);
        webView.loadUrl(url);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setCookiesOnWebView(String url) {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        // Set Cookies
        List<String> cookies = getSessionCookies();
        String urlCookie = getURLCookie(url);
        if (StringUtils.isNotNullOrEmpty(urlCookie)) {
            cookies.add(urlCookie);
        }
        for (String cookie : cookies) {
            cookieManager.setCookie(COOKIE_DOMAIN, cookie);
        }
    }

    public static List<String> getSessionCookies() {
        List<String> cookieList = new ArrayList<>();
        // Set session cookies
        StringBuilder cookieString = new StringBuilder();
        cookieString.append("xid").append("=");
        cookieString.append("JJNaf4bf98cf1f311e68c2544a84212dacb1486993960G").append(";");
        cookieList.add(cookieString.toString());
        // sxid
        cookieString = new StringBuilder();
        cookieString.append("sxid").append("=");
        cookieString.append("eyJ2ZXJzaW9uIjogMCwidG9rZW4iOiJkVDlmOHpBYjlrTDM4R2RmYXZhSUc1RW1MMmhGT3lkbllqMGtnNlNXZVVTTTA5TTI0VFYrS0Q3SFFPVThreFNWV0V5WkFiQ2htUUlnNU0xYmdjYUZzdWtST1BFTGlvRit6clhNNGFRK3lrWGV6N09NSXBPN0RUWnBGWXZWbm15MmlOVXFTYnNNSi9DbCtWUTY1RkFVVWdTWm1TY2hlKzcvUjZqSGwxaS8yeDg9In0").append("; secure");
        cookieList.add(cookieString.toString());
        return cookieList;
    }

    public static String getURLCookie(String url) {
        return COOKIE_URL + "=" + url + ";";
    }

}
