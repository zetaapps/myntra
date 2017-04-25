package zeta.android.thunderbird.models.products.pdpv3.component;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3ServicabilityPlaceHolder;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3ServicabilityDescription;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3ServicabilityTitle;
import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3SocialTitle;
import zeta.android.thunderbird.models.products.pdpv3.property.PdpV3ServicabilityProperty;

@AutoValue
public abstract class PdpV3ServicabilityComponent implements Parcelable {

    public static PdpV3ServicabilityComponent.Builder create(PdpV3ServicabilityProperty pdpV3ServicabilityProperty) {
        return new $AutoValue_PdpV3ServicabilityComponent.Builder()
                .setPdpV3ServicabilityProperty(pdpV3ServicabilityProperty);
    }

    public abstract PdpV3ServicabilityProperty getPdpV3ServicabilityProperty();

    @Nullable
    public abstract List<PdpV3ServicabilityDescription> getPdpV3ServicabilityDescriptionList();

    @Nullable
    public abstract PdpV3ServicabilityPlaceHolder getPdpV3ServicabilityPlaceHolder();

    @Nullable
    public abstract PdpV3ServicabilityTitle getPdpV3ServicabilityTitle();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setPdpV3ServicabilityProperty(PdpV3ServicabilityProperty pdpV3ServicabilityProperty);

        public abstract Builder setPdpV3ServicabilityDescriptionList(@Nullable List<PdpV3ServicabilityDescription> pdpV3ServicabilityDescriptionList);

        public abstract Builder setPdpV3ServicabilityPlaceHolder(@Nullable PdpV3ServicabilityPlaceHolder pdpV3ServicabilityPlaceHolder);

        public abstract Builder setPdpV3ServicabilityTitle(@Nullable PdpV3ServicabilityTitle pdpV3ServicabilityTitle);

        public abstract PdpV3ServicabilityComponent build();
    }

}
