package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumResponse {

    public final FeedForumDataResponse data;

    public final FeedForumMetaResponse meta;

    public FeedForumResponse(FeedForumDataResponse data,
                             FeedForumMetaResponse meta) {
        this.data = data;
        this.meta = meta;
    }
}
