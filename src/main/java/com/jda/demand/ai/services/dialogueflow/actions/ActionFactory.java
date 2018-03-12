package com.jda.demand.ai.services.dialogueflow.actions;


import ai.api.model.AIResponse;
import com.jda.demand.ai.services.dialogueflow.actions.lostsales.LostSalesMethodSelection;
import com.jda.demand.ai.services.dialogueflow.actions.weather.WeatherAction;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ActionFactory {
    private HashMap<String, Class<?>> actions = new HashMap<>();
    private final static String NO_ACTION = "";

    public ActionFactory() {
        actions.put("weather.find", WeatherAction.class);
        actions.put("lostsales.method.selection", LostSalesMethodSelection.class);
        actions.put("", NoAction.class);
    }

    public Action getAction(AIResponse response) {

        AbstractAction action = null;
        try {
            String actionCommand = response.getResult().getAction();
            action = (AbstractAction) actions.getOrDefault(actionCommand, actions.get(NO_ACTION)).newInstance();
            action.setAIResponse(response);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return action;
    }
}
