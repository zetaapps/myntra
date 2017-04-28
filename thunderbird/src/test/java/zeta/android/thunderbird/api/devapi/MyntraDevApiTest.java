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
import zeta.android.thunderbird.api.devapi.response.feed.FeedCardsResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedChildrenResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedForumResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedHeaderResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedResponse;
import zeta.android.thunderbird.api.devapi.response.feed.FeedSideShowResponse;
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
import static org.junit.Assert.assertTrue;

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
            public Observable<Response<FeedSideShowResponse>> getFeedSlideShowResponse() {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("feed_slide_show.json", FeedSideShowResponse.class))
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
    public void getFeedResponse() throws Exception {
        TestSubscriber<Response<FeedResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedResponse feedResponse = onNextEvents.get(0).body();
        assert feedResponse != null;
        assertEquals(13, feedResponse.count);
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
    public void getFeedSlideShowResponse() throws Exception {
        TestSubscriber<Response<FeedSideShowResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedSlideShowResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedSideShowResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedSideShowResponse feedSlideShowResponse = onNextEvents.get(0).body();
        assert feedSlideShowResponse != null;
        assertEquals(1, feedSlideShowResponse.count);
        assert feedSlideShowResponse.cards != null;
        FeedCardsResponse feedCardsResponse = feedSlideShowResponse.cards.get(0);
        assertEquals("COMPONENT_CARD", feedCardsResponse.cardType);
        assert feedCardsResponse.feedPropsResponse != null;
        assertEquals("2:ddb1fcb8-97e1-41d1-a183-1d6f872c26b3", feedCardsResponse.feedPropsResponse.id);
        assertEquals("f5e7b529-7b6d-4d53-8c6f-1e3206f00183", feedCardsResponse.feedPropsResponse.storyId);

        assert feedCardsResponse.feedContent != null;
        assertTrue(feedCardsResponse.feedContent.size() > 0);
        FeedChildrenResponse feedChildrenResponse = feedCardsResponse.feedContent.get(0);
        assertEquals("SLIDESHOW", feedChildrenResponse.feedCardType);
        assert feedChildrenResponse.feedChildProp != null;
    }

    @Test
    public void getFeedForumResponse() throws Exception {
        TestSubscriber<Response<FeedForumResponse>> testSubscriber = new TestSubscriber<>();
        myntraDevApi.getFeedForumResponse().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<FeedForumResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        FeedForumResponse feedForumResponse = onNextEvents.get(0).body();
        assertEquals(200, feedForumResponse.meta.status);
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

        PdpArticleAttributesResponse articleAttributesResponse  = pdpDataResponse.articleAttributesResponse;
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
        assertEquals(3 , pdpCrossLinksResponseList.size());

        PdpCrossLinksResponse pdpCrossLinksResponse = pdpCrossLinksResponseList.get(0);
        assert pdpCrossLinksResponse != null;

        assertEquals("More Tops by Jaipur Kurti", pdpCrossLinksResponse.key);
        assertEquals("tops?f=brand:Jaipur Kurti::gender:women" , pdpCrossLinksResponse.value);

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
        assert  pdpCoreResponse != null;

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
        assert  pdpSocialResponse != null;

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

        PdpResolutionsResponse pdpResolutionsResponse =  defaultStyleImagesResponse.resolutions;
        assert pdpResolutionsResponse != null;

        assertEquals("http://assets.myntassets.com/h_64,q_95,w_48/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg" , pdpResolutionsResponse._48X64 );
        assertEquals("http://assets.myntassets.com/h_64,q_95,w_48/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1_mini.jpg"  , pdpResolutionsResponse._48X64Xmini);
        assertEquals("http://assets.myntassets.com/h_108,q_95,w_81/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg" , pdpResolutionsResponse._81X108);
        assertEquals("http://assets.myntassets.com/h_108,q_95,w_81/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1_mini.jpg", pdpResolutionsResponse._81X108Xmini);
        assertEquals("http://assets.myntassets.com/h_161,q_95,w_125/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg", pdpResolutionsResponse._125X161);
        assertEquals("http://assets.myntassets.com/h_161,q_95,w_125/v1/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1_mini.jpg" , pdpResolutionsResponse._125X161Xmini);

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
        assert  articleTypeResponse != null;

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
        assertEquals(11 , pdpOtherFlagResponseList.size());

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
        assert  pdpDataResponse != null;
        PdpProductDescriptorsResponse pdpProductDescriptorsResponse = pdpDataResponse.productDescriptors;
        assert pdpProductDescriptorsResponse != null;

        PdpMaterialsCareDescResponse pdpMaterialsCareDescResponse = pdpProductDescriptorsResponse.materialsCareDesc;
        assert pdpMaterialsCareDescResponse != null;
        assertEquals("materials_care_desc", pdpMaterialsCareDescResponse.descriptorType);
        assertEquals("100% cotton<br>Hand-wash", pdpMaterialsCareDescResponse.value);

        PdpSizeFitDescResponse pdpSizeFitDescResponse  = pdpProductDescriptorsResponse.sizeFitDesc;
        assert pdpSizeFitDescResponse != null;
        assertEquals("size_fit_desc", pdpSizeFitDescResponse.descriptorType);
        assertEquals("The model (height 5'8\" and chest 33\") is wearing a size S&nbsp;", pdpSizeFitDescResponse.value);

        PdpDescriptionResponse pdpDescriptionResponse = pdpProductDescriptorsResponse.description;
        assert pdpDescriptionResponse != null;
        assertEquals("description", pdpDescriptionResponse.descriptorType);
        assertEquals("White printed top, has a boat neck, sleeveless", pdpDescriptionResponse.value);

        PdpStyleNoteResponse pdpStyleNoteResponse = pdpProductDescriptorsResponse.styleNote;
        assert  pdpStyleNoteResponse != null;
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
        assertEquals(4 , pdpStyleOptionsResponseList.size());

        PdpStyleOptionsResponse pdpStyleOptionsResponse = pdpStyleOptionsResponseList.get(0);
        assert pdpStyleOptionsResponse != null;

        assertEquals(10749479, pdpStyleOptionsResponse.id);
        assertEquals("Size", pdpStyleOptionsResponse.name);
        assertEquals("S", pdpStyleOptionsResponse.value);
        assertEquals("S", pdpStyleOptionsResponse.unifiedSize);
        assertEquals("S", pdpStyleOptionsResponse.unifiedSizeValue);
        assertEquals("S", pdpStyleOptionsResponse.allSize);
        assertEquals(10749479 , pdpStyleOptionsResponse.skuId);
        assertEquals(3,  pdpStyleOptionsResponse.inventoryCount);
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

        assertEquals(1 ,pdpDiscountDataResponse.discountType);
        assertEquals(972099 , pdpDiscountDataResponse.discountId);
        assertEquals(0, pdpDiscountDataResponse.discountRuleId);
        assertEquals(40 , pdpDiscountDataResponse.discountPercent);

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
        assert  pdpDataResponse != null;

        PdpDiscountDataResponse pdpDiscountDataResponse = pdpDataResponse.discountData;
        assert  pdpDiscountDataResponse != null;

        PdpDiscountTextResponse pdpDiscountTextResponse = pdpDiscountDataResponse.discountText;
        assert  pdpDiscountTextResponse != null;

        assertEquals("(40% OFF)" ,pdpDiscountTextResponse.text);
        assertEquals(false , pdpDiscountTextResponse.hasFreeItem);

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
        assert  pdpDataResponse != null;

        PdpDiscountDataResponse pdpDiscountDataResponse = pdpDataResponse.discountData;
        assert  pdpDiscountDataResponse != null;

        PdpDiscountToolTipTextResponse pdpDiscountToolTipTextResponse =pdpDiscountDataResponse.discountToolTipText;
        assert  pdpDiscountToolTipTextResponse != null;

        assertEquals("Buy this item and get <em>40% </em> off" ,pdpDiscountToolTipTextResponse.text);
        assertEquals(false , pdpDiscountToolTipTextResponse.hasFreeItem);

    }






}