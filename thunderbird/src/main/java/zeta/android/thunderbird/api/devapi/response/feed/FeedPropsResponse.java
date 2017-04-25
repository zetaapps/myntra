package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedPropsResponse {

    public final String id;

    public final String storyId;

    public FeedPropsResponse(String id, String storyId) {
        this.id = id;
        this.storyId = storyId;
    }
}
