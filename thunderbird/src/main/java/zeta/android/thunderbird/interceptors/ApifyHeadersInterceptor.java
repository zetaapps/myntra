package zeta.android.thunderbird.interceptors;

import java.io.IOException;

import javax.annotation.ParametersAreNonnullByDefault;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@ParametersAreNonnullByDefault
public class ApifyHeadersInterceptor implements Interceptor {

    public ApifyHeadersInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //TODO :: Add the dev api headers here
        Request request = chain.request();
        request = request
                .newBuilder()
                .build();
        return chain.proceed(request);
    }
}
