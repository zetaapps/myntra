package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
public class FeedPageResponse {

    public final String previous;

    public FeedPageResponse(String previous) {
        this.previous = previous;
    }
}
