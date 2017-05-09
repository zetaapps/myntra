package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedLikeResponse {

    public final boolean liked;

    public FeedLikeResponse(boolean liked) {
        this.liked = liked;
    }
}
