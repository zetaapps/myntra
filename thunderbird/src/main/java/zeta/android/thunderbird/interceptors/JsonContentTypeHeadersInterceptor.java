package zeta.android.thunderbird.interceptors;

import java.io.IOException;

import javax.annotation.ParametersAreNonnullByDefault;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_ACCEPT;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.KEY.KEY_CONTENT_TYPE;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.VALUE.VALUE_ACCEPT;
import static zeta.android.thunderbird.interceptors.MyntraHttpHeadersInterceptorConst.VALUE.VALUE_CONTENT_TYPE;

@ParametersAreNonnullByDefault
public class JsonContentTypeHeadersInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request
                .newBuilder()
                .header(KEY_ACCEPT, VALUE_ACCEPT)
                .header(KEY_CONTENT_TYPE, VALUE_CONTENT_TYPE)
                .build();
        return chain.proceed(request);
    }
}
