package zeta.android.thunderbird.models.transformers;

import org.junit.Before;
import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.componentization.PdpComponentizationResponse;
import zeta.android.thunderbird.models.products.pdpv3.PdpComponentizationModel;
import zeta.android.thunderbird.utils.TestUtils;

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
        //TODO :: Add more asserts here.
        //TODO:: Test unit level here.
    }

    private PdpComponentizationModel getPdpComponentizationModel() {
        PdpComponentizationResponse response = TestUtils.deserialize("pdp_v3_response_1675810_componentized_response.json",
                PdpComponentizationResponse.class);
        return mPdpModelTransformer.transform(response);
    }

}