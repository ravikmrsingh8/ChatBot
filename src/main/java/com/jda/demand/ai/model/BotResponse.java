package com.jda.demand.ai.model;

public class BotResponse {
    private String text;
    private String status;

    public BotResponse() {
        text = "";
        status = "FAILED";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
