package com.elementsculmyca.ec19_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        RecyclerView event_list = findViewById(R.id.event_list);
        event_list.setLayoutManager(new GridLayoutManager(this,2));
        List<EventListModel> eventlist;
        eventlist = new ArrayList<>();
        for(int i=0; i<15; i++)
        {
            EventListModel el = new EventListModel(
                    "dummy event",
                    "all about dummy event"
            );
            eventlist.add(el);
        }
        event_list.setAdapter(new EventListAdapter(eventlist));
    }
}
