package zeta.android.myntra.network.exception;

import java.io.IOException;

public class ZetaNoNetworkConnectivityException extends IOException {

    public ZetaNoNetworkConnectivityException() {
        super();
    }

    @Override
    public String getMessage() {
        return "No network connectivity found";
    }

}
