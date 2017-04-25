package zeta.android.myntra.ui.activity.helpers;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.myntra.ui.activity.WebViewActivity;

@ParametersAreNonnullByDefault
public class WebViewFallback implements CustomTabActivityHelper.CustomTabFallback {

    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, uri.toString());
        activity.startActivity(intent);
    }

}
