package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedResponse {

    public final int count;

    public final FeedCardsResponse cards;

    public FeedResponse(int count, FeedCardsResponse cards) {
        this.count = count;
        this.cards = cards;
    }
}
