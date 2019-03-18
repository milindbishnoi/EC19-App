package com.elementsculmyca.ec19_app.EventPage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.elementsculmyca.ec19_app.R;

public class EventMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_layout);
//

        DescriptionEventFragment fragment = new DescriptionEventFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragments, fragment).commit();



    }
}
