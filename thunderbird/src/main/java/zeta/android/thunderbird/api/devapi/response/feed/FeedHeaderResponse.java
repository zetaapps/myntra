package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedHeaderResponse {

    public final int count;

    @SerializedName("cards")
    public final List<FeedCardsResponse> cards;

    public FeedHeaderResponse(int count, List<FeedCardsResponse> cards) {
        this.count = count;
        this.cards = cards;
    }
}
