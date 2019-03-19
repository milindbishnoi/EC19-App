package com.elementsculmyca.ec19_app.DataSources.DataModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventDataModel {

    @SerializedName("_id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("clubname")
    String clubname;
    @SerializedName("category")
    String category;
    @SerializedName("desc")
    String desc;
    @SerializedName("rules ")
    String rules;
    @SerializedName("venue")
    String venue;
    @SerializedName("photolink")
    String photolink;
    @SerializedName("fee")
    int fee;
    // @SerializedName("timing")
    TimingsModel time;

    @SerializedName("coordinators")
    List<CoordinatorModel> coordinatorModelList;
    @SerializedName("prizes")
    PrizeModel prizes;
    @SerializedName("eventtype")
    String eventType;
    @SerializedName("tags")
    String[] tags;
    @SerializedName("hitCount ")
    int hitcount;

    public EventDataModel(String id, String title, String clubname, String category, String desc, String rules, String venue, String photolink, int fee, TimingsModel time, List<CoordinatorModel> coordinatorModelList, PrizeModel prizes, String eventType, String[] tags, int hitcount) {
        this.id = id;
        this.title = title;
        this.clubname = clubname;
        this.category = category;
        this.desc = desc;
        this.rules = rules;
        this.venue = venue;
        this.photolink = photolink;
        this.fee = fee;
        this.time = time;
        this.coordinatorModelList = coordinatorModelList;
        this.prizes = prizes;
        this.eventType = eventType;
        this.tags = tags;
        this.hitcount = hitcount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPhotolink() {
        return photolink;
    }

    public void setPhotolink(String photolink) {
        this.photolink = photolink;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public TimingsModel getTime() {
        return time;
    }

    public void setTime(TimingsModel time) {
        this.time = time;
    }

    public List<CoordinatorModel> getCoordinatorModelList() {
        return coordinatorModelList;
    }

    public void setCoordinatorModelList(List<CoordinatorModel> coordinatorModelList) {
        this.coordinatorModelList = coordinatorModelList;
    }

    public PrizeModel getPrizes() {
        return prizes;
    }

    public void setPrizes(PrizeModel prizes) {
        this.prizes = prizes;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int getHitcount() {
        return hitcount;
    }

    public void setHitcount(int hitcount) {
        this.hitcount = hitcount;
    }
}
