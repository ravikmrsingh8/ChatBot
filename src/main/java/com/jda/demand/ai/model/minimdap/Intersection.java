package com.jda.demand.ai.model.minimdap;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {
    private String dmdUnit;
    private String dmdGroup;
    private String loc;
    private String dmdUnitLevel;
    private String locLevel;
    private String groupLevel;

    private Map<String, List<Forecast>> salesPlan = new HashMap<>();

    public Intersection() {

    }

    public String getDmdUnit() {
        return dmdUnit;
    }

    public void setDmdUnit(String dmdUnit) {
        this.dmdUnit = dmdUnit;
    }

    public String getDmdGroup() {
        return dmdGroup;
    }

    public void setDmdGroup(String dmdGroup) {
        this.dmdGroup = dmdGroup;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getLocLevel() {
        return locLevel;
    }

    public void setLocLevel(String locLevel) {
        this.locLevel = locLevel;
    }

    public String getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(String groupLevel) {
        this.groupLevel = groupLevel;
    }

    public Map<String, List<Forecast>> getSalesPlan() {
        return salesPlan;
    }

    public void setSalesPlan(Map<String, List<Forecast>> salesPlan) {
        this.salesPlan = salesPlan;
    }

    public String getDmdUnitLevel() {
        return dmdUnitLevel;
    }

    public void setDmdUnitLevel(String dmdUnitLevel) {
        this.dmdUnitLevel = dmdUnitLevel;
    }
}
