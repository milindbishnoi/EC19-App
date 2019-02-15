package com.elementsculmyca.ec19_app.MainScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;
import java.util.List;

public class SearchEventActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<EventListModel> eventlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
        recyclerView = findViewById(R.id.event_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventlist = new ArrayList<>();

        for (int i = 0; i <= 20; i++) {
            EventListModel el = new EventListModel(
                    "Dummy Event",
                    "all about dummy Event"
            );
            eventlist.add(el);
        }
        recyclerView.setAdapter(new EventListAdapter(eventlist));
    }

    @Override
    public void onBackPressed() {
        finish();
        return;
    }
}
