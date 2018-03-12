package com.jda.demand.ai.model.minimdap;


public class Location {
    private String loc;
    private String country;
    private String region;

    public Location(String loc, String country, String region) {
        this.loc = loc;
        this.country = country;
        this.region = region;
    }

    public Location() {
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
