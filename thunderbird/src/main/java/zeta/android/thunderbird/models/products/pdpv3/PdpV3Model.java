package zeta.android.thunderbird.models.products.pdpv3;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.thunderbird.models.products.common.ProductArticleType;
import zeta.android.thunderbird.models.products.common.ProductBrand;
import zeta.android.thunderbird.models.products.common.ProductId;
import zeta.android.thunderbird.models.products.common.ProductMasterCategory;
import zeta.android.thunderbird.models.products.common.ProductSubCategory;
import zeta.android.thunderbird.models.products.pdpv3.cards.PdpV3Card;

@AutoValue
public abstract class PdpV3Model implements Parcelable {

    public static Builder create() {
        return new AutoValue_PdpV3Model.Builder();
    }

    public abstract ProductId getProductId();

    public abstract String getProductTitle();

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

    public abstract List<PdpV3Card> getListOfCards();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setProductId(ProductId productId);

        public abstract Builder setProductTitle(String productTitle);

        public abstract Builder setGender(@GenderType String gender);

        public abstract Builder setSubCategory(@Nullable ProductSubCategory subCategory);

        public abstract Builder setMasterCategory(@Nullable ProductMasterCategory masterCategory);

        public abstract Builder setArticleType(@Nullable ProductArticleType articleType);

        public abstract Builder setProductBrand(@Nullable ProductBrand productBrand);

        public abstract Builder setProductDescription(@Nullable String productDescription);

        public abstract Builder setListOfCards(List<PdpV3Card> cards);

        public abstract PdpV3Model build();
    }
}
