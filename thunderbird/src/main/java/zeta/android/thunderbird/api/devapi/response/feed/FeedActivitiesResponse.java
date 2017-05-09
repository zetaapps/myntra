package zeta.android.thunderbird.api.devapi.response.feed;


import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedActivitiesResponse {

    public final FeedLikeResponse like;

    public final FeedSpamResponse spam;

    public final FeedClickResponse click;

    public FeedActivitiesResponse(FeedLikeResponse like,
                                  FeedSpamResponse spam,
                                  FeedClickResponse click) {
        this.like = like;
        this.spam = spam;
        this.click = click;
    }


}
