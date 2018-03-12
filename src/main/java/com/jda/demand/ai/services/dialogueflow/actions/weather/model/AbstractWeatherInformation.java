package com.jda.demand.ai.services.dialogueflow.actions.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.JsonAdapter;

import java.util.Date;
import java.util.List;

public class AbstractWeatherInformation  {
    @JsonProperty("main")
    private MainParameters mainParameters;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @JsonProperty("dt")
    private Date dateTime;
    private List<Weather> weather;

    public MainParameters getMainParameters() {
        return mainParameters;
    }

    public void setMainParameters(MainParameters mainParameters) {
        this.mainParameters = mainParameters;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
