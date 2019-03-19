package com.elementsculmyca.ec19_app.DataSources.DataModels;

import com.google.gson.annotations.SerializedName;

public class TimingsModel {


    @SerializedName("from")
    long from;

    @SerializedName("to")
    long to;

    public TimingsModel(long from, long to) {
        this.from = from;
        this.to = to;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }
}
