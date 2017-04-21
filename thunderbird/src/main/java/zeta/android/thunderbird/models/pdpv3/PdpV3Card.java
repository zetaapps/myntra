package zeta.android.thunderbird.models.pdpv3;

import android.os.Parcelable;

import zeta.android.thunderbird.models.pdpv3.common.PdpV3CardType;

public abstract class PdpV3Card implements Parcelable {

    @PdpV3CardType
    abstract String getPdpV3CardType();

}
