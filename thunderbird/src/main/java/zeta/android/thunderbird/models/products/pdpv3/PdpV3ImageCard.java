package zeta.android.thunderbird.models.products.pdpv3;

import android.os.Parcel;

import zeta.android.thunderbird.models.products.pdpv3.common.PdpV3CardType;

public class PdpV3ImageCard extends PdpV3Card {

    @PdpV3CardType
    private final String mPdpV3CardType;

    public PdpV3ImageCard(@PdpV3CardType String pdpV3CardType) {
        this.mPdpV3CardType = pdpV3CardType;
    }

    @Override
    String getPdpV3CardType() {
        return mPdpV3CardType;
    }

    //region hashCode & equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PdpV3ImageCard that = (PdpV3ImageCard) o;

        return mPdpV3CardType != null ? mPdpV3CardType.equals(that.mPdpV3CardType) :
                that.mPdpV3CardType == null;

    }

    @Override
    public int hashCode() {
        return mPdpV3CardType != null ? mPdpV3CardType.hashCode() : 0;
    }
    //endregion


    //region Parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mPdpV3CardType);
    }

    @SuppressWarnings("WrongConstant")
    protected PdpV3ImageCard(Parcel in) {
        this.mPdpV3CardType = in.readString();
    }

    public static final Creator<PdpV3ImageCard> CREATOR = new Creator<PdpV3ImageCard>() {
        @Override
        public PdpV3ImageCard createFromParcel(Parcel source) {
            return new PdpV3ImageCard(source);
        }

        @Override
        public PdpV3ImageCard[] newArray(int size) {
            return new PdpV3ImageCard[size];
        }
    };

    //endregion

}
