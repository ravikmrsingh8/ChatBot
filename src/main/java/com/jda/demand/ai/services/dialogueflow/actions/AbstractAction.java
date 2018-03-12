package com.jda.demand.ai.services.dialogueflow.actions;


import ai.api.model.AIResponse;

public abstract class AbstractAction implements Action {
    private AIResponse aIResponse;

    public AbstractAction() {
    }

    public AIResponse getAIResponse() {
        return aIResponse;
    }

    public void setAIResponse(AIResponse aIResponse) {
        this.aIResponse = aIResponse;
    }

    @Override
    public AIResponse perform(){
        if(aIResponse.getResult().isActionIncomplete()) return getAIResponse();
        return performAction();
    }

    protected abstract AIResponse performAction();
}
