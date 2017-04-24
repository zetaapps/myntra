package zeta.android.thunderbird.models.products.pdpv3;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.common.GenderType;
import zeta.android.thunderbird.models.products.common.ProductBrand;
import zeta.android.thunderbird.models.products.common.ProductId;

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

    public abstract List<PdpV3Card> getListOfCards();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setProductId(ProductId productId);

        public abstract Builder setProductTitle(String productTitle);

        public abstract Builder setGender(@GenderType String gender);

        public abstract Builder setProductBrand(@Nullable ProductBrand productBrand);

        public abstract Builder setProductDescription(@Nullable String productDescription);

        public abstract Builder setListOfCards(List<PdpV3Card> cards);

        public abstract PdpV3Model build();
    }
}
