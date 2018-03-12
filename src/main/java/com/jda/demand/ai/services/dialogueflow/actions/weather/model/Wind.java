package com.jda.demand.ai.services.dialogueflow.actions.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
    @JsonProperty("speed")
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}