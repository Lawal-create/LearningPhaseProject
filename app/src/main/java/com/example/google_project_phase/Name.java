package com.example.google_project_phase;

public class Name {
    private String name;
    private String country;
    private String hours;
    private String badgeUrl;

    public Name(){}
    public Name(String name,String country,String hours,String badgeUrl){
        this.name=name;
        this.hours=hours;
        this.country=country;
        this.badgeUrl=badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHours() {
        return hours + "learning hours,";
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
