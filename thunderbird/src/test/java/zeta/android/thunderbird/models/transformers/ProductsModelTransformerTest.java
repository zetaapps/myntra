package zeta.android.thunderbird.models.transformers;

import org.junit.Before;
import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.models.products.pdp.PdpModel;
import zeta.android.thunderbird.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ParametersAreNonnullByDefault
public class ProductsModelTransformerTest {

    private PdpModelTransformer mProductsModelTransformer;

    @Before
    public void setUp() throws Exception {
        mProductsModelTransformer = new PdpModelTransformer();
    }

    @Test
    public void testPdpResponse() {
        PdpModel pdpResponse = getPdpResponse();
        assert pdpResponse != null;

        assertEquals(1291342, pdpResponse.getProductId().getRawId());
        assertEquals("Jaipur Kurti Black Printed Top", pdpResponse.getProductTitle());
        assertNull(pdpResponse.getProductDescription());
        assertEquals("http://assets.myntassets.com/assets/images/1291342/2016/4/4/11459766198814-Jaipur-Kurti-White-Printed-Top-4911459766197997-1.jpg",
                pdpResponse.getDefaultImageUrl().toString());

        //TODO :: Add more asserts here.
    }

    private PdpModel getPdpResponse() {
        PdpResponse response = TestUtils.deserialize("pdp_response_1291342.json", PdpResponse.class);
        return mProductsModelTransformer.transform(response);
    }

}