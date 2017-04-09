package zeta.android.thunderbird.modules;

import java.util.List;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;
import rx.Observable;
import zeta.android.thunderbird.api.devapi.MyntraDevApi;
import zeta.android.thunderbird.api.devapi.response.feed.FeedHeaderResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedSideShowResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.api.devapi.response.search.SearchResponse;
import zeta.android.thunderbird.managers.SearchManager;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.search.SearchModel;
import zeta.android.thunderbird.models.transformers.SearchModelTransformer;
import zeta.android.thunderbird.qualifiers.retrofit.RetrofitDevApi;
import zeta.android.thunderbird.utils.TestUtils;

@Module
public class SearchModule {

    @Provides
    MyntraDevApi providesMyntraApi(MockRetrofit retrofit) {
        //Mock the response form the test json file
        final BehaviorDelegate<MyntraDevApi> myntraDevApiBehaviorDelegate = retrofit.create(MyntraDevApi.class);
        return new MyntraDevApi() {

            @Override
            public Observable<Response<FeedResponse>> getFeedResponse() {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("feed_stream.json", FeedResponse.class))
                        .getFeedResponse();
            }

            @Override
            public Observable<Response<FeedHeaderResponse>> getFeedHeaderResponse() {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("feed_header.json", FeedHeaderResponse.class))
                        .getFeedHeaderResponse();
            }

            @Override
            public Observable<Response<FeedSideShowResponse>> getFeedSlideShowResponse() {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("feed_slide_show.json", FeedSideShowResponse.class))
                        .getFeedSlideShowResponse();
            }

            @Override
            public Observable<Response<SearchResponse>> getSearchResultResponse(@Path("query") String query,
                                                                                @Query("p") int pageNumber,
                                                                                @Query("row") int pageSize) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("search_response_tshirt.json", SearchResponse.class))
                        .getSearchResultResponse(query, pageNumber, pageSize);
            }

            @Override
            public Observable<Response<PdpResponse>> getProductDetailsResponse(@Path("styleId") int styleId) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_response_1291342.json", PdpResponse.class))
                        .getProductDetailsResponse(styleId);
            }
        };
    }

    @Provides
    ITransformer<SearchResponse, SearchModel> providesSearchTransformer() {
        return new SearchModelTransformer();
    }

    @Provides
    SearchManager providesSearchManager(MyntraDevApi devApi,
                                        ITransformer<SearchResponse, SearchModel> transformer) {
        return new SearchManager(devApi, transformer);
    }


    //region automation
    @Provides
    NetworkBehavior providesNetworkBehavior() {
        // by default, 3% of the network requests would fail at random and we don't want them to fail.
        NetworkBehavior networkBehavior = NetworkBehavior.create();
        networkBehavior.setFailurePercent(0);
        // no delay
        networkBehavior.setDelay(0, TimeUnit.MILLISECONDS);
        return networkBehavior;
    }

    @Provides
    MockRetrofit providesMockRetrofit(@RetrofitDevApi Retrofit retrofit,
                                      NetworkBehavior networkBehavior) {
        return new MockRetrofit.Builder(retrofit)
                .networkBehavior(networkBehavior)
                .build();
    }
    //endregion automation

    private <T> Call<T> buildResponse(String fileName, Class<T> clazz) {
        return Calls.response(TestUtils.deserialize(fileName, clazz));
    }

    private <T> Call<List<T>> buildListResponse(String fileName, Class<T[]> clazz) {
        return Calls.response(TestUtils.deserializeList(fileName, clazz));
    }
}
