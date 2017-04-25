package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumParentResponse {

    public final String type;

    public final int id;

    public FeedForumParentResponse(String type,
                                   int id) {
        this.type = type;
        this.id = id;
    }
}
