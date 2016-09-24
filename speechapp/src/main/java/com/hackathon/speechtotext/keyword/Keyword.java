package com.hackathon.speechtotext.keyword;

/**
 * Created by sathih on 23-09-2016.
 */
public class Keyword {

    private String purpose;
    private String place;
    private String time;
    private String weekday;

    public Keyword(String purpose, String place, String time, String weekday) {
        this.purpose = purpose;
        this.place = place;
        this.time = time;
        this.weekday = weekday;
    }

    public Keyword() {
    }

    public String getPurpose() {
        return purpose;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "purpose='" + purpose + '\'' +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                ", weekday='" + weekday + '\'' +
                '}';
    }
}
