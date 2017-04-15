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
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpSizeResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationCardsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationComponentsResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationInfoResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationMediumResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationServiceabilityResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpResponse;

import static junit.framework.Assert.assertEquals;

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
            public Observable<Response<PdpResponse>> getProductDetailsResponse(
                    @Path("styleId") int styleId) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_v3_response_1675810_general.json", PdpResponse.class))
                        .getProductDetailsResponse(styleId);
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
        assertEquals(5, pdpV3CardsList.size());

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
        assertEquals(5, pdpV3CardsList.size());

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
        assertEquals(5, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3ComponentsList.get(1);
        assertEquals(998.0, pdpV3Component.props.price.mrp);
        assertEquals(698.0, pdpV3Component.props.price.discounted);
        assertEquals(null, pdpV3Component.props.price.discount.coupon);
        assertEquals("Buy this item and get <em>30% </em> off", pdpV3Component.props.price.discount.description);
        assertEquals("(30% OFF)", pdpV3Component.props.price.discount.label);
        assertEquals(null, pdpV3Component.props.price.discount.myntCash);
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
        assertEquals(5, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(0);
        List<PdpComponentizationComponentsResponse> pdpV3ComponentsList = pdpV3Card.componentsList;
        assert pdpV3ComponentsList != null;
        assertEquals(9, pdpV3ComponentsList.size());
        PdpComponentizationComponentsResponse pdpV3Component;
        pdpV3Component = pdpV3ComponentsList.get(8);
        List<PdpSizeResponse> sizeList = pdpV3Component.props.sizeList;
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
        assertEquals(null, sizeList.get(0).sizeType);
        assertEquals(null, sizeList.get(0).price);
        assertEquals(null, sizeList.get(0).originalStyle);
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
        assertEquals(5, pdpV3CardsList.size());

        PdpComponentizationCardsResponse pdpV3Card = pdpV3CardsList.get(1);
        assert pdpV3Card.componentsList != null;
        PdpComponentizationComponentsResponse pdpV3Component = pdpV3Card.componentsList.get(0);
        PdpComponentizationServiceabilityResponse serviceability = pdpV3Component.props.serviceability;
        List<String> warehouseList = serviceability.payload.options.warehouseList;
        assertEquals("", serviceability.payload.pincode);
        assertEquals(698.0, serviceability.payload.options.price);
        assertEquals(998.0, serviceability.payload.options.mrp);
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

    //TODO add more tests for components
    //endregions

    //region General Response Tests
    @Test
    public void getProductDetailsResponseStyleTest() {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals("Soch Outlet Women Pink Solid Straight Kurta", response.style.name);
        assertEquals(1675810, response.style.id);
    }

    @Test
    public void getProductDetailsResponsePriceTest() {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals(998.0, response.style.price.mrp);
        assertEquals(698.0, response.style.price.discounted);
        assertEquals(null, response.style.price.discount.coupon);
        assertEquals("Buy this item and get <em>30% </em> off", response.style.price.discount.description);
        assertEquals("(30% OFF)", response.style.price.discount.label);
        assertEquals(null, response.style.price.discount.myntCash);
    }

    @Test
    public void getProductDetailsResponseAnalyticsTest() {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals("Kurtis", response.style.analytics.articleType);
        assertEquals("Topwear", response.style.analytics.subCategory);
        assertEquals("Apparel", response.style.analytics.masterCategory);
        assertEquals("Women", response.style.analytics.gender);
        assertEquals("Soch Outlet", response.style.analytics.brand);
    }

    @Test
    public void getProductDetailsResponseBrandTest() {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals(null, response.style.brand.uidx);
        assertEquals(null, response.style.brand.image);
        assertEquals(null, response.style.brand.bio);
        assertEquals(null, response.style.brand.social);
        assertEquals("Soch Outlet", response.style.brand.name);
    }

    //TODO add more tests for general response
    //endregion

}