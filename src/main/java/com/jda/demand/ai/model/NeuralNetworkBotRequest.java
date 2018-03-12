package com.jda.demand.ai.model;


public class NeuralNetworkBotRequest {
    private String text;

    public NeuralNetworkBotRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
