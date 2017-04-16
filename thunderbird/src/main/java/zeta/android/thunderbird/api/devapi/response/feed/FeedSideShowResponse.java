package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedSideShowResponse {

    public final int count;

    public final FeedCardsResponse cards;

    public FeedSideShowResponse(int count, FeedCardsResponse cards) {
        this.count = count;
        this.cards = cards;
    }
}
