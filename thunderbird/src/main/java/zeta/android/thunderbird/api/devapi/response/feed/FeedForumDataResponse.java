package zeta.android.thunderbird.api.devapi.response.feed;

import java.util.List;

public class FeedForumDataResponse {

    public final List<FeedForumContentResponse> feed;

    public FeedForumDataResponse(List<FeedForumContentResponse> feed) {
        this.feed = feed;
    }
}
