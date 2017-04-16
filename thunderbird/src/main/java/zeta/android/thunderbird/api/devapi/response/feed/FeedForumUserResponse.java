package zeta.android.thunderbird.api.devapi.response.feed;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FeedForumUserResponse {

    public final String firstname;

    public final String lastname;

    public final String gender;

    public final String image;

    public final String imageType;

    public final String coverImage;

    public final String coverImageType;

    public final String publicProfileId;

    public final String uidx;

    public final int pLevel;

    public final FeedForumCountResponse counts;

    public final Object bio;

    public final String tagsMap;

    public final String name;

    public FeedForumUserResponse(String firstname,
                                 String lastname,
                                 String gender,
                                 String image,
                                 String imageType,
                                 String coverImage,
                                 String coverImageType,
                                 String publicProfileId,
                                 String uidx,
                                 int pLevel,
                                 FeedForumCountResponse counts,
                                 Object bio,
                                 String tagsMap,
                                 String name) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.image = image;
        this.imageType = imageType;
        this.coverImage = coverImage;
        this.coverImageType = coverImageType;
        this.publicProfileId = publicProfileId;
        this.uidx = uidx;
        this.pLevel = pLevel;
        this.counts = counts;
        this.bio = bio;
        this.tagsMap = tagsMap;
        this.name = name;
    }
}
