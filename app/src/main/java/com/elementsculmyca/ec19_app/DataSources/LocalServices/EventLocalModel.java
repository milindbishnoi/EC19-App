package com.elementsculmyca.ec19_app.DataSources.LocalServices;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tb_events")
public class EventLocalModel {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    String id;
    @ColumnInfo(name = "title")
    String title;
    @ColumnInfo(name = "clubname")
    String clubname;
    @ColumnInfo(name = "category")
    String category;
    @ColumnInfo(name = "desc")
    String desc;
    @ColumnInfo(name = "rules ")
    String rules;
    @ColumnInfo(name = "venue")
    String venue;
    @ColumnInfo(name = "photolink")
    String photolink;
    @ColumnInfo(name = "fee")
    int fee;
    @ColumnInfo(name = "startTime")
    Long startTime;
    @ColumnInfo(name = "endTime")
    Long endTime;
    @ColumnInfo(name = "coordinators")
    String coordinator;

    @ColumnInfo(name = "prizes")
    String prizes;
    @ColumnInfo(name = "eventtype")
    String eventType;
    @ColumnInfo(name = "tags")
    String tags;
    @ColumnInfo(name = "hitCount ")
    int hitcount;

    @ColumnInfo(name = "day")
    String  day;

    public EventLocalModel(){}

    public EventLocalModel(@NonNull String id, String title, String clubname, String category, String desc, String rules, String venue, String photolink, int fee, Long startTime, Long endTime, String coordinator, String prizes, String eventType, String tags, int hitcount,String day) {
        this.id = id;
        this.title = title;
        this.clubname = clubname;
        this.category = category;
        this.desc = desc;
        this.rules = rules;
        this.venue = venue;
        this.photolink = photolink;
        this.fee = fee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.coordinator = coordinator;
        this.prizes = prizes;
        this.eventType = eventType;
        this.tags = tags;
        this.hitcount = hitcount;
        this.day=day;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getPrizes() {
        return prizes;
    }

    public void setPrizes(String prizes) {
        this.prizes = prizes;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getHitcount() {
        return hitcount;
    }

    public void setHitcount(int hitcount) {
        this.hitcount = hitcount;
    }

    public String  getDay() { return day; }

    public void setDay(String day) { this.day = day; }
}
