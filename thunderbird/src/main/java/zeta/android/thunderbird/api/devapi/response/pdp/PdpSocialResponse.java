package zeta.android.thunderbird.api.devapi.response.pdp;


public class PdpSocialResponse {


    public String order;

    public String display;

    public String userLikes;

    public String styleNotes;

    public String crossSell;

    public PdpSocialResponse(String order,
                             String display,
                             String userLikes,
                             String styleNotes,
                             String crossSell) {
        this.order = order;
        this.display = display;
        this.userLikes = userLikes;
        this.styleNotes = styleNotes;
        this.crossSell = crossSell;
    }
}
