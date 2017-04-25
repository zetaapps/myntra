package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedCarouselResponse {

    public final FeedImagesResponse image;

    @SerializedName("link")
    public final String actionLink;

    public final String id;

    public final String title;

    @SerializedName("content_type")
    public final String contentType;

    public FeedCarouselResponse(FeedImagesResponse image,
                                String actionLink,
                                String id,
                                String title,
                                String contentType) {
        this.image = image;
        this.actionLink = actionLink;
        this.id = id;
        this.title = title;
        this.contentType = contentType;
    }

}
