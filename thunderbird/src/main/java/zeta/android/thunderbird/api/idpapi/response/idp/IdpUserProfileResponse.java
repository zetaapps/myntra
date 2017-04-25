package zeta.android.thunderbird.api.idpapi.response.idp;

import com.google.gson.annotations.SerializedName;

public class IdpUserProfileResponse {

    @SerializedName("email")
    public final String email;

    @SerializedName("firstname")
    public final String firstName;

    @SerializedName("lastname")
    public final String lastName;

    @SerializedName("imageJsonEntryMap")
    public final String imageJsonEntryMap;

    @SerializedName("gender")
    public final String gender;

    @SerializedName("image")
    public final String image;

    @SerializedName("imageType")
    public final String imageType;

    @SerializedName("coverImage")
    public final String coverImage;

    @SerializedName("coverImageType")
    public final String coverImageType;

    @SerializedName("publicProfileId")
    public final String publicProfileId;

    @SerializedName("uidx")
    public final String uidx;

    @SerializedName("pLevel")
    public final String pLevel;

    @SerializedName("counts")
    public final IdpUserProfileCounts counts;

    @SerializedName("bio")
    public final String bio;

    @SerializedName("tagsMap")
    public final String tagsMap;

    @SerializedName("location")
    public final String location;

    @SerializedName("dob")
    public final String dateOfBirth;

    @SerializedName("usertype")
    public final String userType;

    @SerializedName("mobile")
    public final String mobile;

    @SerializedName("name")
    public final String name;

    public IdpUserProfileResponse(String email, String firstName, String lastName, String imageJsonEntryMap,
                                  String gender, String image, String imageType, String coverImage,
                                  String coverImageType, String publicProfileId, String uidx,
                                  String pLevel, IdpUserProfileCounts counts, String bio,
                                  String tagsMap, String location, String dateOfBirth,
                                  String userType, String mobile, String name) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageJsonEntryMap = imageJsonEntryMap;
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
        this.location = location;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
        this.mobile = mobile;
        this.name = name;
    }
}

