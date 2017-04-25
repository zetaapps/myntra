package zeta.android.thunderbird.models.transformers;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.apify.pdpv3.pdp.PdpV3Response;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.pdp.PdpModel;

@ParametersAreNonnullByDefault
public class PdpV3ModelTransformer implements ITransformer<PdpV3Response, PdpModel> {

    @Override
    public PdpModel transform(PdpV3Response response) {
        return PdpModel.create()
                .build();
    }

}