package zeta.android.thunderbird.models.common;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        ActionType.ON_DEMAND,
        ActionType.LAZY,
        ActionType.UNKNOWN,
})
public @interface ActionType {
    String ON_DEMAND = "ondemand";
    String LAZY = "lazy";
    String UNKNOWN = "UNKNOWN";
}
