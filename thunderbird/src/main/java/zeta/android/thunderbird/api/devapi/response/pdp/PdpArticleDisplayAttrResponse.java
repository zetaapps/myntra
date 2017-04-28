package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpArticleDisplayAttrResponse {

    public final int id;

    public final PdpCoreResponse core;

    public final PdpSocialResponse social;

    public final PdpExploreResponse explore;

    public PdpArticleDisplayAttrResponse(int id,
                                         PdpCoreResponse core,
                                         PdpSocialResponse social,
                                         PdpExploreResponse explore) {
        this.id = id;
        this.core = core;
        this.social = social;
        this.explore = explore;
    }
}
