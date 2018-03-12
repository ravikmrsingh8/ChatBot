package com.jda.demand.ai.services.dialogueflow.actions.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {

    @JsonProperty("all")
    private double all;

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }
}
