package zeta.android.thunderbird.api.devapi.response.pdp;

import com.google.gson.annotations.SerializedName;


public class PdpProductDescriptorsResponse {


    @SerializedName("materials_care_desc")
    public PdpMaterialsCareDescResponse materialsCareDesc;

    @SerializedName("size_fit_desc")
    public PdpSizeFitDescResponse sizeFitDesc;

    @SerializedName("description")
    public PdpDescriptionResponse description;

    @SerializedName("style_note")
    public PdpStyleNoteResponse styleNote;

    public PdpProductDescriptorsResponse(PdpMaterialsCareDescResponse materialsCareDesc,
                                         PdpSizeFitDescResponse sizeFitDesc,
                                         PdpDescriptionResponse description,
                                         PdpStyleNoteResponse styleNote) {
        this.materialsCareDesc = materialsCareDesc;
        this.sizeFitDesc = sizeFitDesc;
        this.description = description;
        this.styleNote = styleNote;
    }
}
