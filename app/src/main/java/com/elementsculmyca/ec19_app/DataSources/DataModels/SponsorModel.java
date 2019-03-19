package com.elementsculmyca.ec19_app.DataSources.DataModels;

import com.google.gson.annotations.SerializedName;

public class SponsorModel {

    @SerializedName("_id")
    String id;
    @SerializedName("logo")
    String logo;
    @SerializedName("name")
    String name;
    @SerializedName("rank")
    int rank;
    @SerializedName("title")
    String title;
    @SerializedName("website")
    String website;

    public SponsorModel(String id, String logo, String name, int rank, String title, String website) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.rank = rank;
        this.title = title;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}



