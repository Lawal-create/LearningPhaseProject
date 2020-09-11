package com.example.google_project_phase;

public class Name2 {
    private String name;
    private String country;
    private String score;
    private String badgeUrl;

    public Name2(){}
    public Name2(String name, String country, String score, String badgeUrl){
        this.name=name;
        this.score =score;
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

    public String getScore() {
        return score + "skill IQ score,";
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
