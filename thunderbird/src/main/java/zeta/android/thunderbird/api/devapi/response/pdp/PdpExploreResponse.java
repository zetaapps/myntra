package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpExploreResponse {


    public String display;

    public String crosslink;

    public String similar;

    public String order;

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