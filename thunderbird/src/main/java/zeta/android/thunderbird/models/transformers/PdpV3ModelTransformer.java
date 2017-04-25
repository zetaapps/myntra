package zeta.android.thunderbird.models.transformers;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.api.devapi.response.pdp.PdpDataResponse;
import zeta.android.thunderbird.api.devapi.response.pdp.PdpResponse;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.products.pdpv3.PdpV3Model;

@ParametersAreNonnullByDefault
public class PdpV3ModelTransformer implements ITransformer<PdpResponse, PdpV3Model> {

    @Override
    public PdpV3Model transform(PdpResponse pdpResponse) {
        PdpDataResponse pdpDataResponse = pdpResponse.pdpDataResponse;
        return PdpV3Model.create()
                .build();
    }
}