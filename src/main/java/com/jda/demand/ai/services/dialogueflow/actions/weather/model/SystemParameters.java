package com.jda.demand.ai.services.dialogueflow.actions.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.JsonAdapter;

import java.util.Date;


public class SystemParameters {
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("message")
    private String message;
    @JsonProperty("country")
    private String country;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @JsonProperty("sunrise")
    private Date sunrise;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @JsonProperty("sunset")
    private Date sunset;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }
}
