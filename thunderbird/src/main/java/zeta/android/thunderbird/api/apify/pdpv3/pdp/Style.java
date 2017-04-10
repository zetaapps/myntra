package zeta.android.thunderbird.api.apify.pdpv3.pdp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zeta.android.thunderbird.api.apify.pdpv3.common.PdpDescriptor;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpPrice;
import zeta.android.thunderbird.api.apify.pdpv3.common.PdpSize;

public class Style {
    public Number id;
    public String name;
    public Object colours;
    public PdpPrice price;
    public Media media;
    @SerializedName("sizes")
    public List<PdpSize> sizeList = null;
    public Brand brand;
    @SerializedName("descriptors")
    public List<PdpDescriptor> descriptorList = null;
    public Flags flags;
    public Analytics analytics;
}
