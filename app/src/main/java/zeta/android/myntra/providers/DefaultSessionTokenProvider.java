package zeta.android.myntra.providers;

import zeta.android.myntra.providers.interfaces.SharedPrefProvider;
import zeta.android.thunderbird.providers.SessionTokenProvider;
import zeta.android.utils.lang.StringUtils;

public class DefaultSessionTokenProvider implements SessionTokenProvider {

    /**
     * KEY_XID is the session id which comes as part of meta response.
     * KEY_XID == token
     */
    private static final String KEY_XID = "key_token_xid";

    /**
     * XSRF is CSRF token which comes as part of meta response.
     * XSRF == xsrfToken
     */
    private static final String KEY_XSRF = "key_csrf_token_xsrf";

    /**
     * SXID is the secure session id which comes as part of header response.
     * SXID == sxid / at (Access token)
     */
    private static final String KEY_SXID = "key_secure_token_sxid";

    private SharedPrefProvider mSharedPrefProvider;

    public DefaultSessionTokenProvider(SharedPrefProvider sharedPrefProvider) {
        mSharedPrefProvider = sharedPrefProvider;
    }

    @Override
    public String getSessionIdOrXid() {
        return mSharedPrefProvider.getZetaPrefs().getString(KEY_XID, StringUtils.EMPTY_STRING);
    }

    @Override
    public String getCsrfTokenOrXsrf() {
        return mSharedPrefProvider.getZetaPrefs().getString(KEY_XSRF, StringUtils.EMPTY_STRING);
    }

    @Override
    public String getSecureSessionIdOrSxid() {
        return mSharedPrefProvider.getZetaPrefs().getString(KEY_SXID, StringUtils.EMPTY_STRING);
    }

    @Override
    public void setSessionIdOrXid(String sessionIdOrXid) {
        mSharedPrefProvider.getZetaPrefs().edit().putString(KEY_XID, sessionIdOrXid).apply();
    }

    @Override
    public void setCsrfTokenOrXsrf(String csrfTokenOrXsrf) {
        mSharedPrefProvider.getZetaPrefs().edit().putString(KEY_XSRF, csrfTokenOrXsrf).apply();
    }

    @Override
    public void setSecureSessionIdOrSxid(String secureSessionIdOrSxid) {
        mSharedPrefProvider.getZetaPrefs().edit().putString(KEY_SXID, secureSessionIdOrSxid).apply();
    }
}
