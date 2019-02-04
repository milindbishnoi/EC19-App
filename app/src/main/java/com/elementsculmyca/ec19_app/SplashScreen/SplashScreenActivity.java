package com.elementsculmyca.ec19_app.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.elementsculmyca.ec19_app.LoginScreen.LoginPresenter;
import com.elementsculmyca.ec19_app.MainScreen.MainScreenActivity;
import com.elementsculmyca.ec19_app.R;

public class SplashScreenActivity extends Activity {
    public static int SPLASH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent SplashScreen =new Intent(SplashScreenActivity.this, LoginPresenter.class);
                startActivity(SplashScreen);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
//jai mata di