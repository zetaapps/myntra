package zeta.android.thunderbird.models.pdpv3.common;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({PdpV3CardType.PRODUCT, PdpV3CardType.BRAND})
public @interface PdpV3CardType {
    String PRODUCT = "PRODUCT";
    String BRAND = "BRAND";
}
