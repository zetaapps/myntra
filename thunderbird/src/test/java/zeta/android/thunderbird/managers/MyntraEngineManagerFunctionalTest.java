package zeta.android.thunderbird.managers;

import android.support.annotation.NonNull;

import com.github.zetaapps.either.Either;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import retrofit2.Response;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;
import rx.observers.TestSubscriber;
import zeta.android.thunderbird.ApiTestBase;
import zeta.android.thunderbird.api.devapi.MyntraDevApi;
import zeta.android.thunderbird.api.devapi.response.feed.FeedHeaderResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedSideShowResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.api.devapi.response.search.SearchResponse;
import zeta.android.thunderbird.managers.params.ProductDetailsParams;
import zeta.android.thunderbird.models.pdp.PdpModel;
import zeta.android.thunderbird.models.pdp.errors.PdpException;
import zeta.android.thunderbird.models.products.ProductId;
import zeta.android.thunderbird.models.transformers.ProductsModelTransformer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ParametersAreNonnullByDefault
public class MyntraEngineManagerFunctionalTest extends ApiTestBase {

    private ProductsManager mProductsManager;

    @Before
    public void setUpMockRetrofit() {
        super.setUpMockRetrofit();

        //Mock the response form the test json file
        final BehaviorDelegate<MyntraDevApi> myntraDevApiBehaviorDelegate = mMockRetrofit.create(MyntraDevApi.class);
        MyntraDevApi mMyntraDevApi = new MyntraDevApi() {

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
            public Observable<Response<SearchResponse>> getSearchResultResponse(@NonNull @Path("query") String query,
                                                                                @Query("p") int pageNumber,
                                                                                @Query("row") int pageSize) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("search_response_nike.json", SearchResponse.class))
                        .getSearchResultResponse(query, pageNumber, pageSize);
            }

            @Override
            public Observable<Response<PdpResponse>> getProductDetailsResponse(@Path("styleId") int styleId) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_response_1291342.json", PdpResponse.class))
                        .getProductDetailsResponse(styleId);
            }
        };

        ProductsModelTransformer mProductsModelTransformer = new ProductsModelTransformer();
        mProductsManager = new ProductsManager(mMyntraDevApi, mProductsModelTransformer);
    }

    @Test
    public void testMyntraEngineProductManager() throws Exception {
        TestSubscriber<Either<PdpModel, PdpException>> testSubscriber = new TestSubscriber<>();
        mProductsManager.getProductDetails(ProductDetailsParams.create(ProductId.create(1291342).build()).build()).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Either<PdpModel, PdpException>> onNextEvents = testSubscriber.getOnNextEvents();
        Either<PdpModel, PdpException> either = onNextEvents.get(0);

        PdpModel successValue = either.successValue;
        PdpException failureValue = either.failureValue;

        assert successValue != null;
        assert failureValue == null;

        assertEquals(1291342, successValue.getProductId().getRawProductId());
        assertEquals("Jaipur Kurti Black Printed Top", successValue.getProductTitle());
        assertNull(successValue.getProductDescription());
    }

}