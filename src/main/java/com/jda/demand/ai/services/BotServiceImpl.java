package com.jda.demand.ai.services;


import com.jda.demand.ai.services.dialogueflow.DialogueFlow;
import com.jda.demand.ai.services.neural.NeuralNetworkBot;
import com.jda.demand.ai.model.BotResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class BotServiceImpl implements Bot {
    private static final Logger logger = LoggerFactory.getLogger(BotServiceImpl.class);
    private DialogueFlow api;
    private NeuralNetworkBot nBot;

    @Autowired
    public BotServiceImpl(DialogueFlow api, NeuralNetworkBot nBot) {
        this.api = api;
        this.nBot = nBot;
    }

    @Override
    public BotResponse infer(String inputText, HttpSession session) {
        BotResponse response = new BotResponse();
        //Send Request to Dialogue flow
        try {
            response = api.sendRequest(inputText, session);
        } catch (Exception e) {
            logger.error(" error {}", e);
        }
        //Send request to Neural Network if response from dialogue flow is empty
        try {
            if (response.getText().isEmpty()) response = nBot.sendRequest(inputText);
        } catch (Exception e) {
            logger.error("error {}", e);
            response.setText("Couldn't Answer");
        }
        response.setStatus("OK");
        return response;
    }
}
