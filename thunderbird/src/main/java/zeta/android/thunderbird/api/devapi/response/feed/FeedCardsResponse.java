package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedCardsResponse {

    @SerializedName("type")
    public final String cardType;

    @SerializedName("props")
    public final FeedPropsResponse feedPropsResponse;

    @SerializedName("children")
    public final List<FeedChildrenResponse> feedContent;

    public FeedCardsResponse(String cardType,
                             FeedPropsResponse feedPropsResponse,
                             List<FeedChildrenResponse> feedContent) {
        this.cardType = cardType;
        this.feedPropsResponse = feedPropsResponse;
        this.feedContent = feedContent;
    }
}
