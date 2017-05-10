package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedResponse {

    public final int count;

    @SerializedName("page")
    public final FeedPageResponse pageResponse;

    public final List<FeedCardsResponse> cards;

    public FeedResponse(int count, FeedPageResponse pageResponse, List<FeedCardsResponse> cards) {
        this.count = count;
        this.pageResponse = pageResponse;
        this.cards = cards;
    }
}
