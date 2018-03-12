package com.jda.demand.ai.services.dialogueflow.actions.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {
    @JsonProperty("3h")
    private double threeHours;

    public double getThreeHours() {
        return threeHours;
    }

    public void setThreeHours(double threeHours) {
        this.threeHours = threeHours;
    }
}
