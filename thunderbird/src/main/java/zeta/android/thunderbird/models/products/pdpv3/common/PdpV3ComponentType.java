package zeta.android.thunderbird.models.products.pdpv3.common;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        PdpV3ComponentType.IMAGE_SWIPE,
        PdpV3ComponentType.PRODUCT_DETAILS,
        PdpV3ComponentType.SERVICEABILITY
})
public @interface PdpV3ComponentType {

    String IMAGE_SWIPE = "IMAGE_SWIPE";

    String INFO = "INFO";
    String VAT_INFO = "VAT_INFO";
    String BEST_PRICE = "BEST_PRICE";
    String SIZE_SELECTOR = "SIZE_SELECTOR";
    String PRIMARY_OFFER = "PRIMARY_OFFER";

    String ADD_BUTTONS_PDP = "ADD_BUTTONS_PDP";

    String PRODUCT_DETAILS = "PRODUCT_DETAILS";
    String SERVICEABILITY = "SERVICEABILITY";

    String LIKERS = "LIKERS";
    String COMPLETE_LOOK = "COMPLETE_LOOK";
    String RELATED_PDP = "RELATED_PDP";
    String CROSS_LINKS = "CROSS_LINKS";
    String MORE_INFO = "MORE_INFO";

    String BEST_PRICE_LAZY = "BEST_PRICE_LAZY ";
    String LIKERS_LAZY = "LIKERS_LAZY";
    String COMPLETE_LOOK_LAZY = "COMPLETE_LOOK_LAZY";
    String RELATED_PDP_LAZY = "RELATED_PDP_LAZY";
    String CROSS_LINKS_LAZY = "CROSS_LINKS_LAZY";
    String MORE_INFO_LAZY = "MORE_INFO_LAZY";

    String BEST_PRICE_ONDEMAND = "BEST_PRICE_ONDEMAND";
    String LIKERS_ON_DEMAND = "LIKERS_ONDEMAND";
    String COMPLETE_LOOK_ON_DEMAND = "COMPLETE_LOOK_ONDEMAND";
    String RELATED_PDP_ON_DEMAND = "RELATED_PDP_ONDEMAND";
    String CROSS_LINKS_ON_DEMAND = "CROSS_LINKS_ONDEMAND";
    String MORE_INFO_ON_DEMAND = "MORE_INFO_ONDEMAND";

    String UNKNOWN = "UNKNOWN";
}
