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
import zeta.android.thunderbird.models.products.pdpv3.component.PdpV3ImageComponent;
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

        mPdpModelTransformer = new PdpComponentizedModelTransformer();

    }

    @Test
    public void testPdpResponse() {
        PowerMockito.mockStatic(Uri.class);
        when(Uri.parse(anyString())).thenReturn(mMockedUri);
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        assertEquals(1675810, pdpResponse.getProductId().getRawId());
        assertEquals("Soch Outlet Women Pink Solid Straight Kurta", pdpResponse.getProductTitle().getRawId());
        assertEquals(GenderType.FEMALE, pdpResponse.getGender());
        ProductBrand productBrand = pdpResponse.getProductBrand();
        assert productBrand != null;
        assertEquals("Soch Outlet", productBrand.getRawId());
        //TODO::  Add more top level test
    }

    @Test
    public void productCardImageSwipeComponentTest(){
        PowerMockito.mockStatic(Uri.class);
        when(Uri.parse(anyString())).thenReturn(mMockedUri);
        PdpComponentizationModel pdpResponse = getPdpComponentizationModel();
        assert pdpResponse != null;
        PdpV3ImageComponent pdpV3ImageComponent = pdpResponse.getProductCard().getPdpV3ImageComponent();
        assertEquals("Pink",pdpV3ImageComponent.getBaseColorProperty());
    }

    private PdpComponentizationModel getPdpComponentizationModel() {
        PdpComponentizationResponse response = TestUtils.deserialize("pdp_v3_response_1675810_componentized_response.json",
                PdpComponentizationResponse.class);
        return mPdpModelTransformer.transform(response);
    }
}