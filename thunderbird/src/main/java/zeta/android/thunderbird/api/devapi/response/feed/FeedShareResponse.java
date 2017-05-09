package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
public class FeedShareResponse {

    @SerializedName("og:title")
    public String ogTitle;

    @SerializedName("og:url")
    public String ogUrl;

    @SerializedName("og:image:url")
    public String ogImageUrl;

    public FeedShareResponse(String ogTitle,
                             String ogUrl,
                             String ogImageUrl) {
        this.ogTitle = ogTitle;
        this.ogUrl = ogUrl;
        this.ogImageUrl = ogImageUrl;
    }
}
