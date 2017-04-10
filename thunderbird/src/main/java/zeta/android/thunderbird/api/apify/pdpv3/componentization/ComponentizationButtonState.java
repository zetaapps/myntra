package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ComponentizationButtonState {
    public Integer state;
    @SerializedName("buttons")
    public List<ComponentizationButton> buttonList = null;
}
