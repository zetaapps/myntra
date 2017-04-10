package zeta.android.thunderbird.api.apify.pdpv3.componentization;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ComponentizationCards {
    public ComponentizationArgs args;
    public String type;
    @SerializedName("components")
    public List<ComponentizationComponents> componentsList = null;
}
