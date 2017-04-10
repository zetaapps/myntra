package zeta.android.thunderbird.api.apify;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.ComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpResponse;

@ParametersAreNonnullByDefault
public interface MyntraApify {

    @GET("product/{styleId}")
    Observable<Response<ComponentizationResponse>> getProductDetailsComponentizedResponse(@Path("styleId") int styleId,
                                                                                          @Query("co") int co);


    @GET("product/{styleId}")
    Observable<Response<PdpResponse>> getProductDetailsResponse(@Path("styleId") int styleId);

}