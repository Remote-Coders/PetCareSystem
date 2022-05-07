package com.example.remotecoders;

public class PetSittingAds extends Advertisements{
    private String weekdays;
    private String weekends;

    public PetSittingAds() {
        super();
        this.weekdays = "";
        this.weekends = "";
    }

    public PetSittingAds(String weekdays, String weekends) {
        this.weekdays = weekdays;
        this.weekends = weekends;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public String getWeekends() {
        return weekends;
    }

    public void setWeekends(String weekends) {
        this.weekends = weekends;
    }
}
