package com.elementsculmyca.ec19_app.UI.EventPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.AppDatabase;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventLocalModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventsDao_Impl;
import com.elementsculmyca.ec19_app.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleEventActivity extends AppCompatActivity {
    TextView registerButton,eventName,eventDesc,eventVenue,eventDay,eventDate,eventDayTextView;
    ImageView sharebutton;
    EventsDao_Impl dao;
    private String eventId;
    private String eventClubName,eventCatogery,eventRules,eventPhotoLink,eventCoordinator,eventPrize,eventType,eventTags;
    private int eventFee,eventHitCount;
    private long eventStartTime,eventEndTime;
    EventLocalModel eventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        eventName=findViewById(R.id.event_title);
        eventDesc = findViewById(R.id.event_desc);
        eventDay = findViewById(R.id.event_day);
        eventVenue = findViewById(R.id.event_venue);
        registerButton = findViewById(R.id.register);
        sharebutton = findViewById(R.id.share_event);
        eventDate = findViewById(R.id.event_date);
        eventDayTextView=findViewById(R.id.tv_day);
        eventDayTextView.setText(", Day ");
        dao=new EventsDao_Impl(AppDatabase.getAppDatabase(SingleEventActivity.this));

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
        if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null) {
            String revStr = new StringBuilder(appLinkData.toString()).reverse().toString();
            int i;
            for (i = 0; revStr.charAt(i) != 35; i++) {
            }
            revStr = revStr.substring(0, i);
            String eventName = new StringBuilder(revStr).reverse().toString();
            eventName = eventName.replace("%20", " ");
            eventData =new EventLocalModel();
            eventData = dao.getEventByEventName(eventName);
        }else {
            eventId = getIntent().getStringExtra("eventId");
            eventData =new EventLocalModel();
            eventData = dao.getEventByEventId(eventId);
        }
        //add data to page
        eventName.setText(eventData.getTitle());
        eventId = eventData.getId();
        eventDesc.setText(eventData.getDesc());
        eventVenue.setText(eventData.getVenue());
        eventPhotoLink = eventData.getPhotolink();
        eventStartTime = eventData.getStartTime();
        eventDay.setText(eventData.getDay());
        eventStartTime = eventData.getStartTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        String dateString= formatter.format(new Date(eventStartTime));
        eventDate.setText(dateString);

        final Bundle descFrag = new Bundle();
        descFrag.putString("eventId",eventId);
        descFrag.putString("eventName",eventData.getTitle());
        final DescriptionEventFragment descriptionEventFragment = new DescriptionEventFragment();
        descriptionEventFragment.setArguments(descFrag);
        final RegisterEventFragment registerEventFragment =new RegisterEventFragment();
        registerEventFragment.setArguments(descFrag);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, descriptionEventFragment).commit();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registerButton.getText().equals("Register Now!")) {
                    registerButton.setText("View Details");
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.frame, registerEventFragment).commit();
                } else {
                    registerButton.setText("Register Now!");
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.frame, descriptionEventFragment).commit();
                }
            }
        });

       sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseUrl = "http://elementsculmyca.com/events/";
                String parsedUrl = baseUrl + "#" + eventData.getTitle().toString().replaceAll(" ", "%20");
                String message = "Elements Culmyca 2K19: " + "Code Relay " + "View event by clicking the link: " + parsedUrl;

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent);
            }
        });
    }
}
