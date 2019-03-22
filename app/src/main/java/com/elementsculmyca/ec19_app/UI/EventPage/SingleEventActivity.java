package com.elementsculmyca.ec19_app.UI.EventPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.AppDatabase;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventLocalModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventsDao_Impl;
import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.SplashScreen.SplashScreenActivity;

public class SingleEventActivity extends AppCompatActivity {
    TextView registerButton,eventName,eventDesc,eventVenue,eventDay;
    ImageView sharebutton;
    EventsDao_Impl dao;
    private String eventId,eventClubName,eventCatogery,eventRules,eventPhotoLink,eventCoordinator,eventPrize,eventType,eventTags;
    private int eventFee,eventHitCount;
    private long eventStartTime,eventEndTime;
    EventLocalModel eventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        eventName=findViewById(R.id.event_title);
        eventDesc = findViewById(R.id.event_desc);
        eventVenue = findViewById(R.id.event_venue);
        eventDay = findViewById(R.id.event_day);
        registerButton = findViewById(R.id.register);
        sharebutton = findViewById(R.id.share_event);
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
        eventClubName = eventData.getClubname();
        eventCatogery = eventData.getCategory();
        eventDesc.setText(eventData.getDesc());
        eventRules = eventData.getRules();
        eventVenue.setText(eventData.getVenue());
        eventPhotoLink = eventData.getPhotolink();
        eventFee = eventData.getFee();
        eventStartTime = eventData.getStartTime();
        eventEndTime = eventData.getEndTime();
        eventCoordinator = eventData.getCoordinator();
        eventPrize = eventData.getPrizes();
        eventType = eventData.getEventType();
        eventDay.setText(eventData.getDay());
        eventTags = eventData.getTags();
        eventHitCount = eventData.getHitcount();

        Bundle bundle = new Bundle();
        bundle.putString("id",eventId);
        DescriptionEventFragment descriptionEventFragment = new DescriptionEventFragment();
        descriptionEventFragment.setArguments(bundle);


        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, new DescriptionEventFragment()).commit();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registerButton.getText().equals("Register Now!")) {
                    registerButton.setText("View Details");
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.frame, new RegisterEventFragment()).commit();
                } else {
                    registerButton.setText("Register Now!");
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.frame, new DescriptionEventFragment()).commit();
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
