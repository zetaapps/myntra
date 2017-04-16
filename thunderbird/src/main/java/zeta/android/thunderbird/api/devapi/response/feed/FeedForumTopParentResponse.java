package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumTopParentResponse {

    public final String type;

    public final int id;

    public FeedForumTopParentResponse(String type,
                                      int id) {
        this.type = type;
        this.id = id;
    }
}
