package com.jda.demand.ai.services.dialogueflow.actions.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeather extends AbstractWeatherInformation {

    @JsonProperty("coord")
    private Coordinate coordinate;
    private String base;
    @JsonProperty("name")
    private String cityName;
    @JsonProperty("id")
    private long cityId;
    private String cod;
    private String visibility;
    @JsonProperty("sys")
    private SystemParameters systemParameters;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public SystemParameters getSystemParameters() {
        return systemParameters;
    }

    public void setSystemParameters(SystemParameters systemParameters) {
        this.systemParameters = systemParameters;
    }
}

