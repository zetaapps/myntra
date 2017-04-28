package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpExploreResponse {

    public final String display;

    public final String crosslink;

    public final String similar;

    public final String order;

    public PdpExploreResponse(String display,
                              String crosslink,
                              String similar,
                              String order) {
        this.display = display;
        this.crosslink = crosslink;
        this.similar = similar;
        this.order = order;
    }
}