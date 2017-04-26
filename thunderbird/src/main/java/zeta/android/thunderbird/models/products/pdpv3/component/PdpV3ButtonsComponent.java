package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.common.property.PdpV3SizeProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ButtonStateProperty;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3DisplayDataProperty;

@AutoValue
public abstract class PdpV3ButtonsComponent implements Parcelable {

    public static PdpV3ButtonsComponent.Builder create() {
        return new $AutoValue_PdpV3ButtonsComponent.Builder();
    }

    @Nullable
    public abstract Boolean getIsSbpEnabled();

    @Nullable
    public abstract List<PdpV3SizeProperty> getPdpV3SizePropertyList();

    @Nullable
    public abstract String getSizeChartAction();

    @Nullable
    public abstract List<PdpV3ButtonStateProperty> getPdpV3ButtonStatePropertyList();

    @Nullable
    public abstract List<PdpV3DisplayDataProperty> getPdpV3DisplayDataPropertyList();

    @Nullable
    public abstract String getSizeChartTitleText();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setIsSbpEnabled(@Nullable Boolean sbpEnabled);

        public abstract Builder setPdpV3SizePropertyList(@Nullable List<PdpV3SizeProperty> pdpV3SizePropertyList);

        public abstract Builder setSizeChartAction(@Nullable String sizeChartAction);

        public abstract Builder setPdpV3ButtonStatePropertyList(@Nullable List<PdpV3ButtonStateProperty> pdpV3ButtonStatePropertyList);

        public abstract Builder setPdpV3DisplayDataPropertyList(@Nullable List<PdpV3DisplayDataProperty> pdpV3DisplayDataPropertyList);

        public abstract Builder setSizeChartTitleText(@Nullable String sizeChartTitleText);

        public abstract PdpV3ButtonsComponent build();
    }


}
