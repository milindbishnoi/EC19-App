package com.elementsculmyca.ec19_app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class eventLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_layout);


Description_event fragment= new Description_event();
FragmentManager fragmentManager= getSupportFragmentManager();
fragmentManager.beginTransaction().add(R.id.fragments,fragment).commit();


















    }
}
