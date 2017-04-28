package zeta.android.thunderbird.api.devapi.response.pdp;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;



public class PdpSkuAvailabilityDetailMapResponseDeserializer implements JsonDeserializer<PdpSkuAvailabilityDetailMapResponse> {

    @Override
    public PdpSkuAvailabilityDetailMapResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new GsonBuilder().create();

        PdpSkuAvailabilityDetailMapResponse pdpSkuAvailabilityDetailMapResponse = new PdpSkuAvailabilityDetailMapResponse();
        pdpSkuAvailabilityDetailMapResponse.pdpSkuAvailabilityDetailMapObjectResponseMap = new LinkedHashMap<>();

        JsonObject jsonObject = json.getAsJsonObject();
        for (Map.Entry<String, JsonElement> element : jsonObject.entrySet()) {
            PdpSkuAvailabilityDetailMapObjectResponse pdpSkuAvailabilityDetailMapObjectResponse = gson.fromJson(element.getValue(), PdpSkuAvailabilityDetailMapObjectResponse.class);
            pdpSkuAvailabilityDetailMapResponse.pdpSkuAvailabilityDetailMapObjectResponseMap.put(element.getKey(),  pdpSkuAvailabilityDetailMapObjectResponse);
        }
        return pdpSkuAvailabilityDetailMapResponse;

    }

}
