package com.jda.demand.ai.services.dialogueflow;


import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.jda.demand.ai.services.dialogueflow.actions.ActionFactory;
import com.jda.demand.ai.model.BotResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class DialogueFlowServiceImpl implements DialogueFlow {
    private static final Logger logger = LoggerFactory.getLogger(DialogueFlowServiceImpl.class);
    private AIDataService service;

    @Autowired
    private DialogueFlowServiceImpl(AIDataService service) {
        this.service = service;
    }

    @Autowired
    private  ActionFactory factory;

    @Override
    public BotResponse sendRequest(String request, HttpSession session) throws AIServiceException {
        logger.info("Sending Request :{}", request);
        AIRequest aiRequest = new AIRequest(request);
        AIResponse aiResponse = service.request(aiRequest);
        BotResponse botResponse = new BotResponse();

        if(aiResponse.getStatus().getCode() == 200) {
            aiResponse = factory.getAction(aiResponse).perform();
            botResponse.setText(aiResponse.getResult().getFulfillment().getSpeech());
        } else {
            botResponse.setText("Couldn't answer");
        }

        return botResponse;
    }
}
