package zeta.android.thunderbird.api.devapi.response.pdp;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PdpDataResponse {

    @SerializedName("id")
    public final int productId;

    @SerializedName("price")
    public final int price;

    @SerializedName("discountedPrice")
    public final int discountedPrice;

    @SerializedName("styleType")
    public final String styleType;

    @SerializedName("articleNumber")
    public final String articleNumber;

    @SerializedName("visualTag")
    public final String visualTag;

    @SerializedName("productDisplayName")
    public final String productDisplayName;

    @SerializedName("variantName")
    public final String variantName;

    @SerializedName("catalogAddDate")
    public final String catalogAddDate;

    @SerializedName("brandName")
    public final String brandName;

    @SerializedName("ageGroup")
    public final String ageGroup;

    @SerializedName("gender")
    public final String gender;

    @SerializedName("baseColour")
    public final String baseColour;

    @SerializedName("colour1")
    public final String colour1;

    @SerializedName("colour2")
    public final String colour2;

    @SerializedName("fashionType")
    public final String fashionType;

    @SerializedName("season")
    public final String season;

    @SerializedName("year")
    public final String year;

    @SerializedName("usage")
    public final String usage;

    @SerializedName("navigationId")
    public final int navigationId;

    @SerializedName("Sports")
    public final String sports;

    @SerializedName("landingPageUrl")
    public final String landingPageUrl;

    @SerializedName("articleAttributes")
    public final PdpArticleAttributesResponse articleAttributesResponse;

    @Nullable
    @SerializedName("crossLinks")
    public final List<PdpCrossLinksResponse> crossLinksResponseList;

    public final boolean codEnabled;

    @SerializedName("styleImages")
    public final PdpStyleImagesResponse styleImages;

    public final PdpLookGoodAlbumResponse lookGoodAlbum;

    public final PdpStyle360ImagesResponse style360Images;

    public final PdpMasterCategoryResponse masterCategory;

    public final PdpSubCategoryResponse subCategory;

    public final PdpArticleTypeResponse articleType;

    public final boolean isEMIEnabled;

    @Nullable
    public final List<PdpOtherFlagResponse> otherFlags;

    public final PdpArticleDisplayAttrResponse articleDisplayAttr;

    public final PdpProductDescriptorsResponse productDescriptors;

    @Nullable
    public final List<PdpStyleOptionsResponse> styleOptions;

    public final PdpDiscountDataResponse discountData;

    public PdpDataResponse(int productId, int price, int discountedPrice, String styleType,
                           String articleNumber, String visualTag, String productDisplayName,
                           String variantName, String catalogAddDate, String brandName,
                           String ageGroup, String gender, String baseColour, String colour1,
                           String colour2, String fashionType, String season, String year,
                           String usage, int navigationId, String sports, String landingPageUrl,
                           PdpArticleAttributesResponse articleAttributesResponse,
                           @Nullable List<PdpCrossLinksResponse> crossLinksResponseList,
                           boolean codEnabled, PdpStyleImagesResponse styleImages,
                           PdpLookGoodAlbumResponse lookGoodAlbum,
                           PdpStyle360ImagesResponse style360Images,
                           PdpMasterCategoryResponse masterCategory,
                           PdpSubCategoryResponse subCategory,
                           PdpArticleTypeResponse articleType,
                           boolean isEMIEnabled,
                           List<PdpOtherFlagResponse> otherFlags,
                           PdpArticleDisplayAttrResponse articleDisplayAttr,
                           PdpProductDescriptorsResponse productDescriptors,
                           @Nullable List<PdpStyleOptionsResponse> styleOptions,
                           PdpDiscountDataResponse discountData) {
        this.productId = productId;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.styleType = styleType;
        this.articleNumber = articleNumber;
        this.visualTag = visualTag;
        this.productDisplayName = productDisplayName;
        this.variantName = variantName;
        this.catalogAddDate = catalogAddDate;
        this.brandName = brandName;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.baseColour = baseColour;
        this.colour1 = colour1;
        this.colour2 = colour2;
        this.fashionType = fashionType;
        this.season = season;
        this.year = year;
        this.usage = usage;
        this.navigationId = navigationId;
        this.sports = sports;
        this.landingPageUrl = landingPageUrl;
        this.articleAttributesResponse = articleAttributesResponse;
        this.crossLinksResponseList = crossLinksResponseList;
        this.codEnabled = codEnabled;
        this.styleImages = styleImages;
        this.lookGoodAlbum = lookGoodAlbum;
        this.style360Images = style360Images;
        this.masterCategory = masterCategory;
        this.subCategory = subCategory;
        this.articleType = articleType;
        this.isEMIEnabled = isEMIEnabled;
        this.otherFlags = otherFlags;
        this.articleDisplayAttr = articleDisplayAttr;
        this.productDescriptors = productDescriptors;
        this.styleOptions = styleOptions;
        this.discountData = discountData;
    }
}
