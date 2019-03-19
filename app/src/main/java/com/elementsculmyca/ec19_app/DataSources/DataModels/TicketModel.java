package com.elementsculmyca.ec19_app.DataSources.DataModels;

import com.google.gson.annotations.SerializedName;

public class TicketModel {
    @SerializedName("_id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("phone")
    Long phone;
    @SerializedName("email")
    String email;
    @SerializedName("college")
    String college;
    @SerializedName("eventid")
    String eventid;
    @SerializedName("eventname")
    String eventName;
    @SerializedName("timestamp")
    String timestamp;
    @SerializedName("qrcode")
    String qrcode;
    @SerializedName("arrived")
    Boolean arrived;
    @SerializedName("paymentstatus")
    Boolean paymentstatus;
    @SerializedName("team")
    String team;

    public TicketModel(String id, String name, Long phone, String email, String college, String eventid, String eventName, String timestamp, String qrcode, Boolean arrived, Boolean paymentstatus, String team) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.college = college;
        this.eventid = eventid;
        this.eventName = eventName;
        this.timestamp = timestamp;
        this.qrcode = qrcode;
        this.arrived = arrived;
        this.paymentstatus = paymentstatus;
        this.team = team;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Boolean getArrived() {
        return arrived;
    }

    public void setArrived(Boolean arrived) {
        this.arrived = arrived;
    }

    public Boolean getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(Boolean paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
