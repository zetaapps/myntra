package zeta.android.thunderbird.models.transformers;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3Response;
import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3StyleResponse;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.pdpv3.PdpV3Model;

@ParametersAreNonnullByDefault
public class PdpV3ModelTransformer implements ITransformer<PdpV3Response, PdpV3Model> {

    @Override
    public PdpV3Model transform(PdpV3Response pdpV3Response) {
        PdpV3StyleResponse style = pdpV3Response.style;
        return PdpV3Model.create()
                .build();
    }
}