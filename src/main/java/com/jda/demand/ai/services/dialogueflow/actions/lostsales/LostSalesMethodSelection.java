package com.jda.demand.ai.services.dialogueflow.actions.lostsales;


import ai.api.model.AIResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.jda.demand.ai.services.dialogueflow.actions.AbstractAction;

import java.util.ArrayList;
import java.util.List;

public class LostSalesMethodSelection extends AbstractAction{

    @Override
    public AIResponse performAction() {
        AIResponse response = getAIResponse();
        List<String> types = new ArrayList<>();

        JsonArray elements = response.getResult().getParameters().get("data").getAsJsonArray();
        for(JsonElement element: elements) {
            types.add(element.getAsString());
        }

        String method = chooseMethod(types);
        response.getResult().getFulfillment().setSpeech("You should use " + method);
        return response;
    }

    private String chooseMethod(List<String> dataType) {
        String method = "";
        if(dataType.contains("pos") && dataType.contains("forecast"))  method = "Forecast Performance Metrics";
        else if(dataType.contains("pos")) method = "History Average method ";
        else if(dataType.contains("forecast data")) method = "Allocated Forecast method";
        else if(dataType.contains("slow mover")) method = "Allocated Forecast method";
        return method;
    }
}
