package com.elementsculmyca.ec19_app.MainScreen;

import java.util.ArrayList;

public class EventListModel {

    private String id,clubname,title,eventtype,category,description,venue,photolink,date,starttime,endtime;
    private int fees;
    private ArrayList<Coordinators> mCoordinators;
    private ArrayList<String> mPrizes;

    public EventListModel(String id, String clubname, String title, String eventtype, String category, String description, String venue, String photolink, String date, String starttime, String endtime, int fees, ArrayList<Coordinators> mCoordinators, ArrayList<String> mPrizes) {
        this.id = id;
        this.clubname = clubname;
        this.title = title;
        this.eventtype = eventtype;
        this.category = category;
        this.description = description;
        this.venue = venue;
        this.photolink = photolink;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
        this.fees = fees;
        this.mCoordinators = mCoordinators;
        this.mPrizes = mPrizes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public ArrayList<Coordinators> getmCoordinators() {
        return mCoordinators;
    }

    public void setmCoordinators(ArrayList<Coordinators> mCoordinators) {
        this.mCoordinators = mCoordinators;
    }

    public ArrayList<String> getmPrizes() {
        return mPrizes;
    }

    public void setmPrizes(ArrayList<String> mPrizes) {
        this.mPrizes = mPrizes;
    }
}
