package com.jda.demand.ai.model.minimdap;


import java.util.Date;

public class Forecast {
    private Date startDate;
    private Integer type;
    private String fcstId;
    private double qty;
    private String model;
    private Long duration;

    public Forecast(double qty, Date date) {
        this.qty = qty;
        this.startDate = date;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFcstId() {
        return fcstId;
    }

    public void setFcstId(String fcstId) {
        this.fcstId = fcstId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
