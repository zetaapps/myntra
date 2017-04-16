package zeta.android.thunderbird.api.devapi.response.feed;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumContentResponse {

    public final int cardId;
    public final String cardType;
    public final int postId;
    public final int postOwnerId;
    public final boolean isHidden;
    public final boolean isDeleted;
    public final String createdOn;
    public final List<FeedForumPostEntriesResponse> postEntries;
    public final int topicId;

    public FeedForumContentResponse(int cardId,
                                    String cardType,
                                    int postId,
                                    int postOwnerId,
                                    boolean isHidden,
                                    boolean isDeleted,
                                    String createdOn,
                                    List<FeedForumPostEntriesResponse> postEntries,
                                    int topicId) {
        this.cardId = cardId;
        this.cardType = cardType;
        this.postId = postId;
        this.postOwnerId = postOwnerId;
        this.isHidden = isHidden;
        this.isDeleted = isDeleted;
        this.createdOn = createdOn;
        this.postEntries = postEntries;
        this.topicId = topicId;
    }

}
