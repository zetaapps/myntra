package zeta.android.thunderbird.api.devapi;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import zeta.android.thunderbird.api.devapi.response.feed.FeedHeaderResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedSideShowResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.api.devapi.response.search.SearchResponse;

@ParametersAreNonnullByDefault
public interface MyntraDevApi {

    @GET("/lgp/v2.8/stream")
    Observable<Response<FeedResponse>> getFeedResponse();

    @GET("/lgp/v2.8/stream/header")
    Observable<Response<FeedHeaderResponse>> getFeedHeaderResponse();

    @GET("/lgp/v2.8/stream/slideshow")
    Observable<Response<FeedSideShowResponse>> getFeedSlideShowResponse();

    @GET("v2/search/data/{query}")
    Observable<Response<SearchResponse>> getSearchResultResponse(@Path("query") String query,
                                                                 @Query("p") int pageNumber,
                                                                 @Query("row") int pageSize);

    @GET("style/{styleId}")
    Observable<Response<PdpResponse>> getProductDetailsResponse(@Path("styleId") int styleId);

}