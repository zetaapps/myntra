package zeta.android.thunderbird.api.devapi.response.feed;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedSlideShowResponse {

    public final int count;

    public final List<FeedCardsResponse> cards;

    public FeedSlideShowResponse(int count, List<FeedCardsResponse> cards) {
        this.count = count;
        this.cards = cards;
    }
}
