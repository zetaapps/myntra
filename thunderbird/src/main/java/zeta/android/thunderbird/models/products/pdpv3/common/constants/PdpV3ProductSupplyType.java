package zeta.android.thunderbird.models.products.pdpv3.common.constants;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({PdpV3ProductSupplyType.ON_HAND})
public @interface PdpV3ProductSupplyType {
    String ON_HAND = "ON_HAND";
}
