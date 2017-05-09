package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedSlidesResponse {

    public final int width;

    public final int height;

    public final String src;

    public final String provider;

    public final String alt;

    public final String id;

    public final String contentType;

    public final String link;

    public FeedSlidesResponse(int width,
                             int height,
                             String src,
                             String provider,
                             String alt,
                             String id,
                             String contentType,
                             String link) {
        this.width = width;
        this.height = height;
        this.src = src;
        this.provider = provider;
        this.alt = alt;
        this.id = id;
        this.contentType = contentType;
        this.link = link;
    }
}
