package com.jda.demand.ai.services.dialogueflow.actions;


import ai.api.model.AIResponse;

public class NoAction extends AbstractAction {

    @Override
    protected AIResponse performAction() {
        return getAIResponse();
    }
}
