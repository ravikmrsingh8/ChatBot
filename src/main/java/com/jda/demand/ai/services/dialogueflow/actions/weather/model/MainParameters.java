package com.jda.demand.ai.services.dialogueflow.actions.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MainParameters {
    @JsonProperty("temp")
    private double temperature;
    @JsonProperty("pressure")
    private double pressure;
    @JsonProperty("humidity")
    private double humidity;
    @JsonProperty("temp_min")
    private double minimumTemperature;
    @JsonProperty("temp_max")
    private double maximumTemperature;
    @JsonProperty("sea_level")
    private double seaLevelPressure;
    @JsonProperty("grnd_level")
    private double groundLevelPressure;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    public double getGroundLevelPressure() {
        return groundLevelPressure;
    }

    public void setGroundLevelPressure(double groundLevelPressure) {
        this.groundLevelPressure = groundLevelPressure;
    }


}


