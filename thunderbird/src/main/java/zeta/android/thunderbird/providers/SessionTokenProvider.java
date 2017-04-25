package zeta.android.thunderbird.providers;

/**
 * Simple contract to maintain the session as per client / at caller discretion
 */
public interface SessionTokenProvider {

    String getSessionIdOrXid();

    String getCsrfTokenOrXsrf();

    String getSecureSessionIdOrSxid();

    void setSessionIdOrXid(String sessionIdOrXid);

    void setCsrfTokenOrXsrf(String csrfTokenOrXsrf);

    void setSecureSessionIdOrSxid(String secureSessionIdOrSxid);
}
