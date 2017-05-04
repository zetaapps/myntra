package zeta.android.thunderbird.models.products.pdpv3.common.constants;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({PdpV3ActionType.ON_DEMAND,
            PdpV3ActionType.LAZY,
            PdpV3ActionType.LAZY_LOADED,
            PdpV3ActionType.UNKNOWN})
public @interface PdpV3ActionType {
    String ON_DEMAND = "ondemand";
    String LAZY = "lazy";
    String LAZY_LOADED = "lazyloaded";
    String UNKNOWN = "unknown";
}

