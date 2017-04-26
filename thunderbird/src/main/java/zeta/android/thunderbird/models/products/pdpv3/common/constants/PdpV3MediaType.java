package zeta.android.thunderbird.models.products.pdpv3.common.constants;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        PdpV3MediaType.IMAGE,
        PdpV3MediaType.VIDEO,
        PdpV3MediaType.UNKNOWN
})
public @interface PdpV3MediaType {
    String IMAGE = "image";
    String VIDEO = "video";
    String UNKNOWN = "unknown";
}
