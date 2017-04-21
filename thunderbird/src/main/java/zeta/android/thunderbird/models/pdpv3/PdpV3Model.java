package zeta.android.thunderbird.models.pdpv3;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class PdpV3Model implements Parcelable {

    public static Builder create(List<PdpV3Card> cards) {
        return new AutoValue_PdpV3Model.Builder();
    }

    public abstract List<PdpV3Card> getListOfCards();

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder setListOfCards(List<PdpV3Card> cards);

        public abstract PdpV3Model build();
    }
}
