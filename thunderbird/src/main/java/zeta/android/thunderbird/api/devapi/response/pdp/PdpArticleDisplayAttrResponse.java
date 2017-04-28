package zeta.android.thunderbird.api.devapi.response.pdp;


public class PdpArticleDisplayAttrResponse {

    public int id;

    public PdpCoreResponse core;

    public PdpSocialResponse social;

    public PdpExploreResponse explore;

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
