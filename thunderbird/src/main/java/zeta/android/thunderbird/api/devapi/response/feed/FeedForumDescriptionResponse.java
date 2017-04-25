package zeta.android.thunderbird.api.devapi.response.feed;

import android.support.annotation.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumDescriptionResponse {

    public final String type;

    public final String value;

    @Nullable
    public final List<Object> images;

    @Nullable
    public final List<Object> products;

    public FeedForumDescriptionResponse(String type,
                                        String value,
                                        @Nullable List<Object> images,
                                        @Nullable List<Object> products) {
        this.type = type;
        this.value = value;
        this.images = images;
        this.products = products;
    }
}
