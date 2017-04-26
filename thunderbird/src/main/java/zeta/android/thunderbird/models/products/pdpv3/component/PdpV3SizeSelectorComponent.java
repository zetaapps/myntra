package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3ActionType;
import zeta.android.thunderbird.models.products.pdpv3.common.property.PdpV3SizeProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ActionProperty;

@AutoValue
public abstract class PdpV3SizeSelectorComponent implements Parcelable {

    public static PdpV3SizeSelectorComponent.Builder create() {
        return new $AutoValue_PdpV3SizeSelectorComponent.Builder();
    }

    @Nullable
    public abstract Boolean getIsSbpEnabled();

    @Nullable
    public abstract List<PdpV3SizeProperty> getPdpV3SizePropertyList();

    @Nullable
    public abstract PdpV3ActionProperty getSizeRecomendationLazyLoad();

    @Nullable
    public abstract String getSizeChartAction();

    @Nullable
    public abstract String getOutOfStockDescription();

    @Nullable
    public abstract String getOutOfStockTitle();

    @Nullable
    public abstract String getPersonalizedDescription();

    @Nullable
    public abstract String getPersonalizedLabel();

    @Nullable
    public abstract String getPersonalizedTitle();

    @Nullable
    public abstract String getRecommendationIconInformationDescription();

    @Nullable
    public abstract String getRecommendationIconInformationText();

    @Nullable
    public abstract String getSizeChartTitleText();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setIsSbpEnabled(@Nullable Boolean sbpEnabled);

        public abstract Builder setPdpV3SizePropertyList(@Nullable List<PdpV3SizeProperty> pdpV3SizePropertyList);

        public abstract Builder setSizeRecomendationLazyLoad(@Nullable PdpV3ActionProperty sizeRecomendationLazyLoad);

        public abstract Builder setSizeChartAction(@Nullable String sizeChartAction);

        public abstract Builder setOutOfStockDescription(@Nullable String outOfStockDescription);

        public abstract Builder setOutOfStockTitle(@Nullable String outOfStockTitle);

        public abstract Builder setPersonalizedDescription(@Nullable String personalizedDescription);

        public abstract Builder setPersonalizedLabel(@Nullable String personalizedLabel);

        public abstract Builder setPersonalizedTitle(@Nullable String personalizedTitle);

        public abstract Builder setRecommendationIconInformationDescription(@Nullable String recommendationIconInformationDescription);

        public abstract Builder setRecommendationIconInformationText(@Nullable String recommendationIconInformationText);

        public abstract Builder setSizeChartTitleText(@Nullable String sizeChartTitleText);

        public abstract PdpV3SizeSelectorComponent build();
    }

}
