package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
public class FeedShareResponse {

    @SerializedName("og:title")
    public final String ogTitle;

    @SerializedName("og:url")
    public final String ogUrl;

    @SerializedName("og:image:url")
    public final String ogImageUrl;

    public FeedShareResponse(String ogTitle,
                             String ogUrl,
                             String ogImageUrl) {
        this.ogTitle = ogTitle;
        this.ogUrl = ogUrl;
        this.ogImageUrl = ogImageUrl;
    }
}
