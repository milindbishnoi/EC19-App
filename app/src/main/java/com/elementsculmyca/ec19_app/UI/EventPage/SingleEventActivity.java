package com.elementsculmyca.ec19_app.UI.EventPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.SplashScreen.SplashScreenActivity;

public class SingleEventActivity extends AppCompatActivity {
    TextView registerButton;
    ImageView sharebutton;
    private EventDataModel eventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        registerButton = findViewById(R.id.register);
        sharebutton = findViewById(R.id.share_event);

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
        if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null) {
            String revStr = new StringBuilder(appLinkData.toString()).reverse().toString();
            int i;
            for (i = 0; revStr.charAt(i) != 36; i++) {
            }
            revStr = revStr.substring(0, i);
            String eventName = new StringBuilder(revStr).reverse().toString().toUpperCase();
            eventName = eventName.replace("1#9", " ");
            // retrieve event id...to check if event exist
        } else {

        }

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
                String baseURL = "http://elementsculmyca.com/events/";
                String parsedURl = baseURL + "$" + eventData.getTitle().toString().replaceAll(" ", "1#9");
                String message = "Elements Culmyca 2K19: " + eventData.getTitle().toString() + "View event by clicking the link: " + parsedURl;

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent);
            }
        });
    }
}
