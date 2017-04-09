package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedImagesResponse {

    public final int width;

    public final int height;

    @SerializedName("src")
    public final String imageSourceUrl;

    @SerializedName("provider")
    public final String imageSourceProvider;

    public FeedImagesResponse(int width,
                              int height,
                              String imageSourceUrl,
                              String imageSourceProvider) {
        this.width = width;
        this.height = height;
        this.imageSourceUrl = imageSourceUrl;
        this.imageSourceProvider = imageSourceProvider;
    }
}
