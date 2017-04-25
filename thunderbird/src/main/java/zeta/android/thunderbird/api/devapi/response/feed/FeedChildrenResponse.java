package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedChildrenResponse {

    @SerializedName("type")
    public final String feedCardType;

    @SerializedName("props")
    public final FeedChildrenPropResponse feedChildProp;

    public FeedChildrenResponse(String feedCardType,
                                FeedChildrenPropResponse feedChildProp) {
        this.feedCardType = feedCardType;
        this.feedChildProp = feedChildProp;
    }
}
