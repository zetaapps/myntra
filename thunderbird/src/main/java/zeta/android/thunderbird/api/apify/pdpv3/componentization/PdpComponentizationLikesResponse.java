package zeta.android.thunderbird.api.apify.pdpv3.componentization;

public class PdpComponentizationLikesResponse {

    public final String likeCount;

    public final String isLiked;

    public final String action;

    public PdpComponentizationLikesResponse(String likeCount,
                                            String isLiked,
                                            String action) {
        this.likeCount = likeCount;
        this.isLiked = isLiked;
        this.action = action;
    }
}
