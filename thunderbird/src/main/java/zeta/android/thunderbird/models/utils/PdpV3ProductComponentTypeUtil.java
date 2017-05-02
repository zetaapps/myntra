package zeta.android.thunderbird.models.utils;

import android.support.annotation.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ComponentType;
import zeta.android.utils.lang.StringUtils;

/**
 * Product component utility
 * In principle this util method should and must server only `product's` component type only
 * rest everything will be "unknown"
 */
@ParametersAreNonnullByDefault
public class PdpV3ProductComponentTypeUtil {

    private static final String PRODUCT_COMPONENT_IMAGE = "IMAGE_SWIPE";
    private static final String PRODUCT_COMPONENT_INFO = "INFO";
    private static final String PRODUCT_COMPONENT_VAT_INFO = "VAT_INFO";
    private static final String PRODUCT_COMPONENT_BEST_PRICE = "BEST_PRICE";
    private static final String PRODUCT_COMPONENT_SIZE_SELECTOR = "SIZE_SELECTOR";
    private static final String PRODUCT_COMPONENT_PRIMARY_OFFER = "PRIMARY_OFFER";
    private static final String PRODUCT_COMPONENT_ADD_TO_CART_BUTTON = "ADD_BUTTONS_PDP";

    @PdpV3ComponentType
    public static String from(@Nullable String identifierType) {
        if (StringUtils.isNullOrEmpty(identifierType)) {
            return PdpV3ComponentType.UNKNOWN;
        }

        switch (identifierType.toLowerCase()) {
            case PRODUCT_COMPONENT_IMAGE:
                return PdpV3ComponentType.PRODUCT_COMPONENT_IMAGE;
            case PRODUCT_COMPONENT_INFO:
                return PdpV3ComponentType.PRODUCT_COMPONENT_INFO;
            case PRODUCT_COMPONENT_VAT_INFO:
                return PdpV3ComponentType.PRODUCT_COMPONENT_VAT_INFO;
            case PRODUCT_COMPONENT_BEST_PRICE:
                return PdpV3ComponentType.PRODUCT_COMPONENT_BEST_PRICE;
            case PRODUCT_COMPONENT_SIZE_SELECTOR:
                return PdpV3ComponentType.PRODUCT_COMPONENT_SIZE_SELECTOR;
            case PRODUCT_COMPONENT_PRIMARY_OFFER:
                return PdpV3ComponentType.PRODUCT_COMPONENT_PRIMARY_OFFER;
            case PRODUCT_COMPONENT_ADD_TO_CART_BUTTON:
                return PdpV3ComponentType.PRODUCT_COMPONENT_ADD_TO_CART_BUTTON;
            default:
                return PdpV3ComponentType.UNKNOWN;
        }
    }
}
