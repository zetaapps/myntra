package zeta.android.thunderbird.api.apify;

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
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3DescriptorResponse;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpV3SizeResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationButtonStateResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCardsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationComponentsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCrossLinksResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationDisplayDataResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationInfoResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationMediumResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationProductDetailResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationServiceabilityResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpAlbumResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3ImageResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3MediaResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3Response;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3VideoResponse;
import zeta.android.thunderbird.api.apify.pdpv3.related.common.PdpRelatedProductsProductResponse;
import zeta.android.thunderbird.api.apify.pdpv3.related.componentization.PdpRelatedProductsComponentizationComponentsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.related.componentization.PdpRelatedProductsComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.related.general.PdpRelatedProductsResponse;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

@ParametersAreNonnullByDefault
public class MyntraApifyTest extends ApiTestBase {

    private MyntraApify myntraApify;

    @Before
    public void setUpMockRetrofit() {
        super.setUpMockRetrofit();

        final BehaviorDelegate<MyntraApify> myntraDevApiBehaviorDelegate = mMockRetrofit.create(MyntraApify.class);
        myntraApify = new MyntraApify() {

            @Override
            public Observable<Response<PdpComponentizationResponse>>
            getProductDetailsComponentizedResponse(@Path("styleId") int styleId,
                                                   @Query("co") int co) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_v3_response_1675810_componentized_response.json",
                                PdpComponentizationResponse.class))
                        .getProductDetailsComponentizedResponse(styleId, co);
            }

            @Override
            public Observable<Response<PdpV3Response>> getProductDetailsResponse(
                    @Path("styleId") int styleId) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_v3_response_1675810_general.json", PdpV3Response.class))
                        .getProductDetailsResponse(styleId);
            }

            @Override
            public Observable<Response<PdpRelatedProductsComponentizationResponse>>
            getRelatedProductDetailsComponentizedResponse(@Path("styleId") int styleId,
                                                          @Query("co") int co,
                                                          @Query("colors") boolean colors) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_v3_response_1675810_componentized_related.json",
                                PdpRelatedProductsComponentizationResponse.class))
                        .getRelatedProductDetailsComponentizedResponse(styleId, co, colors);
            }

            @Override
            public Observable<Response<PdpRelatedProductsResponse>>
            getRelatedProductDetailsGeneralResponse(@Path("styleId") int styleId,
                                                    @Query("colors") boolean colors) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_v3_response_1675810_related_products_general_response.json",
                                PdpRelatedProductsResponse.class))
                        .getRelatedProductDetailsGeneralResponse(styleId, colors);
            }

        };
    }

    //region Componentized Response Tests
    @Test
    public void getProductDetailsComponentizedResponseInfoTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpComponentizationInfoResponse pdpV3Info = response.info;

        assertEquals(1675810, pdpV3Info.id);
        assertEquals("Soch Outlet Women Pink Solid Straight Kurta", pdpV3Info.name);
        assertEquals("Kurtis", pdpV3Info.articleType);
        assertEquals("Apparel", pdpV3Info.masterCategory);
        assertEquals("Women", pdpV3Info.gender);
        assertEquals("Topwear", pdpV3Info.subCategory);
    }

    @Test
    public void getProductDetailsComponentizedResponseCardsTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);

        //check for first card component
        assertEquals(false, pdpV3Card.args.collapse);
        assertEquals("PRODUCT", pdpV3Card.type);
    }

    @Test
    public void getProductDetailsComponentizedResponseImageSwipeComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(0);
        assertEquals("IMAGE_SWIPE", pdpV3Component.type);
        assertEquals("IMAGE_SWIPE", pdpV3Component.viewType);
        List<PdpComponentizationMediumResponse> pdpV3MediumList = pdpV3Component.props.mediumList;
        assertEquals(pdpV3MediumList.size(), 5);
        assertEquals("http://assets.myntassets.com/assets/images/1675810/2016/12/14/11481705566095-Soch-Women-Pink-Solid-Straight-Kurta-9641481705565846-1.jpg", pdpV3MediumList.get(0).src);
        assertEquals("image", pdpV3MediumList.get(0).type);
        assertEquals("Pink", pdpV3Component.props.baseColour);
        assertEquals(false, pdpV3Component.props.related.hasColors);
        assertEquals("/product/1675810/related?co=1&colors=false", pdpV3Component.props.related.action);
        assertEquals("ondemand", pdpV3Component.props.related.actionType);
        assertEquals("link", pdpV3Component.props.likes.action);
        assertEquals("link", pdpV3Component.props.likes.likeCount);
        assertEquals("link", pdpV3Component.props.likes.isLiked);
    }

    @Test
    public void getProductDetailsComponentizedResponseInfoComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(1);

        assertEquals(998, pdpV3Component.props.price.mrp);
        assertEquals(698, pdpV3Component.props.price.discounted);
        assertNull(pdpV3Component.props.price.discount.coupon);
        assertEquals("Buy this item and get <em>30% </em> off", pdpV3Component.props.price.discount.description);
        assertEquals("(30% OFF)", pdpV3Component.props.price.discount.label);
        assertNull(pdpV3Component.props.price.discount.myntCash);
        assertEquals("<p>Polyester <br> Dry Clean</p>", pdpV3Component.props.descriptorList.get(0).description);
        assertEquals("MATERIAL & CARE", pdpV3Component.props.descriptorList.get(0).title);
        assertEquals("+INFO", pdpV3Component.args.infoText.collapsed);
        assertEquals("-INFO", pdpV3Component.args.infoText.expanded);
    }

    @Test
    public void getProductDetailsComponentizedResponseSizeComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());

        PdpComponentizationComponentsResponse pdpV3Component;
        pdpV3Component = pdpV3ComponentsList.get(8);
        List<PdpV3SizeResponse> sizeList = pdpV3Component.props.sizeList;
        assert sizeList != null;

        List<String> warehouseList = sizeList.get(0).warehouseList;
        assertEquals(12595445, sizeList.get(0).skuId);
        assertEquals(1675810, sizeList.get(0).styleId);
        assertEquals("/product/1675810/related/XS?co=1", sizeList.get(0).action);
        assertEquals("XS", sizeList.get(0).label);
        assertEquals(true, sizeList.get(0).available);
        assertEquals("Proleague", sizeList.get(0).seller);
        assertEquals("ON_HAND", sizeList.get(0).supplyType);

        assert warehouseList != null;

        assertEquals("28", warehouseList.get(0));
        assertNull("size list is not null", sizeList.get(0).sizeType);
        assertNull("size list's price is not null", sizeList.get(0).price);
        assertNull("size list's original style is not null", sizeList.get(0).originalStyle);
    }

    @Test
    public void getProductDetailsComponentizedResponseButtonStateResponseComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());

        PdpComponentizationComponentsResponse pdpV3Component;
        pdpV3Component = pdpV3ComponentsList.get(8);
        List<PdpComponentizationButtonStateResponse> buttonList = pdpV3Component.props.buttonStateList;
        assert buttonList != null;

        assertEquals(4, buttonList.size());
        PdpComponentizationButtonStateResponse buttonStateResponse = buttonList.get(0);
        assertEquals(0, buttonStateResponse.state);

        assert buttonStateResponse.buttonList != null;

        assertEquals("collection", buttonStateResponse.buttonList.get(0).type);
        assertEquals("/wishlist", buttonStateResponse.buttonList.get(0).action);
        assertEquals("/collection", buttonStateResponse.buttonList.get(0).longAction);
    }

    @Test
    public void getProductDetailsComponentizedResponseDisplayDataComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component;
        pdpV3Component = pdpV3ComponentsList.get(8);
        List<PdpComponentizationDisplayDataResponse> displayDataList = pdpV3Component.args.displayData;
        assert displayDataList != null;
        assertEquals(4, displayDataList.size());
        PdpComponentizationDisplayDataResponse displayDataResponse = displayDataList.get(1);
        assertEquals("", displayDataResponse.buyDisableMessage);
        assertEquals("SAVED", displayDataResponse.firstButtonActionText);
        assertEquals("SAVE", displayDataResponse.firstButtonText);
        assertEquals("GO TO BAG", displayDataResponse.secondButtonActionText);
        assertEquals("ADD TO BAG", displayDataResponse.secondButtonText);
    }

    @Test
    public void getProductDetailsComponentizedResponseServicabilityComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(2);
        assert pdpV3Card.componentsList != null;
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3Card.componentsList.get(0);
        PdpComponentizationServiceabilityResponse serviceability = pdpV3Component.props.serviceability;
        List<String> warehouseList = serviceability.payload.options.warehouseList;

        assertEquals("", serviceability.payload.pincode);
        assertEquals(698, serviceability.payload.options.price);
        assertEquals(998, serviceability.payload.options.mrp);

        assert warehouseList != null;

        assertEquals("28", warehouseList.get(0));
        assertEquals(0, serviceability.payload.options.leadTime);
        assertEquals(30, serviceability.payload.options.returnPeriod);
        assertEquals(false, serviceability.payload.options.flags.isHazmat);
        assertEquals(false, serviceability.payload.options.flags.isFragile);
        assertEquals(false, serviceability.payload.options.flags.isJewellery);
        assertEquals(true, serviceability.payload.options.flags.isExchangeable);
        assertEquals(false, serviceability.payload.options.flags.isLarge);
        assertEquals(true, serviceability.payload.options.flags.isReturnable);
        assertEquals(true, serviceability.payload.options.flags.isTryable);
        assertEquals(true, serviceability.payload.options.flags.codEnabled);
        assertEquals(true, serviceability.payload.options.flags.pickupEnabled);
    }

    @Test
    public void getProductDetailsComponentizedResponseSocialComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(3);
        assert pdpV3Card.componentsList != null;
        assertEquals("SOCIAL", pdpV3Card.type);
        List<PdpComponentizationComponentsResponse> pdpComponentizationComponentsResponseList = pdpV3Card.componentsList;
        PdpComponentizationComponentsResponse pdpComponentizationComponentsResponse = pdpComponentizationComponentsResponseList.get(1);
        assertEquals("LIKERS_LAZY", pdpComponentizationComponentsResponse.type);
        assertEquals("LIKERS_LAZY", pdpComponentizationComponentsResponse.viewType);
        assertEquals("lazy", pdpComponentizationComponentsResponse.props.actionType);
        assertEquals("/product/1675810/likes/summary?co=1", pdpComponentizationComponentsResponse.props.action);
        assertEquals("Liked by", pdpComponentizationComponentsResponse.args.title);
        assertEquals("<p>This breathable and stylish kurta from Soch Outlet is a must-have item for any wardrobe.  This pink piece is a stylish option for a nice family function or event when teamed with churidar leggings and classic flats.</p>", pdpComponentizationComponentsResponseList.get(2).props.styleNote);
    }

    @Test
    public void getProductDetailsComponentizedResponseRelatedComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(4);
        assert pdpV3Card.componentsList != null;
        assertEquals("RELATED", pdpV3Card.type);
        List<PdpComponentizationComponentsResponse> pdpComponentizationComponentsResponseList = pdpV3Card.componentsList;
        PdpComponentizationComponentsResponse pdpComponentizationComponentsResponse = pdpComponentizationComponentsResponseList.get(1);
        assertEquals("CROSS_LINKS", pdpComponentizationComponentsResponse.type);
        assertEquals("CROSS_LINKS", pdpComponentizationComponentsResponse.viewType);
        List<PdpComponentizationCrossLinksResponse> crossLinksResponseList = pdpComponentizationComponentsResponse.props.crossLinksList;

        assert crossLinksResponseList != null;
        PdpComponentizationCrossLinksResponse crossLinksResponse = crossLinksResponseList.get(0);
        assertEquals("More Kurtis by Soch Outlet", crossLinksResponse.title);
        assertEquals("kurtis?f=brand:Soch Outlet::gender:women", crossLinksResponse.url);
    }

    @Test
    public void getProductDetailsComponentizedResponseVATComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(2);
        assertEquals("VAT_INFO", pdpV3Component.type);
        assertEquals("VAT_INFO", pdpV3Component.viewType);
        assertEquals("Additional VAT may apply; charged at checkout", pdpV3Component.props.vatInfo);
    }

    @Test
    public void getProductDetailsComponentizedResponseBestPriceOnDemandComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;

        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(4);

        assertEquals("BEST_PRICE_ONDEMAND", pdpV3Component.type);
        assertEquals("BEST_PRICE_ONDEMAND", pdpV3Component.viewType);
        assertEquals("/product/1675810/offers?co=1", pdpV3Component.props.bestPriceOnDemand.action);
        assertEquals("ondemand", pdpV3Component.props.bestPriceOnDemand.actionType);
    }

    @Test
    public void getProductDetailsComponentizedResponseSizeSelectorComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(5);
        assertEquals("SIZE_SELECTOR", pdpV3Component.type);
        assertEquals("SIZE_SELECTOR", pdpV3Component.viewType);
        assertEquals(false, pdpV3Component.props.sbpEnabled);
    }

    @Test
    public void getProductDetailsComponentizedResponseProductDetailComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;

        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(6);

        assertEquals("PRODUCT_DETAILS", pdpV3Component.type);
        assertEquals("PRODUCT_DETAILS", pdpV3Component.viewType);

        assert pdpV3Component.props.productDetailList != null;

        assertEquals(3, pdpV3Component.props.productDetailList.size());

        PdpComponentizationProductDetailResponse productDetailResponse = pdpV3Component.props.productDetailList.get(0);

        assertEquals("Product Details", productDetailResponse.title);
        assertNull(productDetailResponse.type);
        assertNull(productDetailResponse.content);
        assertEquals("Pink solid straight kurta, has a mandarin collar, three quarter sleeve with roll-up tab detail, straight hem", productDetailResponse.description);
    }

    @Test
    public void getProductDetailsComponentizedResponseAddButtonPDPComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;

        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(8);
        assertEquals("ADD_BUTTONS_PDP", pdpV3Component.type);
        assertEquals("ADD_BUTTONS_PDP", pdpV3Component.viewType);
        assertEquals(false, pdpV3Component.props.sbpEnabled);

        assert pdpV3Component.props.sizeList != null;
        assertEquals(7, pdpV3Component.props.sizeList.size());
    }

    @Test
    public void getProductDetailsComponentizedResponsePrimaryOfferComponentTest() {
        TestSubscriber<Response<PdpComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpComponentizationCardsResponse> pdpV3CardsList = response.cardsList;
        assertEquals(6, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(7);
        assertEquals("PRIMARY_OFFER", pdpV3Component.type);
        assertEquals("PRIMARY_OFFER", pdpV3Component.viewType);
        assertEquals("/alloffers", pdpV3Component.props.offer.action);
        assertEquals("none", pdpV3Component.args.bankOffer);
        assertEquals(24, pdpV3Component.args.maxDuration);
        assertEquals(15, pdpV3Component.args.minInterest);
        assertEquals("SPECIAL", pdpV3Component.args.primaryOffer);
    }
    //endregions

    //region General Response Tests
    @Test
    public void getProductDetailsResponseStyleTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals("Soch Outlet Women Pink Solid Straight Kurta", response.style.name);
        assertEquals(1675810, response.style.id);
    }

    @Test
    public void getProductDetailsResponsePriceTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();

        assert response != null;

        assertEquals(998, response.style.price.mrp);
        assertEquals(698, response.style.price.discounted);
        assertNull(response.style.price.discount.coupon);
        assertEquals("Buy this item and get <em>30% </em> off", response.style.price.discount.description);
        assertEquals("(30% OFF)", response.style.price.discount.label);
        assertNull(response.style.price.discount.myntCash);
    }

    @Test
    public void getProductDetailsResponseAnalyticsTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals("Kurtis", response.style.analytics.articleType);
        assertEquals("Topwear", response.style.analytics.subCategory);
        assertEquals("Apparel", response.style.analytics.masterCategory);
        assertEquals("Women", response.style.analytics.gender);
        assertEquals("Soch Outlet", response.style.analytics.brand);
    }

    @Test
    public void getProductDetailsResponseBrandTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();
        assert response != null;

        assertNull(response.style.brand.uidx);
        assertNull(response.style.brand.image);
        assertNull(response.style.brand.bio);
        assertNull(response.style.brand.social);
        assertEquals("Soch Outlet", response.style.brand.name);
    }

    @Test
    public void getProductDetailsResponseFlagsTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals(true, response.style.flags.exchangeable);
        assertEquals(true, response.style.flags.returnable);
        assertEquals(true, response.style.flags.pickupEnabled);
        assertEquals(true, response.style.flags.tryable);
        assertEquals(false, response.style.flags.large);
        assertEquals(false, response.style.flags.hazmat);
        assertEquals(false, response.style.flags.fragile);
        assertEquals(false, response.style.flags.jewellery);
        assertEquals(false, response.style.flags.outOfStock);
    }

    @Test
    public void getProductDetailsResponseDescriptorsTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpV3DescriptorResponse> descriptorResponseList = response.style.descriptorList;
        assert descriptorResponseList != null;

        assertEquals(4, descriptorResponseList.size());
        PdpV3DescriptorResponse descriptorResponse = descriptorResponseList.get(0);
        assertEquals("style_note", descriptorResponse.title);
        assertEquals("<p>This breathable and stylish kurta from Soch Outlet is a must-have item for any wardrobe.  This pink piece is a stylish option for a nice family function or event when teamed with churidar leggings and classic flats.</p>", descriptorResponse.description);
    }

    @Test
    public void getProductDetailsResponseMediaTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();
        assert response != null;

        PdpV3MediaResponse mediaResponse = response.style.media;
        List<PdpV3VideoResponse> videoResponseList = mediaResponse.pdpVideoResponseList;
        assert videoResponseList != null;

        assertEquals(1, videoResponseList.size());
        PdpV3VideoResponse videoResponse = videoResponseList.get(0);
        assertEquals("NT8fDo8EWzU", videoResponse.id);
        List<PdpAlbumResponse> albumResponseList = mediaResponse.pdpAlbumResponseList;

        assert albumResponseList != null;

        assertEquals(1, albumResponseList.size());
        PdpAlbumResponse albumResponse = albumResponseList.get(0);
        assertEquals("default", albumResponse.name);
        List<PdpV3ImageResponse> imageResponseList = albumResponse.pdpImageResponseList;

        assert imageResponseList != null;

        assertEquals(4, imageResponseList.size());
        PdpV3ImageResponse imageResponse = imageResponseList.get(0);
        assertEquals("http://assets.myntassets.com/h_($height),q_($qualityPercentage),w_($width)/v1/assets/images/1675810/2016/12/14/11481705566095-Soch-Women-Pink-Solid-Straight-Kurta-9641481705565846-1.jpg", imageResponse.src);
        assertEquals("https://assets.myntassets.com/h_($height),q_($qualityPercentage),w_($width)/v1/assets/images/1675810/2016/12/14/11481705566095-Soch-Women-Pink-Solid-Straight-Kurta-9641481705565846-1.jpg", imageResponse.secureSrc);
    }

    @Test
    public void getProductDetailsResponseSizeTest() {
        TestSubscriber<Response<PdpV3Response>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpV3Response>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpV3Response response = onNextEvents.get(0).body();
        assert response != null;

        List<PdpV3SizeResponse> sizeList = response.style.sizeList;
        assert sizeList != null;
        assertEquals(7, sizeList.size());

        PdpV3SizeResponse sizeResponse = sizeList.get(0);
        assertEquals(12595445, sizeResponse.skuId);
        assertEquals(1675810, sizeResponse.styleId);
        assertEquals(0, sizeResponse.inventory);
        assertEquals("/product/1675810/related/XS?co=1", sizeResponse.action);
        assertEquals("XS", sizeResponse.label);
        assertEquals(false, sizeResponse.available);
        assertEquals("Proleague", sizeResponse.seller);
        assertEquals("ON_HAND", sizeResponse.supplyType);
        assertNull(sizeResponse.sizeType);
        assertNull(sizeResponse.price);
        assertNull(sizeResponse.originalStyle);
    }
    //endregion

    //region PDP related Response Tests

    //region PDP related Componentized Response Test
    @Test
    public void getRelatedProductsComponentizationResponseTest() {
        TestSubscriber<Response<PdpRelatedProductsComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsComponentizedResponse(1675810, 1, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals(1, response.cardsList.size());
    }


    @Test
    public void getRelatedProductsComponentizationRelatedPdpComponentTest() {
        TestSubscriber<Response<PdpRelatedProductsComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsComponentizedResponse(1675810, 1, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsComponentizationComponentsResponse pdpV3RelatedProductsComponentizationComponentsResponse
                = response.cardsList.get(0).pdpV3ComponentizationComponentsResponseList.get(0);

        assertEquals(1, response.cardsList.get(0).pdpV3ComponentizationComponentsResponseList.size());
        assertEquals("RELATED_PDP", pdpV3RelatedProductsComponentizationComponentsResponse.type);
        assertEquals("RELATED_PDP", pdpV3RelatedProductsComponentizationComponentsResponse.viewType);
        assert pdpV3RelatedProductsComponentizationComponentsResponse.props != null;
        assert pdpV3RelatedProductsComponentizationComponentsResponse.args != null;
    }

    @Test
    public void getRelatedProductsComponentizationRelatedPdpComponentPropsTest() {
        TestSubscriber<Response<PdpRelatedProductsComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsComponentizedResponse(1675810, 1, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsComponentizationComponentsResponse pdpV3RelatedProductsComponentizationComponentsResponse
                = response.cardsList.get(0).pdpV3ComponentizationComponentsResponseList.get(0);

        assert pdpV3RelatedProductsComponentizationComponentsResponse.props != null;
        assertEquals(2,
                pdpV3RelatedProductsComponentizationComponentsResponse.props.pdpRelatedProductsRelatedPropsResponseList.size());
        assertEquals("Similar",
                pdpV3RelatedProductsComponentizationComponentsResponse.props.pdpRelatedProductsRelatedPropsResponseList.get(0).type);
        assertEquals("ColourVariants",
                pdpV3RelatedProductsComponentizationComponentsResponse.props.pdpRelatedProductsRelatedPropsResponseList.get(1).type);
    }


    @Test
    public void getRelatedProductsComponentizationRelatedPropsProductTest() {
        TestSubscriber<Response<PdpRelatedProductsComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsComponentizedResponse(1675810, 1, false).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsComponentizationComponentsResponse pdpV3RelatedProductsComponentizationComponentsResponse
                = response.cardsList.get(0).pdpV3ComponentizationComponentsResponseList.get(0);
        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                = pdpV3RelatedProductsComponentizationComponentsResponse.props.
                pdpRelatedProductsRelatedPropsResponseList.get(0).pdpRelatedProductsProductResponseList.get(0);

        assertEquals(1675813, pdpV3RelatedProductsProductResponse.id);
        assertEquals("Soch Outlet Women Teal Blue Kurta", pdpV3RelatedProductsProductResponse.name);
        assertEquals("Kurta", pdpV3RelatedProductsProductResponse.info);
        assertEquals("Teal", pdpV3RelatedProductsProductResponse.baseColour);
    }

    @Test
    public void getRelatedProductsComponentizationRelatedPropsProductPriceTest() {
        TestSubscriber<Response<PdpRelatedProductsComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsComponentizedResponse(1675810, 1, false).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsComponentizationComponentsResponse pdpV3RelatedProductsComponentizationComponentsResponse
                = response.cardsList.get(0).pdpV3ComponentizationComponentsResponseList.get(0);
        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                = pdpV3RelatedProductsComponentizationComponentsResponse.props.
                pdpRelatedProductsRelatedPropsResponseList.get(0).pdpRelatedProductsProductResponseList.get(0);

        assertEquals(998, pdpV3RelatedProductsProductResponse.price.mrp);
        assertEquals(698, pdpV3RelatedProductsProductResponse.price.discounted);
        assertEquals("(30% OFF)", pdpV3RelatedProductsProductResponse.price.discount.label);

    }

    @Test
    public void getRelatedProductsComponentizationRelatedPropsProductBrandTest() {
        TestSubscriber<Response<PdpRelatedProductsComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsComponentizedResponse(1675810, 1, false).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsComponentizationComponentsResponse pdpV3RelatedProductsComponentizationComponentsResponse
                = response.cardsList.get(0).pdpV3ComponentizationComponentsResponseList.get(0);
        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                = pdpV3RelatedProductsComponentizationComponentsResponse.props.
                pdpRelatedProductsRelatedPropsResponseList.get(0).pdpRelatedProductsProductResponseList.get(0);

        assertEquals(null, pdpV3RelatedProductsProductResponse.brand.uidx);
        assertEquals("Soch Outlet", pdpV3RelatedProductsProductResponse.brand.name);

    }

    @Test
    public void getRelatedProductsComponentizationRelatedPropsProductDefaultImageTest() {
        TestSubscriber<Response<PdpRelatedProductsComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsComponentizedResponse(1675810, 1, false).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsComponentizationComponentsResponse pdpV3RelatedProductsComponentizationComponentsResponse
                = response.cardsList.get(0).pdpV3ComponentizationComponentsResponseList.get(0);
        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                = pdpV3RelatedProductsComponentizationComponentsResponse.props.
                pdpRelatedProductsRelatedPropsResponseList.get(0).pdpRelatedProductsProductResponseList.get(0);

        assertEquals("http://assets.myntassets.com/h_($height),q_($qualityPercentage),w_" +
                        "($width)/v1/assets/images/1675813/2016/12/14/11481705229487" +
                        "-Soch-Women-Teal-Solid-Straight-Kurta-1901481705229246-1.jpg",
                pdpV3RelatedProductsProductResponse.defaultImage.src);

        assertEquals("https://assets.myntassets.com/h_($height),q_($qualityPercentage),w_" +
                        "($width)/v1/assets/images/1675813/2016/12/14/11481705229487" +
                        "-Soch-Women-Teal-Solid-Straight-Kurta-1901481705229246-1.jpg",
                pdpV3RelatedProductsProductResponse.defaultImage.secureSrc);

    }
    //endregion

    //region PDP related General Response Test
    @Test
    public void getRelatedProductsGeneralResponseTest() {
        TestSubscriber<Response<PdpRelatedProductsResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsGeneralResponse(1675810, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals(2, response.pdpRelatedProductsRelatedPropsResponseList.size());
        assertEquals("Similar", response.pdpRelatedProductsRelatedPropsResponseList.get(0).type);
        assertEquals("ColourVariants", response.pdpRelatedProductsRelatedPropsResponseList.get(1).type);
    }

    @Test
    public void getRelatedProductsGeneralRelatedPropsProductTest() {
        TestSubscriber<Response<PdpRelatedProductsResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsGeneralResponse(1675810, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                =response.pdpRelatedProductsRelatedPropsResponseList.get(0)
                .pdpRelatedProductsProductResponseList.get(0);

        assertEquals(1692328, pdpV3RelatedProductsProductResponse.id);
        assertEquals("Jashn Blue Printed Shirt-Style Kurti", pdpV3RelatedProductsProductResponse.name);
        assertEquals("Shirt-Style Kurti", pdpV3RelatedProductsProductResponse.info);
        assertEquals("Blue", pdpV3RelatedProductsProductResponse.baseColour);
    }

    @Test
    public void getRelatedProductsGeneralRelatedPropsProductPriceTest() {
        TestSubscriber<Response<PdpRelatedProductsResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsGeneralResponse(1675810, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                =response.pdpRelatedProductsRelatedPropsResponseList.get(0)
                .pdpRelatedProductsProductResponseList.get(0);


        assertEquals(1499, pdpV3RelatedProductsProductResponse.price.mrp);
        assertEquals(674, pdpV3RelatedProductsProductResponse.price.discounted);
        assertEquals("(55% OFF)", pdpV3RelatedProductsProductResponse.price.discount.label);

    }

    @Test
    public void getRelatedProductsGeneralRelatedPropsProductBrandTest() {
        TestSubscriber<Response<PdpRelatedProductsResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsGeneralResponse(1675810, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                =response.pdpRelatedProductsRelatedPropsResponseList.get(0)
                .pdpRelatedProductsProductResponseList.get(0);


        assertEquals(null, pdpV3RelatedProductsProductResponse.brand.uidx);
        assertEquals("Jashn", pdpV3RelatedProductsProductResponse.brand.name);

    }

    @Test
    public void getRelatedProductsGeneralRelatedPropsProductDefaultImageTest() {
        TestSubscriber<Response<PdpRelatedProductsResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getRelatedProductDetailsGeneralResponse(1675810, false ).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpRelatedProductsResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpRelatedProductsResponse response = onNextEvents.get(0).body();
        assert response != null;

        PdpRelatedProductsProductResponse pdpV3RelatedProductsProductResponse
                =response.pdpRelatedProductsRelatedPropsResponseList.get(0)
                .pdpRelatedProductsProductResponseList.get(0);

        assertEquals("http://assets.myntassets.com/h_($height),q_($qualityPercentage),w_" +
                        "($width)/v1/assets/images/1692328/2017/1/25/" +
                        "11485332556926-Jashn-Women-Kurtis-5241485332556579-1.jpg",
                pdpV3RelatedProductsProductResponse.defaultImage.src);

        assertEquals("https://assets.myntassets.com/h_($height),q_($qualityPercentage),w_" +
                        "($width)/v1/assets/images/1692328/2017/1/25/" +
                        "11485332556926-Jashn-Women-Kurtis-5241485332556579-1.jpg",
                pdpV3RelatedProductsProductResponse.defaultImage.secureSrc);

    }
    //endregion

    //endregion

}