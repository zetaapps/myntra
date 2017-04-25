package zeta.android.thunderbird.models.products.pdpv3.common;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import zeta.android.thunderbird.models.common.StringId;

@AutoValue
public abstract class PdpV3SocialTitle implements Parcelable, StringId {

    public static PdpV3SocialTitle create(String pdpV3SocialTitle) {
        return new AutoValue_PdpV3SocialTitle(pdpV3SocialTitle);
    }

}
