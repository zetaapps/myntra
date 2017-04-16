package zeta.android.myntra.util.deeplink;

import android.app.Activity;
import android.net.Uri;

import org.json.JSONException;

import javax.annotation.ParametersAreNonnullByDefault;

import io.branch.referral.Branch;
import io.branch.referral.BranchError;

@ParametersAreNonnullByDefault
public class BranchDeepLinkUtil {

    private interface Params {
        String EMBEDDED_DEEP_LINK = "myntralink";
    }

    public interface BranchDeepLinkHandler {
        void onBranchDeepLinkFound(Uri uri);

        void onBranchDeepLinkSDKError(BranchError error);

        void onBranchDeepLinkPayloadParsingError(JSONException exception);
    }

    public static boolean processDeepLink(Activity activity, Branch branch, Uri uri,
                                          final BranchDeepLinkHandler deepLinkHandler) {
        return branch.initSession((referringParams, error) -> {
            if (error != null) {
                deepLinkHandler.onBranchDeepLinkSDKError(error);
                return;
            }

            if (referringParams == null || !referringParams.has(Params.EMBEDDED_DEEP_LINK)) {
                return;
            }

            try {
                String deepLink = referringParams.getString(Params.EMBEDDED_DEEP_LINK);
                deepLinkHandler.onBranchDeepLinkFound(Uri.parse(deepLink));
            } catch (JSONException e) {
                deepLinkHandler.onBranchDeepLinkPayloadParsingError(e);
            }
        }, uri, activity);
    }
}
