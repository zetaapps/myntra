package zeta.android.thunderbird.api.apify;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3Response;

@ParametersAreNonnullByDefault
public interface MyntraApify {

    @GET("product/{styleId}")
    Observable<Response<PdpComponentizationResponse>> getProductDetailsComponentizedResponse(@Path("styleId") int styleId,
                                                                                             @Query("co") int co);
    @GET("product/{styleId}")
    Observable<Response<PdpV3Response>> getProductDetailsResponse(@Path("styleId") int styleId);

}