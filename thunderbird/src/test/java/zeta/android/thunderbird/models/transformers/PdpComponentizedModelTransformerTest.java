package zeta.android.thunderbird.models.transformers;

import org.junit.Before;
import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.thunderbird.models.products.common.ProductBrand;
import zeta.android.thunderbird.models.products.pdpv3.PdpComponentizationModel;
import zeta.android.thunderbird.utils.TestUtils;

import static org.junit.Assert.assertEquals;

@ParametersAreNonnullByDefault
public class PdpComponentizedModelTransformerTest {

    private PdpComponentizedModelTransformer mPdpModelTransformer;

    @Before
    public void setUp() throws Exception {
        mPdpModelTransformer = new PdpComponentizedModelTransformer();
    }

    @Test
    public void testPdpResponse() {
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

    private PdpComponentizationModel getPdpComponentizationModel() {
        PdpComponentizationResponse response = TestUtils.deserialize("pdp_v3_response_1675810_componentized_response.json",
                PdpComponentizationResponse.class);
        return mPdpModelTransformer.transform(response);
    }
}