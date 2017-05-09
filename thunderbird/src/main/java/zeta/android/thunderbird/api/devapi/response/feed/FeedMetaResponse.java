package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
public class FeedMetaResponse {

    @SerializedName("og:name")
    public final String ogName;

    @SerializedName("og:app")
    public final FeedOgAppResponse ogApp;

    @SerializedName("og:tags")
    public final List<String> ogTags = null;

    @SerializedName("og:image:url")
    public final String ogImageUrl;

    public final FeedShareResponse share;

    public final String source;

    public final String contentType;

    public final String publisherTag;

    public FeedMetaResponse(String ogName,
                            FeedOgAppResponse ogApp,
                            String ogImageUrl,
                            FeedShareResponse share,
                            String source,
                            String contentType,
                            String publisherTag) {
        this.ogName = ogName;
        this.ogApp = ogApp;
        this.ogImageUrl = ogImageUrl;
        this.share = share;
        this.source = source;
        this.contentType = contentType;
        this.publisherTag = publisherTag;
    }
}
