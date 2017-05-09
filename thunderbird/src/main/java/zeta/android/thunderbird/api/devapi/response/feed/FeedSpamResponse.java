package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
public class FeedSpamResponse {

    public final boolean spammed;

    public FeedSpamResponse(boolean spammed) {
        this.spammed = spammed;
    }

}
