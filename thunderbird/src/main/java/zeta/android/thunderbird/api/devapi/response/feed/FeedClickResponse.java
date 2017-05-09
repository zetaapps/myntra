package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
public class FeedClickResponse {

    public final int count;

    public FeedClickResponse(int count) {
        this.count = count;
    }
}
