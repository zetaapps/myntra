package zeta.android.thunderbird.api.devapi;

import android.support.annotation.NonNull;

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
import zeta.android.thunderbird.api.devapi.response.feed.FeedActivitiesResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedCardsResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedCarouselResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedChildrenPropResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedChildrenResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumContentResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumDataResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumDescriptionResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumMetaResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumParentResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumPostEntriesResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumTopParentResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumTopicResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumUserResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedHeaderResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedImagesResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedMetaResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedPropsResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedSlideShowResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedSlidesResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpArticleAttributesResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpArticleDisplayAttrResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpArticleTypeResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpCoreResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpCrossLinksResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpDataResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpDefaultStyleImagesResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpDescriptionResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpDiscountDataResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpDiscountTextResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpDiscountToolTipTextResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpExploreResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpMasterCategoryResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpMaterialsCareDescResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpMetaResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpNotificationResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpOtherFlagResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpProductDescriptorsResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResolutionsResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpServiceabilityDisclaimerResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpSizeFitDescResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpSocialResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpStyleImagesResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpStyleNoteResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpStyleOptionsResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpSubCategoryResponse;
import zeta.android.thunderbird.api.devapi.response.search.SearchDataResponse;
import zeta.android.thunderbird.api.devapi.response.search.SearchMetaResponse;
import zeta.android.thunderbird.api.devapi.response.search.SearchProductsResponse;
import zeta.android.thunderbird.api.devapi.response.search.SearchResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@ParametersAreNonnullByDefault
public class MyntraDevApiTest extends ApiTestBase {

    private MyntraDevApi myntraDevApi;

    @Before
    public void setUpMockRetrofit() {
        super.setUpMockRetrofit();

        //Mock the response form the test json file
        final BehaviorDelegate<MyntraDevApi> myntraDevApiBehaviorDelegate = mMockRetrofit.create(MyntraDevApi.class);
        myntraDevApi = new MyntraDevApi() {

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
            public Observable<Response<FeedSlideShowResponse>> getFeedSlideShowResponse() {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("feed_slide_show.json", FeedSlideShowResponse.class))
                        .getFeedSlideShowResponse();
            }

            @Override
            public Observable<Response<FeedForumResponse>> getFeedForumResponse() {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("feed_forum.json", FeedForumResponse.class))
                        .getFeedForumResponse();
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
    }

    @Test
    public void getFeedResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        assertEquals(13, feedResponse.count);
        assertEquals("/v2.8/stream//history?ub=&da=1491731122398", feedResponse.pageResponse.previous);
    }

    @Test
    public void getFeedCardResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        List<FeedCardsResponse> feedCardsResponseList = feedResponse.cards;
        assertEquals(13, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assertNotNull(feedCardsResponse);
        assertEquals("COMPONENT_CARD", feedCardsResponse.cardType);

    }

    @Test
    public void getFeedCardPropsResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        List<FeedCardsResponse> feedCardsResponseList = feedResponse.cards;
        assertEquals(13, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assertNotNull(feedCardsResponse);
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assertNotNull(feedPropsResponse);
        assertEquals("2:941a2132-1bdc-42aa-ab95-bf52684b268e", feedPropsResponse.id);
        assertEquals("53bce5c1-2488-44f6-b2e9-6120706f8394", feedPropsResponse.storyId);

    }

    @Test
    public void getFeedCardMetaResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        List<FeedCardsResponse> feedCardsResponseList = feedResponse.cards;
        assertEquals(13, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assertNotNull(feedCardsResponse);
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assertNotNull(feedPropsResponse);
        FeedMetaResponse feedMetaResponse = feedPropsResponse.metaResponse;
        assert feedMetaResponse != null;
        assertEquals("carousel-banner", feedMetaResponse.ogName);
        assertEquals(2, feedMetaResponse.ogApp.id);
        assertEquals("http://assets.myntassets.com/assets/images/retaillabs/2017/1/16/11484565115707-AMERICAN-TOURISTER-_BF.jpg,http://assets.myntassets.com/assets/images/retaillabs/2017/1/16/11484565177132-jaipurkurti_AHPMB_BF5.jpg,http://assets.myntassets.com/assets/images/retaillabs/2017/1/18/11484718340471-MNH-BrandsInFocus__BF_MP_WP.jpg,http://assets.myntassets.com/assets/images/retaillabs/2017/1/19/11484818682274-Fort-Collins--AHPMB_BF4.jpg,http://assets.myntassets.com/assets/images/retaillabs/2017/1/19/11484825633505-fossil_AHPMB_BF3.jpg,http://assets.myntassets.com/assets/images/retaillabs/2017/1/19/11484835456518-UCB-BF.jpg",feedMetaResponse.ogImageUrl);
        assertEquals("http://www.myntra.com/mailers/feedcard/2:941a2132-1bdc-42aa-ab95-bf52684b268e", feedMetaResponse.share.ogUrl);
        assertEquals("Best of EOSS", feedMetaResponse.share.ogTitle);
        assertEquals("sponsored,List", feedMetaResponse.publisherTag);
        assertEquals("List", feedMetaResponse.contentType);
        assertEquals("sponsored", feedMetaResponse.source);

    }

    @Test
    public void getFeedCardActivitiesResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        List<FeedCardsResponse> feedCardsResponseList = feedResponse.cards;
        assertEquals(13, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assertNotNull(feedCardsResponse);
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assertNotNull(feedPropsResponse);
        FeedActivitiesResponse feedActivitiesResponse = feedPropsResponse.activitiesResponse;
        assert feedActivitiesResponse != null;
        assertEquals(false, feedActivitiesResponse.like.liked);
        assertEquals(false, feedActivitiesResponse.spam.spammed);
        assertEquals(20, feedActivitiesResponse.click.count);

    }

    @Test
    public void getFeedCardChildrenResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        List<FeedCardsResponse> feedCardsResponseList = feedResponse.cards;
        assertEquals(13, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assertNotNull(feedCardsResponse);
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(2, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(0);
        assertNotNull(feedChildrenResponse);
        assertEquals("TITLE_TEXT", feedChildrenResponse.feedCardType);

    }

    @Test
    public void getFeedCardCarouselListResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        List<FeedCardsResponse> feedCardsResponseList = feedResponse.cards;
        assertEquals(13, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assertNotNull(feedCardsResponse);
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(2, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(1);
        assertNotNull(feedChildrenResponse);
        FeedChildrenPropResponse feedChildrenPropResponse = feedChildrenResponse.feedChildProp;
        assertNotNull(feedChildrenPropResponse);
        List<FeedCarouselResponse> feedCarouselResponseList = feedChildrenPropResponse.carousel;
        assertEquals(6, feedCarouselResponseList.size());

    }

    @Test
    public void getFeedCardMosaicResponseTest() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assertNotNull(feedResponse);
        List<FeedCardsResponse> feedCardsResponseList = feedResponse.cards;
        assertEquals(13, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(1);
        assertNotNull(feedCardsResponse);
        assertEquals("COMPONENT_CARD", feedCardsResponse.cardType);
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(6, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(1);
        assertNotNull(feedChildrenResponse);
        assertEquals("MOSAIC", feedChildrenResponse.feedCardType);
        FeedChildrenPropResponse feedChildrenPropResponse = feedChildrenResponse.feedChildProp;
        assertNotNull(feedChildrenPropResponse);
        List<FeedImagesResponse> feedImagesResponseList = feedChildrenPropResponse.images;
        assertEquals(5,feedImagesResponseList.size());

    }

    @Test
    public void getFeedHeaderResponse() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
    }

    @Test
    public void getFeedSlideShowResponseTest() throws Exception {
        TestSubscriber<Response<FeedSlideShowResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedSlideShowResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedSlideShowResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedSlideShowResponse feedSlideShowResponse = onNextEvents.get(0).body();
        assert feedSlideShowResponse != null;
        assertEquals(1, feedSlideShowResponse.count);
        List<FeedCardsResponse> feedCardsResponseList = feedSlideShowResponse.cards;
        assertEquals(1, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assert feedCardsResponse != null;
        assertEquals("COMPONENT_CARD", feedCardsResponse.cardType);
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(1, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(0);
        assert feedChildrenResponse != null;
        assertEquals("SLIDESHOW", feedChildrenResponse.feedCardType);
    }

    @Test
    public void getFeedSlideResponseTest() throws Exception {
        TestSubscriber<Response<FeedSlideShowResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedSlideShowResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedSlideShowResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedSlideShowResponse feedSlideShowResponse = onNextEvents.get(0).body();
        assert feedSlideShowResponse != null;
        assertEquals(1, feedSlideShowResponse.count);
        List<FeedCardsResponse> feedCardsResponseList = feedSlideShowResponse.cards;
        assertEquals(1, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assert feedCardsResponse != null;
        assertEquals("COMPONENT_CARD", feedCardsResponse.cardType);
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(1, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(0);
        assert feedChildrenResponse != null;
        assertEquals("SLIDESHOW", feedChildrenResponse.feedCardType);
        List<FeedSlidesResponse> feedSlidesResponseList = feedChildrenResponse.feedChildProp.slides;
        assertEquals(2, feedSlidesResponseList.size());
        FeedSlidesResponse feedSlidesResponse = feedSlidesResponseList.get(0);
        assert feedSlidesResponse != null;
        assertEquals("List", feedSlidesResponse.contentType);
        assertEquals("Shop Now", feedSlidesResponse.alt);
        assertEquals(9, feedSlidesResponse.height);
        assertEquals("2:890d5a2b-273b-42e3-b6f3-0fcb8773f02d", feedSlidesResponse.id);
        assertEquals("/shop/mantastic-jan17", feedSlidesResponse.link);
        assertEquals("MYNT_ASSETS", feedSlidesResponse.provider);
        assertEquals(16, feedSlidesResponse.width);
        assertEquals("http://assets.myntassets.com/assets/images/banners/2017/1/19/11484847333924-mantastic-desktop.jpg", feedSlidesResponse.src);
    }

    @Test
    public void getFeedSlideShowActivitiesResponseTest() throws Exception {
        TestSubscriber<Response<FeedSlideShowResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedSlideShowResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedSlideShowResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedSlideShowResponse feedSlideShowResponse = onNextEvents.get(0).body();
        assert feedSlideShowResponse != null;
        assertEquals(1, feedSlideShowResponse.count);
        List<FeedCardsResponse> feedCardsResponseList = feedSlideShowResponse.cards;
        assertEquals(1, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assert feedCardsResponse != null;
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assert feedPropsResponse != null;
        FeedActivitiesResponse feedActivitiesResponse = feedPropsResponse.activitiesResponse;
        assert feedActivitiesResponse != null;
        assertEquals(false, feedActivitiesResponse.like.liked);
        assertEquals(false, feedActivitiesResponse.spam.spammed);
        assertEquals(189, feedActivitiesResponse.click.count);

    }

    @Test
    public void getFeedSlideShowMetaResponseTest() throws Exception {
        TestSubscriber<Response<FeedSlideShowResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedSlideShowResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedSlideShowResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedSlideShowResponse feedSlideShowResponse = onNextEvents.get(0).body();
        assert feedSlideShowResponse != null;
        assertEquals(1, feedSlideShowResponse.count);
        List<FeedCardsResponse> feedCardsResponseList = feedSlideShowResponse.cards;
        assertEquals(1, feedCardsResponseList.size());
        FeedCardsResponse feedCardsResponse = feedCardsResponseList.get(0);
        assert feedCardsResponse != null;
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assert feedPropsResponse != null;
        FeedMetaResponse feedMetaResponse = feedPropsResponse.metaResponse;
        assert feedMetaResponse != null;
        assertEquals("slideshow", feedMetaResponse.ogName);
        assertEquals(2, feedMetaResponse.ogApp.id);
        assertEquals("http://assets.myntassets.com/assets/images/banners/2017/1/19/11484847333898-gd-desk.jpg,http://assets.myntassets.com/assets/images/banners/2017/1/19/11484847333924-mantastic-desktop.jpg", feedMetaResponse.ogImageUrl);
        assertEquals("http://www.myntra.com/mailers/feedcard/2:ddb1fcb8-97e1-41d1-a183-1d6f872c26b3", feedMetaResponse.share.ogUrl);
        assertEquals("", feedMetaResponse.share.ogTitle);
        assertEquals("slideshow,List", feedMetaResponse.publisherTag);
        assertEquals("List", feedMetaResponse.contentType);
        assertEquals("slideshow", feedMetaResponse.source);

    }


    @Test
    public void getFeedForumMetaResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumMetaResponse feedForumMetaResponse = feedForumResponse.meta;
        assert feedForumMetaResponse != null;
        assertEquals(200, feedForumMetaResponse.status);
    }

    @Test
    public void getFeedForumDataResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
    }

    @Test
    public void getFeedForumContentResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
        FeedForumContentResponse feedForumContentResponse = feedForumContentResponseList.get(0);
        assertEquals(238551, feedForumContentResponse.cardId);
        assertEquals("QUESTION", feedForumContentResponse.cardType);
        assertEquals("39933145.bbf9.42c1.b9ac.3b8f53d9e4adnAJoyqP2Vh", feedForumContentResponse.postOwnerId);
        assertEquals(false, feedForumContentResponse.isDeleted);
        assertEquals(false, feedForumContentResponse.isHidden);
        assertEquals("1492332779000", feedForumContentResponse.createdOn);
        assertEquals(2, feedForumContentResponse.topicId);
    }

    @Test
    public void getFeedForumPostEntriesResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
        FeedForumContentResponse feedForumContentResponse = feedForumContentResponseList.get(0);
        assert feedForumContentResponse != null;
        FeedForumPostEntriesResponse feedForumPostEntriesResponse = feedForumContentResponse.postEntries.get(0);
        assert feedForumPostEntriesResponse != null;
        assertEquals("QUESTION", feedForumPostEntriesResponse.type);
        assertEquals(110638, feedForumPostEntriesResponse.id);
        assertEquals(89773, feedForumPostEntriesResponse.since);
        assertEquals(false, feedForumPostEntriesResponse.isFeatured);
        assertEquals(false, feedForumPostEntriesResponse.isSpammed);
        assertEquals(false, feedForumPostEntriesResponse.isOwner);
        assertEquals(false, feedForumPostEntriesResponse.isLiked);
        assertEquals(false, feedForumPostEntriesResponse.isFollowed);
        assertEquals(false, feedForumPostEntriesResponse.hasAnswered);
        assertEquals(false, feedForumPostEntriesResponse.isAnonymous);
        assertEquals("1492332779000", feedForumPostEntriesResponse.createdAt);
        assertEquals(0, feedForumPostEntriesResponse.commentCount);
        assertEquals(0, feedForumPostEntriesResponse.answerCount);
        assertEquals(0, feedForumPostEntriesResponse.followersCount);
        assertEquals(0, feedForumPostEntriesResponse.commentCount);
        assertEquals(238551, feedForumPostEntriesResponse.cardId);
        assertEquals(false, feedForumPostEntriesResponse.isPublishedToAll);
        assertEquals(false, feedForumPostEntriesResponse.isFirst);

    }


    @Test
    public void getFeedForumDescriptionResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
        FeedForumContentResponse feedForumContentResponse = feedForumContentResponseList.get(0);
        assert feedForumContentResponse != null;
        FeedForumPostEntriesResponse feedForumPostEntriesResponse = feedForumContentResponse.postEntries.get(0);
        assert feedForumPostEntriesResponse != null;
        List<FeedForumDescriptionResponse> feedForumDescriptionResponseList = feedForumPostEntriesResponse.description;
        assertEquals(3, feedForumDescriptionResponseList.size());
        FeedForumDescriptionResponse feedForumDescriptionResponse = feedForumDescriptionResponseList.get(0);
        assert feedForumDescriptionResponse != null;
        assertEquals("TEXT", feedForumDescriptionResponse.type);
        assertEquals("What Type of footwear will look good with a capry type culloton?", feedForumDescriptionResponse.value);

    }


    @Test
    public void getFeedForumParentResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
        FeedForumContentResponse feedForumContentResponse = feedForumContentResponseList.get(0);
        assert feedForumContentResponse != null;
        FeedForumPostEntriesResponse feedForumPostEntriesResponse = feedForumContentResponse.postEntries.get(0);
        assert feedForumPostEntriesResponse != null;
        FeedForumParentResponse feedForumParentResponse = feedForumPostEntriesResponse.parent;
        assert feedForumParentResponse != null;
        assertNull(feedForumParentResponse.type);
        assertEquals(0, feedForumParentResponse.id);

    }

    @Test
    public void getFeedForumTopParentResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
        FeedForumContentResponse feedForumContentResponse = feedForumContentResponseList.get(0);
        assert feedForumContentResponse != null;
        FeedForumPostEntriesResponse feedForumPostEntriesResponse = feedForumContentResponse.postEntries.get(0);
        assert feedForumPostEntriesResponse != null;
        FeedForumTopParentResponse feedForumTopParentResponse = feedForumPostEntriesResponse.topParent;
        assert feedForumTopParentResponse != null;
        assertNull(feedForumTopParentResponse.type);
        assertEquals(0, feedForumTopParentResponse.id);

    }

    @Test
    public void getFeedForumUserResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
        FeedForumContentResponse feedForumContentResponse = feedForumContentResponseList.get(0);
        assert feedForumContentResponse != null;
        FeedForumPostEntriesResponse feedForumPostEntriesResponse = feedForumContentResponse.postEntries.get(0);
        assert feedForumPostEntriesResponse != null;
        FeedForumUserResponse feedForumUserResponse = feedForumPostEntriesResponse.user;
        assert feedForumUserResponse != null;

        assertEquals("Niharika Trama", feedForumUserResponse.firstname);
        assertNull(feedForumUserResponse.lastname);
        assertEquals("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xfp1/v/t1.0-1/p720x720/14376_861192333937733_2029720630944562471_n.jpg?oh=e140e22d8d69c20a4d5d14631ff410b9&oe=5603A1A1&__gda__=1442463924_c97973ce79cf7ebb9914de59ffc67783", feedForumUserResponse.image);
        assertEquals("EXTERNAL_URL", feedForumUserResponse.imageType);
        assertEquals("FEMALE", feedForumUserResponse.gender);
        assertNull(feedForumUserResponse.coverImage);
        assertNull(feedForumUserResponse.coverImageType);
        assertEquals("Niharika.Trama", feedForumUserResponse.publicProfileId);
        assertEquals("39933145.bbf9.42c1.b9ac.3b8f53d9e4adnAJoyqP2Vh", feedForumUserResponse.uidx);
        assertEquals(8, feedForumUserResponse.counts.followers);
        assertEquals(0, feedForumUserResponse.pLevel);
        assertNull(feedForumUserResponse.bio);
        assertEquals("Niharika Trama", feedForumUserResponse.name);

    }


    @Test
    public void getFeedForumTopicResponseTest() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assert feedForumResponse != null;
        FeedForumDataResponse feedForumDataResponse = feedForumResponse.data;
        assert feedForumDataResponse != null;
        List<FeedForumContentResponse> feedForumContentResponseList = feedForumDataResponse.feed;
        assertEquals(10, feedForumContentResponseList.size());
        FeedForumContentResponse feedForumContentResponse = feedForumContentResponseList.get(0);
        assert feedForumContentResponse != null;
        FeedForumPostEntriesResponse feedForumPostEntriesResponse = feedForumContentResponse.postEntries.get(0);
        assert feedForumPostEntriesResponse != null;
        List<FeedForumTopicResponse> feedForumTopicResponseList = feedForumPostEntriesResponse.topics;
        assertEquals(1, feedForumTopicResponseList.size());
        FeedForumTopicResponse feedForumTopicResponse = feedForumTopicResponseList.get(0);
        assertEquals("Women's Fashion", feedForumTopicResponse.topicTitle);
        assertEquals(2, feedForumTopicResponse.topicId);
        assertEquals(false, feedForumTopicResponse.isDeleted);


    }

    @Test
    public void getFeedHeaderResponseTest() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
        FeedCardsResponse feedCardsResponse = feedHeaderResponse.cards.get(0);
        assertEquals("COMPONENT_CARD", feedCardsResponse.cardType);

    }

    @Test
    public void getFeedHeaderPropsResponseTest() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
        FeedCardsResponse feedCardsResponse = feedHeaderResponse.cards.get(0);
        assert feedCardsResponse != null;
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assert feedPropsResponse != null;
        assertEquals("2:bd8fb0d3-e0eb-4f2e-b2b5-0ee2d80b70a0", feedPropsResponse.id);
        assertEquals("f801f4e6-e11e-4e9a-8aa3-0e98f4561cad", feedPropsResponse.storyId);

    }

    @Test
    public void getFeedHeaderMetaResponseTest() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
        FeedCardsResponse feedCardsResponse = feedHeaderResponse.cards.get(0);
        assert feedCardsResponse != null;
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assert feedPropsResponse != null;
        FeedMetaResponse feedMetaResponse = feedPropsResponse.metaResponse;
        assert feedMetaResponse != null;
        assertEquals("suggestions", feedMetaResponse.ogName);
        assertEquals(2, feedMetaResponse.ogApp.id);
        assertEquals("http://assets.myntassets.com/assets/images/banners/2017/4/7/11491589051168-Women.jpg,http://assets.myntassets.com/assets/images/banners/2017/4/7/11491589051180-Men.jpg,http://assets.myntassets.com/assets/images/banners/2017/4/7/11491589051199-Launchpad.jpg,http://assets.myntassets.com/assets/images/banners/2017/4/7/11491589051214-Kids.jpg,http://assets.myntassets.com/assets/images/banners/2017/4/8/11491593692042-YOUR-PAGE.jpg", feedMetaResponse.ogImageUrl);
        assertEquals("http://www.myntra.com/mailers/feedcard/2:bd8fb0d3-e0eb-4f2e-b2b5-0ee2d80b70a0", feedMetaResponse.share.ogUrl);
        assertEquals("", feedMetaResponse.share.ogTitle);
        assertEquals("header,header", feedMetaResponse.publisherTag);
        assertEquals("header", feedMetaResponse.contentType);
        assertEquals("header", feedMetaResponse.source);

    }

    @Test
    public void getFeedHeaderActivitiesResponseTest() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
        FeedCardsResponse feedCardsResponse = feedHeaderResponse.cards.get(0);
        assert feedCardsResponse != null;
        FeedPropsResponse feedPropsResponse = feedCardsResponse.feedPropsResponse;
        assert feedPropsResponse != null;
        FeedActivitiesResponse feedActivitiesResponse = feedPropsResponse.activitiesResponse;
        assert feedActivitiesResponse != null;
        assertEquals(false, feedActivitiesResponse.like.liked);
        assertEquals(false, feedActivitiesResponse.spam.spammed);
        assertEquals(839106, feedActivitiesResponse.click.count);

    }

    @Test
    public void getFeedHeaderChildrenResponseTest() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
        FeedCardsResponse feedCardsResponse = feedHeaderResponse.cards.get(0);
        assert feedCardsResponse != null;
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(1, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(0);
        assert feedChildrenResponse != null;
        assertEquals("TOPNAV_CAROUSEL", feedChildrenResponse.feedCardType);
        assertEquals(false, feedChildrenResponse.feedChildProp.transparency);

    }

    @Test
    public void getFeedHeaderCarouselResponseTest() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
        FeedCardsResponse feedCardsResponse = feedHeaderResponse.cards.get(0);
        assert feedCardsResponse != null;
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(1, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(0);
        assert feedChildrenResponse != null;
        List<FeedCarouselResponse> feedCarouselResponseList = feedChildrenResponse.feedChildProp.carousel;
        assertEquals(5, feedCarouselResponseList.size());
        FeedCarouselResponse feedCarouselResponse = feedCarouselResponseList.get(0);
        assert feedCarouselResponse != null;
        assertEquals("/growth/fashiongig17", feedCarouselResponse.actionLink);
        assertEquals("top-nav", feedCarouselResponse.contentType);
        assertEquals("2:cd5d5a25-34d3-4d2e-bbdf-1f0fffff1074", feedCarouselResponse.id);
        assertEquals("", feedCarouselResponse.title);

    }


    @Test
    public void getFeedHeaderImageResponseTest() throws Exception {
        TestSubscriber<Response<FeedHeaderResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedHeaderResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedHeaderResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedHeaderResponse feedHeaderResponse = onNextEvents.get(0).body();
        assert feedHeaderResponse != null;
        assertEquals(1, feedHeaderResponse.count);
        FeedCardsResponse feedCardsResponse = feedHeaderResponse.cards.get(0);
        assert feedCardsResponse != null;
        List<FeedChildrenResponse> feedChildrenResponseList = feedCardsResponse.feedContent;
        assertEquals(1, feedChildrenResponseList.size());
        FeedChildrenResponse feedChildrenResponse = feedChildrenResponseList.get(0);
        assert feedChildrenResponse != null;
        List<FeedCarouselResponse> feedCarouselResponseList = feedChildrenResponse.feedChildProp.carousel;
        assertEquals(5, feedCarouselResponseList.size());
        FeedCarouselResponse feedCarouselResponse = feedCarouselResponseList.get(0);
        assert feedCarouselResponse != null;
        FeedImagesResponse feedImagesResponse = feedCarouselResponse.image;
        assert feedImagesResponse != null;
        assertEquals("MYNT_ASSETS", feedImagesResponse.imageSourceProvider);
        assertEquals("http://assets.myntassets.com/assets/images/banners/2017/4/8/11491593692042-YOUR-PAGE.jpg", feedImagesResponse.imageSourceUrl);
        assertEquals(13, feedImagesResponse.height);
        assertEquals(20, feedImagesResponse.width);
    }


    @Test
    public void getSearchResultResponse() throws Exception {
        TestSubscriber<Response<SearchResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getSearchResultResponse("nike", 1, 20).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<SearchResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        SearchResponse searchResponse = onNextEvents.get(0).body();

        SearchDataResponse data = searchResponse.data;
        SearchMetaResponse meta = searchResponse.meta;

        List<SearchProductsResponse> products = data.results.products;
        assert products != null;
        SearchProductsResponse searchProductsResponse = products.get(0);
        assert searchProductsResponse != null;

        assertEquals(200, meta.code);
        assertEquals("Nike Men Blue AS M NSW CRW FLC AIR Pullover Sweatshirt", searchProductsResponse.productTitle);
        assertEquals("Nike Men Blue AS M NSW CRW FLC AIR Pullover Sweatshirt", searchProductsResponse.styleName);
        assertEquals(1601830, searchProductsResponse.productId);
        assertEquals(0, searchProductsResponse.discount);
        assertEquals("http://myntra.myntassets.com/assets/images/1601830/2016/11/21/11479707823353-Nike-Men-Blue-Solid-Pullover-Sweatshirt-5921479707822951-1.jpg",
                searchProductsResponse.searchImage.toString());
        assertEquals("Nike", searchProductsResponse.brandsFilterFacets);
    }

    @Test
    public void getProductDetailsResponse() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        PdpMetaResponse pdpMetaResponse = response.pdpMetaResponse;
        PdpNotificationResponse pdpNotificationResponse = response.pdpNotificationResponse;

        assert pdpDataResponse != null;
        assert pdpMetaResponse != null;
        assert pdpNotificationResponse != null;

        assertEquals(1291342, pdpDataResponse.productId);
        assertEquals(699, pdpDataResponse.price);
        assertEquals(419, pdpDataResponse.discountedPrice);

        assertEquals("P", pdpDataResponse.styleType);
        assertEquals("JK2695-Black-1291342", pdpDataResponse.articleNumber);
        assertEquals("", pdpDataResponse.visualTag);
        assertEquals("Jaipur Kurti Black Printed Top", pdpDataResponse.productDisplayName);
        assertEquals("Jaipurkurti Black Cotton Printed  Top", pdpDataResponse.variantName);
        assertEquals("Jaipur Kurti", pdpDataResponse.brandName);
        assertEquals("Adults-Women", pdpDataResponse.ageGroup);
        assertEquals("Women", pdpDataResponse.gender);
        assertEquals("Black", pdpDataResponse.baseColour);

        assertEquals("NA", pdpDataResponse.colour1);
        assertEquals("NA", pdpDataResponse.colour2);
        assertEquals("Fashion", pdpDataResponse.fashionType);
        assertEquals("Summer", pdpDataResponse.season);
        assertEquals("2016", pdpDataResponse.year);
        assertEquals("Casual", pdpDataResponse.usage);
        assertEquals(0, pdpDataResponse.navigationId);
        assertEquals("Tops/Jaipur-Kurti/Jaipur-Kurti-Black-Printed-Top/1291342/buy",
                pdpDataResponse.landingPageUrl);
    }

    @Test
    public void getProductDetailsMetaResponse() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpMetaResponse pdpMetaResponse = response.pdpMetaResponse;

        assert pdpMetaResponse != null;

        assertEquals(200, pdpMetaResponse.code);

    }


    @Test
    public void getPdpArticleAttributesResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpArticleAttributesResponse articleAttributesResponse = pdpDataResponse.articleAttributesResponse;
        assert articleAttributesResponse != null;


        assertEquals("Printed", articleAttributesResponse.pattern);
        assertEquals("Sleeveless", articleAttributesResponse.sleeveLength);
        assertEquals("Casual", articleAttributesResponse.occasion);
        assertEquals("Tribal or Aztec Print", articleAttributesResponse.mainTrend);
        assertEquals("Regular", articleAttributesResponse.type);
        assertEquals("Cotton", articleAttributesResponse.fabric);

    }

    @Test
    public void getPdpCrossLinksResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        List<PdpCrossLinksResponse> pdpCrossLinksResponseList = pdpDataResponse.crossLinksResponseList;
        assertEquals(3, pdpCrossLinksResponseList.size());

        PdpCrossLinksResponse pdpCrossLinksResponse = pdpCrossLinksResponseList.get(0);
        assert pdpCrossLinksResponse != null;

        assertEquals("More Tops by Jaipur Kurti", pdpCrossLinksResponse.key);
        assertEquals("tops?f=brand:Jaipur Kurti::gender:women", pdpCrossLinksResponse.value);

    }

    @Test
    public void getPdpArticleDisplayAttrResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpArticleDisplayAttrResponse pdpArticleDisplayAttrResponse = pdpDataResponse.articleDisplayAttr;
        assert pdpArticleDisplayAttrResponse != null;

        assertEquals(89, pdpArticleDisplayAttrResponse.id);

    }

    @Test
    public void getPdpCoreResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpCoreResponse pdpCoreResponse = pdpDataResponse.articleDisplayAttr.core;
        assert pdpCoreResponse != null;

        assertEquals("0", pdpCoreResponse.order);
        assertEquals("2", pdpCoreResponse.display);
        assertEquals("1", pdpCoreResponse.pdtDetail);
        assertEquals("2", pdpCoreResponse.pdtDeliveryOptions);
        assertEquals("2", pdpCoreResponse.pdtSimilar);
        assertEquals("2", pdpCoreResponse.pdtLike);


    }

    @Test
    public void getPdpSocialResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpSocialResponse pdpSocialResponse = pdpDataResponse.articleDisplayAttr.social;
        assert pdpSocialResponse != null;

        assertEquals("1", pdpSocialResponse.order);
        assertEquals("2", pdpSocialResponse.display);
        assertEquals("1", pdpSocialResponse.userLikes);
        assertEquals("2", pdpSocialResponse.styleNotes);
        assertEquals("1", pdpSocialResponse.crossSell);

    }

    @Test
    public void getPdpExploreResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpExploreResponse pdpExploreResponse = pdpDataResponse.articleDisplayAttr.explore;
        assert pdpExploreResponse != null;

        assertEquals("2", pdpExploreResponse.display);
        assertEquals("1", pdpExploreResponse.crosslink);
        assertEquals("1", pdpExploreResponse.similar);
        assertEquals("2", pdpExploreResponse.order);


    }

    @Test
    public void getPdpStyleImagesResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpStyleImagesResponse styleImagesResponse = pdpDataResponse.styleImages;
        assert styleImagesResponse != null;

        PdpDefaultStyleImagesResponse defaultStyleImagesResponse = styleImagesResponse.defaultImages;
        assert defaultStyleImagesResponse != null;

        assertEquals("default", defaultStyleImagesResponse.imageType);
        assertEquals("http://assets.myntassets.com/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg", defaultStyleImagesResponse.imageURL.toString());

        PdpResolutionsResponse pdpResolutionsResponse = defaultStyleImagesResponse.resolutions;
        assert pdpResolutionsResponse != null;

        assertEquals("http://assets.myntassets.com/h_64,q_95,w_48/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg", pdpResolutionsResponse._48X64);
        assertEquals("http://assets.myntassets.com/h_64,q_95,w_48/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1_mini.jpg", pdpResolutionsResponse._48X64Xmini);
        assertEquals("http://assets.myntassets.com/h_108,q_95,w_81/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg", pdpResolutionsResponse._81X108);
        assertEquals("http://assets.myntassets.com/h_108,q_95,w_81/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1_mini.jpg", pdpResolutionsResponse._81X108Xmini);
        assertEquals("http://assets.myntassets.com/h_161,q_95,w_125/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg", pdpResolutionsResponse._125X161);
        assertEquals("http://assets.myntassets.com/h_161,q_95,w_125/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1_mini.jpg", pdpResolutionsResponse._125X161Xmini);

    }

    @Test
    public void getPdpMasterCategoryResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpMasterCategoryResponse pdpMasterCategoryResponse = pdpDataResponse.masterCategory;
        assert pdpMasterCategoryResponse != null;

        assertEquals(9, pdpMasterCategoryResponse.id);
        assertEquals("Apparel", pdpMasterCategoryResponse.typeName);
        assertEquals(true, pdpMasterCategoryResponse.active);
        assertEquals(true, pdpMasterCategoryResponse.socialSharingEnabled);
        assertEquals(true, pdpMasterCategoryResponse.isReturnable);
        assertEquals(true, pdpMasterCategoryResponse.isExchangeable);
        assertEquals(true, pdpMasterCategoryResponse.isTryAndBuyEnabled);

    }

    @Test
    public void getPdpSubCategoryResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpSubCategoryResponse pdpSubCategoryResponse = pdpDataResponse.subCategory;
        assert pdpSubCategoryResponse != null;

        assertEquals(31, pdpSubCategoryResponse.id);
        assertEquals("Topwear", pdpSubCategoryResponse.typeName);
        assertEquals(true, pdpSubCategoryResponse.active);
        assertEquals(true, pdpSubCategoryResponse.socialSharingEnabled);
        assertEquals(true, pdpSubCategoryResponse.isReturnable);
        assertEquals(true, pdpSubCategoryResponse.isExchangeable);
        assertEquals(true, pdpSubCategoryResponse.isTryAndBuyEnabled);

    }

    @Test
    public void getPdpArticleTypeResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpArticleTypeResponse articleTypeResponse = pdpDataResponse.articleType;
        assert articleTypeResponse != null;

        assertEquals(89, articleTypeResponse.id);
        assertEquals("Tops", articleTypeResponse.typeName);
        assertEquals(true, articleTypeResponse.active);
        assertEquals(true, articleTypeResponse.socialSharingEnabled);
        assertEquals(true, articleTypeResponse.isReturnable);
        assertEquals(true, articleTypeResponse.isExchangeable);
        assertEquals(true, articleTypeResponse.isTryAndBuyEnabled);

        PdpServiceabilityDisclaimerResponse serviceabilityDisclaimerResponse = articleTypeResponse.serviceabilityDisclaimer;

        assertEquals("", serviceabilityDisclaimerResponse.desc);
        assertEquals("", serviceabilityDisclaimerResponse.title);

    }

    @Test
    public void getPdpOtherFlagResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        List<PdpOtherFlagResponse> pdpOtherFlagResponseList = pdpDataResponse.otherFlags;
        assertEquals(11, pdpOtherFlagResponseList.size());

        PdpOtherFlagResponse pdpOtherFlagResponse = pdpOtherFlagResponseList.get(0);
        assert pdpOtherFlagResponse != null;

        assertEquals("BOOLEAN", pdpOtherFlagResponse.dataType);
        assertEquals("isReturnable", pdpOtherFlagResponse.name);
        assertEquals("true", pdpOtherFlagResponse.value);

    }

    @Test
    public void getPdpProductDescriptorsResponseResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;
        PdpProductDescriptorsResponse pdpProductDescriptorsResponse = pdpDataResponse.productDescriptors;
        assert pdpProductDescriptorsResponse != null;

        PdpMaterialsCareDescResponse pdpMaterialsCareDescResponse = pdpProductDescriptorsResponse.materialsCareDesc;
        assert pdpMaterialsCareDescResponse != null;
        assertEquals("materials_care_desc", pdpMaterialsCareDescResponse.descriptorType);
        assertEquals("100% cotton<br>Hand-wash", pdpMaterialsCareDescResponse.value);

        PdpSizeFitDescResponse pdpSizeFitDescResponse = pdpProductDescriptorsResponse.sizeFitDesc;
        assert pdpSizeFitDescResponse != null;
        assertEquals("size_fit_desc", pdpSizeFitDescResponse.descriptorType);
        assertEquals("The model (height 5'8\" and chest 33\") is wearing a size S&nbsp;", pdpSizeFitDescResponse.value);

        PdpDescriptionResponse pdpDescriptionResponse = pdpProductDescriptorsResponse.description;
        assert pdpDescriptionResponse != null;
        assertEquals("description", pdpDescriptionResponse.descriptorType);
        assertEquals("White printed top, has a boat neck, sleeveless", pdpDescriptionResponse.value);

        PdpStyleNoteResponse pdpStyleNoteResponse = pdpProductDescriptorsResponse.styleNote;
        assert pdpStyleNoteResponse != null;
        assertEquals("style_note", pdpStyleNoteResponse.descriptorType);
        assertEquals("Step up your style quotient with this top from Jaipur Kurti. Team it&nbsp;with your favourite pair of jeans or shorts&nbsp;and wedges or flats&nbsp;when you head out on the weekend.", pdpStyleNoteResponse.value);


    }

    @Test
    public void getStyleResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;

        assert pdpDataResponse != null;

        List<PdpStyleOptionsResponse> pdpStyleOptionsResponseList = pdpDataResponse.styleOptions;
        assertEquals(4, pdpStyleOptionsResponseList.size());

        PdpStyleOptionsResponse pdpStyleOptionsResponse = pdpStyleOptionsResponseList.get(0);
        assert pdpStyleOptionsResponse != null;

        assertEquals(10749479, pdpStyleOptionsResponse.id);
        assertEquals("Size", pdpStyleOptionsResponse.name);
        assertEquals("S", pdpStyleOptionsResponse.value);
        assertEquals("S", pdpStyleOptionsResponse.unifiedSize);
        assertEquals("S", pdpStyleOptionsResponse.unifiedSizeValue);
        assertEquals("S", pdpStyleOptionsResponse.allSize);
        assertEquals(10749479, pdpStyleOptionsResponse.skuId);
        assertEquals(3, pdpStyleOptionsResponse.inventoryCount);
        assertEquals(true, pdpStyleOptionsResponse.available);
        assertEquals(true, pdpStyleOptionsResponse.active);
    }


    @Test
    public void getPdpDiscountDataResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpDiscountDataResponse pdpDiscountDataResponse = pdpDataResponse.discountData;
        assert pdpDiscountDataResponse != null;

        assertEquals(1, pdpDiscountDataResponse.discountType);
        assertEquals(972099, pdpDiscountDataResponse.discountId);
        assertEquals(0, pdpDiscountDataResponse.discountRuleId);
        assertEquals(40, pdpDiscountDataResponse.discountPercent);

    }

    @Test
    public void getPdpDiscountTextResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpDiscountDataResponse pdpDiscountDataResponse = pdpDataResponse.discountData;
        assert pdpDiscountDataResponse != null;

        PdpDiscountTextResponse pdpDiscountTextResponse = pdpDiscountDataResponse.discountText;
        assert pdpDiscountTextResponse != null;

        assertEquals("(40% OFF)", pdpDiscountTextResponse.text);
        assertEquals(false, pdpDiscountTextResponse.hasFreeItem);

    }

    @Test
    public void getPdpDiscountToolTipResponseTest() throws Exception {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getProductDetailsResponse(1291342).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpDataResponse pdpDataResponse = response.pdpDataResponse;
        assert pdpDataResponse != null;

        PdpDiscountDataResponse pdpDiscountDataResponse = pdpDataResponse.discountData;
        assert pdpDiscountDataResponse != null;

        PdpDiscountToolTipTextResponse pdpDiscountToolTipTextResponse = pdpDiscountDataResponse.discountToolTipText;
        assert pdpDiscountToolTipTextResponse != null;

        assertEquals("Buy this item and get <em>40% </em> off", pdpDiscountToolTipTextResponse.text);
        assertEquals(false, pdpDiscountToolTipTextResponse.hasFreeItem);

    }


}