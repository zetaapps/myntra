package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumTopicResponse {

    public final int topicId;

    public final String topicTitle;

    public final boolean isDeleted;

    public FeedForumTopicResponse(int topicId,
                                  String topicTitle,
                                  boolean isDeleted) {
        this.topicId = topicId;
        this.topicTitle = topicTitle;
        this.isDeleted = isDeleted;
    }
}
