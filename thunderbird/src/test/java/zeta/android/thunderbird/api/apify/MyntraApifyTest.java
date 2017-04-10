package zeta.android.thunderbird.api.apify;

import zeta.android.thunderbird.ApiTestBase;

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
import zeta.android.thunderbird.api.apify.pdpv3.componentization.ComponentizationCards;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.ComponentizationComponents;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.ComponentizationInfo;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.ComponentizationMedium;
import zeta.android.thunderbird.api.apify.pdpv3.componentization.ComponentizationResponse;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpResponse;

import static junit.framework.Assert.assertEquals;

@ParametersAreNonnullByDefault
public class MyntraApifyTest extends ApiTestBase {

    private MyntraApify myntraApify;

    @Before
    public void setUpMockRetrofit() {
        super.setUpMockRetrofit();

        //Mock the response form the ComponentizationResponse (co 1) json file
        final BehaviorDelegate<MyntraApify> myntraDevApiBehaviorDelegate = mMockRetrofit.create(MyntraApify.class);
        myntraApify = new MyntraApify() {

            @Override
            public Observable<Response<ComponentizationResponse>>
            getProductDetailsComponentizedResponse(@Path("styleId") int styleId,
                                                   @Query("co") int co) {
                return myntraDevApiBehaviorDelegate.returning(
                        buildResponse("pdp_v3_response_1675810_co_1_response.json",
                                ComponentizationResponse.class))
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

    @Test
    public void getProductDetailsComponentizedResponseInfoTest() {
        TestSubscriber<Response<ComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<ComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        ComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        ComponentizationInfo pdpV3Info = response.info;

        assertEquals(1675810, pdpV3Info.id.intValue());
        assertEquals("Soch Outlet Women Pink Solid Straight Kurta", pdpV3Info.name);
        assertEquals("Kurtis", pdpV3Info.articleType);
        assertEquals("Apparel", pdpV3Info.masterCategory);
        assertEquals("Women", pdpV3Info.gender);
        assertEquals("Topwear", pdpV3Info.subCategory);

    }

    @Test
    public void getProductDetailsComponentizedResponseCardsTest() {

        TestSubscriber<Response<ComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<ComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        ComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<ComponentizationCards> pdpV3CardsList = response.cardsList;
        assertEquals(5, pdpV3CardsList.size());

        ComponentizationCards pdpV3Card = pdpV3CardsList.get(0);

        //check for first card component
        assertEquals(false, pdpV3Card.args.collapse.booleanValue());
        assertEquals("PRODUCT", pdpV3Card.type);
    }

    @Test
    public void getProductDetailsComponentizedResponseImageSwipeComponentTest() {

        TestSubscriber<Response<ComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<ComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        ComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<ComponentizationCards> pdpV3CardsList = response.cardsList;
        assertEquals(5, pdpV3CardsList.size());

        ComponentizationCards pdpV3Card = pdpV3CardsList.get(0);
        List<ComponentizationComponents> pdpV3ComponentsList = pdpV3Card.componentsList;
        assertEquals(9, pdpV3ComponentsList.size());
        ComponentizationComponents pdpV3Component = pdpV3ComponentsList.get(0);
        assertEquals("IMAGE_SWIPE", pdpV3Component.type);
        assertEquals("IMAGE_SWIPE", pdpV3Component.viewType);
        List<ComponentizationMedium> pdpV3MediumList = pdpV3Component.props.mediumList;
        assertEquals(pdpV3MediumList.size(), 5);
        assertEquals("http://assets.myntassets.com/assets/images/1675810/2016/12/14/11481705566095-Soch-Women-Pink-Solid-Straight-Kurta-9641481705565846-1.jpg", pdpV3MediumList.get(0).src);
        assertEquals("image", pdpV3MediumList.get(0).type);
        assertEquals("Pink", pdpV3Component.props.baseColour);
        assertEquals(false, pdpV3Component.props.related.hasColors.booleanValue());
        assertEquals("/product/1675810/related?co=1&colors=false", pdpV3Component.props.related.action);
        assertEquals("ondemand", pdpV3Component.props.related.actionType);
        assertEquals("link", pdpV3Component.props.likes.action);
        assertEquals("link", pdpV3Component.props.likes.likeCount);
        assertEquals("link", pdpV3Component.props.likes.isLiked);
    }


    @Test
    public void getProductDetailsComponentizedResponseInfoComponentTest() {

        TestSubscriber<Response<ComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<ComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        ComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<ComponentizationCards> pdpV3CardsList = response.cardsList;
        assertEquals(5, pdpV3CardsList.size());

        ComponentizationCards pdpV3Card = pdpV3CardsList.get(0);
        List<ComponentizationComponents> pdpV3ComponentsList = pdpV3Card.componentsList;
        assertEquals(9, pdpV3ComponentsList.size());
        ComponentizationComponents pdpV3Component = pdpV3ComponentsList.get(1);
        assertEquals(998.0, pdpV3Component.props.price.mrp.doubleValue());
        assertEquals(698.0, pdpV3Component.props.price.discounted.doubleValue());
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

        TestSubscriber<Response<ComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<ComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        ComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<ComponentizationCards> pdpV3CardsList = response.cardsList;
        assertEquals(5, pdpV3CardsList.size());

        ComponentizationCards pdpV3Card = pdpV3CardsList.get(0);
        List<ComponentizationComponents> pdpV3ComponentsList = pdpV3Card.componentsList;
        assertEquals(9, pdpV3ComponentsList.size());
        ComponentizationComponents pdpV3Component = pdpV3ComponentsList.get(8);
        pdpV3Component = pdpV3ComponentsList.get(8);
        assertEquals(12595445, pdpV3Component.props.sizeList.get(0).skuId.intValue());
        assertEquals(1675810, pdpV3Component.props.sizeList.get(0).styleId.intValue());
        assertEquals("/product/1675810/related/XS?co=1", pdpV3Component.props.sizeList.get(0).action);
        assertEquals("XS", pdpV3Component.props.sizeList.get(0).label);
        assertEquals(true, pdpV3Component.props.sizeList.get(0).available.booleanValue());
        assertEquals("Proleague", pdpV3Component.props.sizeList.get(0).seller);
        assertEquals("ON_HAND", pdpV3Component.props.sizeList.get(0).supplyType);
        assertEquals("28", pdpV3Component.props.sizeList.get(0).warehouseList.get(0));
        assertEquals(null, pdpV3Component.props.sizeList.get(0).sizeType);
        assertEquals(null, pdpV3Component.props.sizeList.get(0).price);
        assertEquals(null, pdpV3Component.props.sizeList.get(0).originalStyle);

    }


    @Test
    public void getProductDetailsComponentizedResponseServicabilityComponentTest() {

        TestSubscriber<Response<ComponentizationResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsComponentizedResponse(1675810, 1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<ComponentizationResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        ComponentizationResponse response = onNextEvents.get(0).body();
        assert response != null;

        List<ComponentizationCards> pdpV3CardsList = response.cardsList;
        assertEquals(5, pdpV3CardsList.size());

        ComponentizationCards pdpV3Card = pdpV3CardsList.get(1);
        ComponentizationComponents pdpV3Component = pdpV3Card.componentsList.get(0);
        assertEquals("", pdpV3Component.props.serviceability.payload.pincode);
        assertEquals(698.0, pdpV3Component.props.serviceability.payload.options.price.doubleValue());
        assertEquals(998.0, pdpV3Component.props.serviceability.payload.options.mrp.doubleValue());
        assertEquals("28", pdpV3Component.props.serviceability.payload.options.warehouseList.get(0));
        assertEquals(0, pdpV3Component.props.serviceability.payload.options.leadTime.intValue());
        assertEquals(30, pdpV3Component.props.serviceability.payload.options.returnPeriod.intValue());
        assertEquals(false, pdpV3Component.props.serviceability.payload.options.flags.isHazmat.booleanValue());
        assertEquals(false, pdpV3Component.props.serviceability.payload.options.flags.isFragile.booleanValue());
        assertEquals(false, pdpV3Component.props.serviceability.payload.options.flags.isJewellery.booleanValue());
        assertEquals(true, pdpV3Component.props.serviceability.payload.options.flags.isExchangeable.booleanValue());
        assertEquals(false, pdpV3Component.props.serviceability.payload.options.flags.isLarge.booleanValue());
        assertEquals(true, pdpV3Component.props.serviceability.payload.options.flags.isReturnable.booleanValue());
        assertEquals(true, pdpV3Component.props.serviceability.payload.options.flags.isTryable.booleanValue());
        assertEquals(true, pdpV3Component.props.serviceability.payload.options.flags.codEnabled.booleanValue());
        assertEquals(true, pdpV3Component.props.serviceability.payload.options.flags.pickupEnabled.booleanValue());

    }

    //TODO add mopre asserts for components

    @Test
    public void getProductDetailsResponseStyleTest() {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals("Soch Outlet Women Pink Solid Straight Kurta", response.style.name);
        assertEquals(1675810, response.style.id.intValue());

    }

    @Test
    public void getProductDetailsResponsePriceTest() {
        TestSubscriber<Response<PdpResponse>> testSubscriber = new TestSubscriber<>();
        myntraApify.getProductDetailsResponse(1675810).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Response<PdpResponse>> onNextEvents = testSubscriber.getOnNextEvents();
        PdpResponse response = onNextEvents.get(0).body();
        assert response != null;

        assertEquals(998.0, response.style.price.mrp.doubleValue());
        assertEquals(698.0, response.style.price.discounted.doubleValue());
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




    //TODO add mopre asserts for general response

}