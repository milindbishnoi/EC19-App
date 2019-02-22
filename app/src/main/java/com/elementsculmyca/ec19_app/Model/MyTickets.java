package com.elementsculmyca.ec19_app.Model;

public class MyTickets {

    private String _id;
    private String name;
    private String phone;
    private String email;
    private String college;
    private String eventid;
    private String eventname;
    private String timestamp;
    private String qrcode;

    public MyTickets(String _id, String name, String phone, String email, String college, String eventid, String eventname, String timestamp, String qrcode) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.college = college;
        this.eventid = eventid;
        this.eventname = eventname;
        this.timestamp = timestamp;
        this.qrcode = qrcode;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCollege() {
        return college;
    }

    public String getEventid() {
        return eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getQrcode() {
        return qrcode;
    }

}
