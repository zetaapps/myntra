package zeta.android.thunderbird.models.transformers;

import android.net.Uri;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.thunderbird.models.products.common.ProductBrand;
import zeta.android.thunderbird.models.products.pdpv3.PdpComponentizationModel;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3BestPriceOnDemandComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ButtonsComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3CompleteLookComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3CrossLinksComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ImageComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3InfoComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3LikersLazyComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3MoreInfoComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ProductDetailComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3RelatedPdpLazyComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ServicabilityComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3SizeSelectorComponent;
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3VatInfoComponent;
import zeta.android.thunderbird.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Uri.class})
@ParametersAreNonnullByDefault
public class PdpComponentizedModelTransformerTest {

    private PdpComponentizedModelTransformer mPdpModelTransformer;

    @Mock
    Uri mMockedUri;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(Uri.class);
        when(Uri.parse(anyString())).thenReturn(mMockedUri);
        mPdpModelTransformer = new PdpComponentizedModelTransformer();
    }

    //region test for info
    @Test
    public void pdpInfoTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        assertEquals(1675810, pdpResponse.getProductId().getRawId());
        assertEquals("Soch Outlet Women Pink Solid Straight Kurta", pdpResponse.getProductTitle().getRawId());
        assertEquals(GenderType.FEMALE, pdpResponse.getGender());
        ProductBrand productBrand = pdpResponse.getProductBrand();
        assert productBrand != null;
        assertEquals("Soch Outlet", productBrand.getRawId());
    }
    //endregion

    //region card tests

    //region productCard test
    @Test
    public void productCardImageSwipeComponentTest(){
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3ImageComponent pdpV3ImageComponent = pdpResponse.getProductCard().getPdpV3ImageComponent();
        assertEquals("Pink",pdpV3ImageComponent.getBaseColorProperty());
        assertEquals(mMockedUri, pdpV3ImageComponent.getImageAndVideoMediaProperty().get(0).getSource());
        assertEquals(false, pdpV3ImageComponent.getRelatedProperty().getHasColors());
        assertEquals("link", pdpV3ImageComponent.getLikeProperty().getLikeCount());
    }

    @Test
    public void productCardInfoComponentTest(){
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3InfoComponent pdpV3InfoComponent = pdpResponse.getProductCard().getPdpV3InfoComponent();
        assertEquals(1675810, pdpV3InfoComponent.getProductId().getRawId());
        assertEquals(998, pdpV3InfoComponent.getPriceProperty().getMrpPrice());
        assertEquals("(30% OFF)", pdpV3InfoComponent.getPriceProperty().getDiscountProperty().getDiscountLabel());
        assertEquals("MATERIAL & CARE", pdpV3InfoComponent.getPdpV3DescriptorsPropertyList().get(0).getTitle());
        assertEquals("+INFO", pdpV3InfoComponent.getInfoTextProperty().getCollapsedText());
    }

    @Test
    public void productCardVatInfoComponentTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3VatInfoComponent pdpV3VatInfoComponent = pdpResponse.getProductCard().getPdpV3VatInfoComponent();
        assertEquals("Additional VAT may apply; charged at checkout", pdpV3VatInfoComponent.getPdpV3VatInfo());
    }

    @Test
    public void productCardVatBestPriceOnDemandComponentTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3BestPriceOnDemandComponent pdpV3BestPriceOnDemandComponent =
                pdpResponse.getProductCard().getPdpV3BestPriceOnDemandComponent();
        assertEquals("/product/1675810/offers?co=1", pdpV3BestPriceOnDemandComponent.getAction());
        assertEquals("ondemand", pdpV3BestPriceOnDemandComponent.getActionType());
        assertEquals("Tap for best price", pdpV3BestPriceOnDemandComponent.getInitialText());
    }

    @Test
    public void productCardVatSizeSelectorComponentTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3SizeSelectorComponent pdpV3SizeSelectorComponent =
                pdpResponse.getProductCard().getPdpV3SizeSelectorComponent();
        assertEquals(12595445, pdpV3SizeSelectorComponent.getPdpV3SizePropertyList().get(0).getProductSizeVariantId().getRawId());
        assertEquals("XS", pdpV3SizeSelectorComponent.getPdpV3SizePropertyList().get(0).getSizeLabel());
        assertEquals("Proleague", pdpV3SizeSelectorComponent.getPdpV3SizePropertyList().get(0).getSellerInformation());
        assertEquals("28",  pdpV3SizeSelectorComponent.getPdpV3SizePropertyList().get(0).getPdpV3WareHouseList().get(0).getRawId());
    }

    @Test
    public void productCardButtonsComponentTest(){
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3ButtonsComponent pdpV3ButtonsComponent = pdpResponse.getProductCard().getPdpV3ButtonsComponent();
        assertEquals(false, pdpV3ButtonsComponent.getIsSbpEnabled());
        assertEquals(1, pdpV3ButtonsComponent.getPdpV3SizePropertyList().get(0).getInventoryCount().intValue());
        assertEquals("/collection", pdpV3ButtonsComponent.getPdpV3ButtonStatePropertyList().get(0)
                .getPdpV3ButtonPropertyList().get(0).getButtonLongPressAction());
        assertEquals("SAVED",pdpV3ButtonsComponent.getPdpV3DisplayDataPropertyList().get(0).getFirstButtonActionText());
    }

    //endregion

    //region brandCard test
    @Test
    public void brandCardProductDetailComponentTest(){
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3ProductDetailComponent pdpV3ProductDetailComponent = pdpResponse.getBrandCard().getPdpV3ProductDetailComponent();
        assertEquals("Pink solid straight kurta, has a mandarin collar, three quarter sleeve with roll-up tab detail, straight hem", pdpV3ProductDetailComponent.getPdpV3ProductDetailPropertyList().get(0).getPdpV3ProductDetailDescription());
    }
    //endregion

    //region servicabilityCard test
    @Test
    public void servicabilityCardServicabilityComponentTest(){
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3ServicabilityComponent pdpV3ServicabilityComponent = pdpResponse.getServiceabilityCard().getPdpV3ServicabilityComponent();
        assert pdpV3ServicabilityComponent != null;
        assertEquals("", pdpV3ServicabilityComponent.getPdpV3ServicabilityProperty().getPdpV3Pincode().getRawId());
        assertEquals(698, pdpV3ServicabilityComponent.getPdpV3ServicabilityProperty().getPdpV3ProductSellingPrice().intValue());
        assertEquals("28", pdpV3ServicabilityComponent.getPdpV3ServicabilityProperty().getPdpV3WareHouseList().get(0).getRawId());
        assertEquals(false, pdpV3ServicabilityComponent.getPdpV3ServicabilityProperty().getPdpV3ProductIsHazmat().booleanValue());
        assertEquals("Easy 30 days returns & exchange", pdpV3ServicabilityComponent.getPdpV3ServicabilityDescriptionList().get(1).getRawId());
    }
    //endregion

    //region socialCard test
    @Test
    public void socialCardLikersLazyComponentTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3LikersLazyComponent pdpV3LikersLazyComponent = pdpResponse.getSocialCard().getPdpV3LikersLazyComponent();
        assertEquals("lazy", pdpV3LikersLazyComponent.getPdpV3ActionProperty().getActionType());
        assertEquals("/product/1675810/likes/summary?co=1", pdpV3LikersLazyComponent.getPdpV3ActionProperty().getAction());
    }

    @Test
    public void socialCardCompleteLookComponentTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3CompleteLookComponent pdpV3CompleteLookComponent = pdpResponse.getSocialCard().getPdpV3CompleteLookComponent();
        assertEquals("<p>This breathable and stylish kurta from Soch Outlet is a must-have item for any wardrobe." +
                "  This pink piece is a stylish option for a nice family function or event when teamed with churidar" +
                " leggings and classic flats.</p>", pdpV3CompleteLookComponent.getPdpV3StyleNote().getRawId());
        assertEquals("COMPLETE THE LOOK", pdpV3CompleteLookComponent.getCompleteLookTitle().getRawId());
    }

    //endregion

    //region relatedCardtest

    @Test
    public void relatedCardRelatedPdpLazyComponentTest(){
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3RelatedPdpLazyComponent pdpV3RelatedPdpLazyComponent =
                pdpResponse.getRelatedCard().getPdpV3RelatedPdpLazyComponent();
        assertEquals("lazy", pdpV3RelatedPdpLazyComponent.getPdpV3ActionProperty().getActionType());
        assertEquals("/product/1675810/related?co=1&colors=false",
                pdpV3RelatedPdpLazyComponent.getPdpV3ActionProperty().getAction());
    }

    public void relatedCardCrossLinksComponentTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3CrossLinksComponent pdpV3CrossLinksComponent = pdpResponse.getRelatedCard().getPdpV3CrossLinksComponent();
        assertEquals("More Kurtis by Soch Outlet",
                pdpV3CrossLinksComponent.getPdpV3CrossLinksPropertyList().get(0).getTitle());
        assertEquals("kurtis?f=brand:Soch Outlet::gender:women",
                pdpV3CrossLinksComponent.getPdpV3CrossLinksPropertyList().get(0).getUrl());
    }

    //endregion

    //region moreInfoCard test

    @Test
    public void moreInfoCardMoreInfokComponentTest() {
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3MoreInfoComponent pdpV3MoreInfoComponent = pdpResponse.getMoreInfoCard().getPdpV3MoreInfoComponent();
        assertEquals("Product Code", pdpV3MoreInfoComponent.getPdpV3MoreInfoPropertyList().get(0).getTitle());
        assertEquals("Applicable VAT on the basis of exact location & " +
                "discount will be charged at the time of checkout",
                pdpV3MoreInfoComponent.getPdpV3MoreInfoPropertyList().get(2).getDescription());
    }

    //endregion

    //endregion

    //region transform response
    public PdpComponentizationModel getPdpComponentizationModel() {
        PdpComponentizationResponse response = TestUtils.deserialize("pdp_v3_response_1675810_componentized_response.json",
                PdpComponentizationResponse.class);
        return mPdpModelTransformer.transform(response);
    }
    //endregion
}