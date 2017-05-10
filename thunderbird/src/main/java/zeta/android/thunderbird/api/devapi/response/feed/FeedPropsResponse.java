package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedPropsResponse {

    public final String id;

    public final String storyId;

    @SerializedName("meta")
    public final FeedMetaResponse metaResponse;

    @SerializedName("activities")
    public final FeedActivitiesResponse activitiesResponse;

    public FeedPropsResponse(String id,
                             String storyId,
                             FeedMetaResponse metaResponse,
                             FeedActivitiesResponse activitiesResponse) {
        this.id = id;
        this.storyId = storyId;
        this.metaResponse = metaResponse;
        this.activitiesResponse = activitiesResponse;
    }
}
