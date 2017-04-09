package zeta.android.thunderbird.api.apify;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import zeta.android.thunderbird.api.apify.response.pdp.PdpV3Response;

@ParametersAreNonnullByDefault
public interface MyntraApify {

    @GET("product/{styleId}")
    Observable<Response<PdpV3Response>> getProductDetailsV3Response(@Path("styleId") int styleId,
                                                                    @Query("co") int co);

}
