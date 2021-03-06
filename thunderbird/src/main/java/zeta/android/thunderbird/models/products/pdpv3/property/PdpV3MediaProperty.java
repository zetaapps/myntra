package zeta.android.thunderbird.models.products.pdpv3.property;

import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.products.pdpv3.common.constants.PdpV3MediaType;

@AutoValue
public abstract class PdpV3MediaProperty implements Parcelable {

    public static Builder create(@PdpV3MediaType String mediaType) {
        return new $AutoValue_PdpV3MediaProperty.Builder()
                .setMediaType(mediaType);
    }

    @PdpV3MediaType
    public abstract String getMediaType();

    @Nullable
    public abstract Uri getSource();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setMediaType(@PdpV3MediaType String mediaType);

        public abstract Builder setSource(Uri source);

        public abstract PdpV3MediaProperty build();
    }
}
