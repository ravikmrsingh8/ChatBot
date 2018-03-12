package com.jda.demand.ai.services.dialogueflow;



import com.jda.demand.ai.model.BotResponse;

import javax.servlet.http.HttpSession;

public interface DialogueFlow {
    BotResponse sendRequest(String request, HttpSession session) throws Exception;
}
