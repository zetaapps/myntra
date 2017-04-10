package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ComponentizationResponse {
    public final ComponentizationInfo info;
    @SerializedName("cards")
    public final List<ComponentizationCards> cardsList;

    public ComponentizationResponse(ComponentizationInfo componentizationInfo,
                                    List<ComponentizationCards> componentizationCardsList) {
        info = componentizationInfo;
        cardsList = componentizationCardsList;
    }
}
