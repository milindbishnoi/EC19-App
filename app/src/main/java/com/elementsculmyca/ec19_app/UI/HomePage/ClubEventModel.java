package com.elementsculmyca.ec19_app.UI.HomePage;

import android.graphics.Bitmap;

public class ClubEventModel {
    private String displayName, clubName;
    private Bitmap image;


    public ClubEventModel() {
    }

    public ClubEventModel(String displayName, String clubName, Bitmap image) {
        this.displayName = displayName;
        this.clubName = clubName;
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
