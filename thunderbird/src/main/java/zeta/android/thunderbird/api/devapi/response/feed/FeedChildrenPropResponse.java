package zeta.android.thunderbird.api.devapi.response.feed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedChildrenPropResponse {

    public final boolean transparency;

    @SerializedName("carousel")
    public final List<FeedCarouselResponse> carousel;

    public FeedChildrenPropResponse(boolean transparency,
                                    List<FeedCarouselResponse> carousel) {
        this.transparency = transparency;
        this.carousel = carousel;
    }
}
