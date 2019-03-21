package com.elementsculmyca.ec19_app.DataSources.DataModels;

import com.google.gson.annotations.SerializedName;

public class PrizeModel {


    @SerializedName("prize1")
    String prize1;
    @SerializedName("prize2")
    String prize2;
    @SerializedName("prize3")
    String prize3;

    public PrizeModel(){}

    public PrizeModel(String prize1, String prize2, String prize3) {
        this.prize1 = prize1;
        this.prize2 = prize2;
        this.prize3 = prize3;
    }

    public String getPrize1() {
        return prize1;
    }

    public void setPrize1(String prize1) {
        this.prize1 = prize1;
    }

    public String getPrize2() {
        return prize2;
    }

    public void setPrize2(String prize2) {
        this.prize2 = prize2;
    }

    public String getPrize3() {
        return prize3;
    }

    public void setPrize3(String prize3) {
        this.prize3 = prize3;
    }
}
