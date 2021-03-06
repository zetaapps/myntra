package zeta.android.thunderbird.models.products.pdpv3.common.constants;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        PdpV3ComponentType.PRODUCT_COMPONENT_IMAGE,
        PdpV3ComponentType.PRODUCT_COMPONENT_INFO,
        PdpV3ComponentType.PRODUCT_COMPONENT_VAT_INFO,
        PdpV3ComponentType.PRODUCT_COMPONENT_BEST_PRICE_ONDEMAND,
        PdpV3ComponentType.PRODUCT_COMPONENT_SIZE_SELECTOR,
        PdpV3ComponentType.PRODUCT_COMPONENT_PRIMARY_OFFER,
        PdpV3ComponentType.PRODUCT_COMPONENT_ADD_TO_CART_BUTTON,

        PdpV3ComponentType.BRAND_COMPONENT_PRODUCT_DETAILS,

        PdpV3ComponentType.SERVICEABILITY_COMPONENT_SERVICEABILITY,

        PdpV3ComponentType.SOCIAL_COMPONENT_LIKERS_LAZY,
        PdpV3ComponentType.SOCIAL_COMPONENT_COMPLETE_LOOK,

        PdpV3ComponentType.RELATED_COMPONENT_RELATED_PDP_LAZY,
        PdpV3ComponentType.RELATED_COPONENT_CROSS_LINKS,

        PdpV3ComponentType.MORE_INFO_COMPONENT_MORE_INFO,

        PdpV3ComponentType.UNKNOWN,
})
public @interface PdpV3ComponentType {

    String PRODUCT_COMPONENT_IMAGE = "IMAGE_SWIPE";
    String PRODUCT_COMPONENT_INFO = "INFO";
    String PRODUCT_COMPONENT_VAT_INFO = "VAT_INFO";
    String PRODUCT_COMPONENT_BEST_PRICE_ONDEMAND = "BEST_PRICE_ONDEMAND";
    String PRODUCT_COMPONENT_SIZE_SELECTOR = "SIZE_SELECTOR";
    String PRODUCT_COMPONENT_PRIMARY_OFFER = "PRIMARY_OFFER";
    String PRODUCT_COMPONENT_ADD_TO_CART_BUTTON = "ADD_BUTTONS_PDP";

    String BRAND_COMPONENT_PRODUCT_DETAILS = "PRODUCT_DETAILS";

    String SERVICEABILITY_COMPONENT_SERVICEABILITY = "SERVICEABILITY";

    String SOCIAL_COMPONENT_LIKERS_LAZY = "LIKERS_LAZY";
    String SOCIAL_COMPONENT_COMPLETE_LOOK = "COMPLETE_LOOK";

    String RELATED_COMPONENT_RELATED_PDP_LAZY = "RELATED_PDP_LAZY";
    String RELATED_COPONENT_CROSS_LINKS = "CROSS_LINKS";

    String MORE_INFO_COMPONENT_MORE_INFO = "MORE_INFO";

    String UNKNOWN = "UNKNOWN";

    String LIKERS = "LIKERS";

    String RELATED_PDP = "RELATED_PDP";

    String BEST_PRICE_LAZY = "BEST_PRICE_LAZY ";

    String COMPLETE_LOOK_LAZY = "COMPLETE_LOOK_LAZY";

    String CROSS_LINKS_LAZY = "CROSS_LINKS_LAZY";
    String MORE_INFO_LAZY = "MORE_INFO_LAZY";

    String LIKERS_ON_DEMAND = "LIKERS_ONDEMAND";
    String COMPLETE_LOOK_ON_DEMAND = "COMPLETE_LOOK_ONDEMAND";
    String RELATED_PDP_ON_DEMAND = "RELATED_PDP_ONDEMAND";
    String CROSS_LINKS_ON_DEMAND = "CROSS_LINKS_ONDEMAND";
    String MORE_INFO_ON_DEMAND = "MORE_INFO_ONDEMAND";

}
