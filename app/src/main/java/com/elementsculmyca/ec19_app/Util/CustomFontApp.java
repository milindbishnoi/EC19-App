package com.elementsculmyca.ec19_app.Util;

import android.app.Application;

public class CustomFontApp extends Application {
    @Override
    public void onCreate() {

        super.onCreate();
        FontsOverrride.setDefaultFont(this, "DEFAULT", "fonts/cabinsketch_regular.ttf");
        FontsOverrride.setDefaultFont(this, "MONOSPACE", "fonts/cabinsketch_regular.ttf");
        FontsOverrride.setDefaultFont(this, "SERIF", "fonts/cabinsketch_regular.ttf");
        FontsOverrride.setDefaultFont(this, "SANS_SERIF", "fonts/cabinsketch_regular.ttf");
    }
}






