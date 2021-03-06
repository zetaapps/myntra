package zeta.android.thunderbird.api.apify.pdpv3.pdp;

public class PdpV3BrandResponse {
    public final String uidx;
    public final String name;
    public final String image;
    public final String bio;
    public final String social;

    public PdpV3BrandResponse(String uidx,
                              String name,
                              String image,
                              String bio,
                              String social) {
        this.uidx = uidx;
        this.name = name;
        this.image = image;
        this.bio = bio;
        this.social = social;
    }
}
