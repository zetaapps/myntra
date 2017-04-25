package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumCountResponse {

    public final int followers;

    public FeedForumCountResponse(int followers) {
        this.followers = followers;
    }
}
