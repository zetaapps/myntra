package zeta.android.thunderbird.api.devapi.response.feed;

import android.support.annotation.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumPostEntriesResponse {

    public final String type;

    public final int id;

    public final String createdAt;

    public final int since;

    public final int commentCount;

    public final int answerCount;

    public final boolean isFeatured;

    public final boolean isSpammed;

    public final boolean isOwner;

    public final boolean isLiked;

    public final boolean isFollowed;

    public final boolean hasAnswered;

    public final int followersCount;

    @Nullable
    public final List<FeedForumTopicResponse> topics;

    public final boolean isAnonymous;

    @Nullable
    public final List<FeedForumDescriptionResponse> description;

    public final FeedForumParentResponse parent;

    public final FeedForumTopParentResponse topParent;

    public final int cardId;

    public final boolean isPublishedToAll;

    public final boolean isFirst;

    @Nullable
    public final List<Object> answers;

    public final FeedForumUserResponse user;

    public FeedForumPostEntriesResponse(String type, int id, String createdAt, int since,
                                        int commentCount, int answerCount, boolean isFeatured,
                                        boolean isSpammed, boolean isOwner, boolean isLiked,
                                        boolean isFollowed, boolean hasAnswered, int followersCount,
                                        @Nullable List<FeedForumTopicResponse> topics,
                                        boolean isAnonymous,
                                        @Nullable List<FeedForumDescriptionResponse> description,
                                        FeedForumParentResponse parent,
                                        FeedForumTopParentResponse topParent,
                                        int cardId, boolean isPublishedToAll,
                                        boolean isFirst,
                                        @Nullable List<Object> answers,
                                        FeedForumUserResponse user) {
        this.type = type;
        this.id = id;
        this.createdAt = createdAt;
        this.since = since;
        this.commentCount = commentCount;
        this.answerCount = answerCount;
        this.isFeatured = isFeatured;
        this.isSpammed = isSpammed;
        this.isOwner = isOwner;
        this.isLiked = isLiked;
        this.isFollowed = isFollowed;
        this.hasAnswered = hasAnswered;
        this.followersCount = followersCount;
        this.topics = topics;
        this.isAnonymous = isAnonymous;
        this.description = description;
        this.parent = parent;
        this.topParent = topParent;
        this.cardId = cardId;
        this.isPublishedToAll = isPublishedToAll;
        this.isFirst = isFirst;
        this.answers = answers;
        this.user = user;
    }
}
