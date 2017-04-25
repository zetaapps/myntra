package zeta.android.thunderbird.interceptors;

public class MyntraHttpHeadersInterceptorConst {

    public interface KEY {

        String KEY_ACCEPT = "Accept";
        String KEY_CONTENT_TYPE = "Content-Type";
        String KEY_ACCEPT_LANGUAGE = "Accept-Language";

        /**
         * KEY_XID is the session id which comes as part of meta response.
         * KEY_XID == token
         */
        String KEY_XID = "token";

        /**
         * XSRF is CSRF token which comes as part of meta response.
         * XSRF == xsrfToken
         */
        String KEY_XSRF = "xsrf";

        /**
         * SXID is the secure session id which comes as part of header response.
         * SXID == sxid / at (Access token)
         */
        String KEY_SXID = "sxid";

    }

    public interface VALUE {
        String VALUE_ACCEPT = "application/json";
        String VALUE_CONTENT_TYPE = "application/json";
        String VALUE_ACCEPT_LANGUAGE = "en-US,en;q=0.5";

        String VALUE_ZERO_EMPTY = "0";
    }

}
