package zeta.android.thunderbird.api.devapi.response.pdp;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PdpDataResponse {

    @SerializedName("id")
    public int productId;

    @SerializedName("price")
    public int price;

    @SerializedName("discountedPrice")
    public int discountedPrice;

    @SerializedName("styleType")
    public String styleType;

    @SerializedName("articleNumber")
    public String articleNumber;

    @SerializedName("visualTag")
    public String visualTag;

    @SerializedName("productDisplayName")
    public String productDisplayName;

    @SerializedName("variantName")
    public String variantName;

    @SerializedName("catalogAddDate")
    public String catalogAddDate;

    @SerializedName("brandName")
    public String brandName;

    @SerializedName("ageGroup")
    public String ageGroup;

    @SerializedName("gender")
    public String gender;

    @SerializedName("baseColour")
    public String baseColour;

    @SerializedName("colour1")
    public String colour1;

    @SerializedName("colour2")
    public String colour2;

    @SerializedName("fashionType")
    public String fashionType;

    @SerializedName("season")
    public String season;

    @SerializedName("year")
    public String year;

    @SerializedName("usage")
    public String usage;

    @SerializedName("navigationId")
    public int navigationId;

    @SerializedName("Sports")
    public String sports;

    @SerializedName("landingPageUrl")
    public String landingPageUrl;

    @SerializedName("articleAttributes")
    public PdpArticleAttributesResponse articleAttributesResponse;

    @SerializedName("crossLinks")
    public List<PdpCrossLinksResponse> crossLinksResponseList = null;

    public boolean codEnabled;

    @SerializedName("styleImages")
    public PdpStyleImagesResponse styleImages;

    public PdpLookGoodAlbumResponse lookGoodAlbum;

    public PdpStyle360ImagesResponse style360Images;

    public PdpMasterCategoryResponse masterCategory;

    public PdpSubCategoryResponse subCategory;

    public PdpArticleTypeResponse articleType;

    public boolean isEMIEnabled;

    public List<PdpOtherFlagResponse> otherFlags = null;

    public PdpArticleDisplayAttrResponse articleDisplayAttr;

    public PdpProductDescriptorsResponse productDescriptors;

    public List<PdpStyleOptionsResponse> styleOptions = null;

    public PdpDiscountDataResponse discountData;

}
