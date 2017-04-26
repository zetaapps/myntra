package zeta.android.thunderbird.models.products.pdpv3;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.LinkedHashMap;

import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.thunderbird.models.products.common.ProductArticleType;
import zeta.android.thunderbird.models.products.common.ProductBrand;
import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.thunderbird.models.products.common.ProductMasterCategory;
import zeta.android.thunderbird.models.products.common.ProductSubCategory;
import zeta.android.thunderbird.models.products.common.ProductTitle;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3BrandCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3MoreInfoCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3ProductCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3RelatedCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3ServiceabilityCard;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3SocialCard;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType;

/**
 * Product Detail Page Model - AKA - PDP component model.
 * This is the data model used to render the PDP UI.
 * <p>
 * We have cards and components concepts here.
 * <p>
 * Cards: Cards are the major UI elements
 * Components: Components are minor UI elements within the cards.
 * <p>
 * Note:
 * There is a little "gotcha's" here as we need to look out for the `getCardPositionsIndex`
 * within cards and `getComponentPositionsIndex` within component to render the cards and components
 * in certain order.
 * <p>
 * Client can choose to render the cards / components of there choice however if we would like to keep
 * the PDP componentized model controlled by "Myntra's" configurations.
 * we need to respect the index so that it can be configured by "Myntra's" servers based on some data science.
 */
@AutoValue
public abstract class PdpComponentizationModel implements Parcelable {

    public static Builder create() {
        return new AutoValue_PdpComponentizationModel.Builder();
    }

    public abstract ProductId getProductId();

    public abstract ProductTitle getProductTitle();

    @Nullable
    public abstract ProductBrand getProductBrand();

    @Nullable
    public abstract String getProductDescription();

    @GenderType
    public abstract String getGender();

    @Nullable
    public abstract ProductSubCategory getSubCategory();

    @Nullable
    public abstract ProductMasterCategory getMasterCategory();

    @Nullable
    public abstract ProductArticleType getArticleType();

    @PdpV3CardType
    public abstract LinkedHashMap<String, Integer> getCardPositionsIndex();

    public abstract PdpV3ProductCard getProductCard();

    public abstract PdpV3BrandCard getBrandCard();

    public abstract PdpV3SocialCard getSocialCard();

    public abstract PdpV3ServiceabilityCard getServiceabilityCard();

    public abstract PdpV3RelatedCard getRelatedCard();

    public abstract PdpV3MoreInfoCard getMoreInfoCard();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setProductId(ProductId productId);

        public abstract Builder setProductTitle(ProductTitle productTitle);

        public abstract Builder setGender(@GenderType String gender);

        public abstract Builder setSubCategory(@Nullable ProductSubCategory subCategory);

        public abstract Builder setMasterCategory(@Nullable ProductMasterCategory masterCategory);

        public abstract Builder setArticleType(@Nullable ProductArticleType articleType);

        public abstract Builder setProductBrand(@Nullable ProductBrand productBrand);

        public abstract Builder setProductDescription(@Nullable String productDescription);

        public abstract Builder setCardPositionsIndex(@PdpV3CardType LinkedHashMap<String, Integer> cardPositionIndex);

        public abstract Builder setProductCard(PdpV3ProductCard productCard);

        public abstract Builder setBrandCard(PdpV3BrandCard brandCard);

        public abstract Builder setSocialCard(PdpV3SocialCard socialCard);

        public abstract Builder setServiceabilityCard(PdpV3ServiceabilityCard serviceabilityCard);

        public abstract Builder setRelatedCard(PdpV3RelatedCard relatedCard);

        public abstract Builder setMoreInfoCard(PdpV3MoreInfoCard moreInfoCard);

        public abstract PdpComponentizationModel build();
    }
}
