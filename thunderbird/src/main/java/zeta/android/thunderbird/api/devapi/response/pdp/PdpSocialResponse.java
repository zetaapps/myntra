package zeta.android.thunderbird.api.devapi.response.pdp;

public class PdpSocialResponse {

    public final String order;

    public final String display;

    public final String userLikes;

    public final String styleNotes;

    public final String crossSell;

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
