package com.elementsculmyca.ec19_app.DataSources.DataModels;

import com.google.gson.annotations.SerializedName;

public class CoordinatorModel {

    @SerializedName("_id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("phone")
    Long phone;

    public CoordinatorModel(String id, String name, Long phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public CoordinatorModel(){}

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
}
