package com.elementsculmyca.ec19_app.UI.ClubEventListPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubEventListActivity extends AppCompatActivity {
    private EventAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar bar;
    private String clubName;
    private ApiInterface apiInterface;
    private TextView clubDisplayName,clubDescpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_event_list);
        clubName = getIntent().getStringExtra("clubname");
        String displayName = getIntent().getStringExtra("clubdisplay");
        bar = (ProgressBar)findViewById(R.id.pb);
        clubDisplayName=findViewById(R.id.tv_category_name_heading);
        if(displayName.equals("Lit-Deb")){
            clubDisplayName.setText("Literary");
        }
        else {
            clubDisplayName.setText(displayName);
        }

        clubDescpTextView = findViewById(R.id.tv_category_descp_heading);

        if (clubName.equals("Manan")) {
            clubDescpTextView.setText("Eat. Sleep. Code. Repeat.");
        } else if (clubName.equals("Ananya")) {
            clubDescpTextView.setText("We can break the world into words.");
        } else if (clubName.equals("Vividha")) {
            clubDescpTextView.setText("Dramatics is what that keeps you in the seats");
        } else if (clubName.equals("Jhalak")) {
            clubDescpTextView.setText("The word “photography” is derived from the Greek words photos (light) and graphé (representation by means of lines)....");
        } else if (clubName.equals("Eklavya")) {
            clubDescpTextView.setText("If you can't have fun there is no sense of doing it. So, Ask yourself, 'Am I having fun?'");
        } else if (clubName.equals("IEEE")) {
            clubDescpTextView.setText("People who are crazy enough enough to think they can change the world are the ones who do.");
        } else if (clubName.equals("Mechnext")) {
            clubDescpTextView.setText("Blood, Sweat and Tears? Nah! Blood, Swear and Gears. ;)");
        } else if (clubName.equals("Microbird")) {
            clubDescpTextView.setText("Oh, come on! You are going to compile codes for some MNC all your life anyway. Try hands-on these robotic beasts this year!");
        } else if (clubName.equals("Nataraja")) {
            clubDescpTextView.setText("Dance dance dance till your feet will follow your heart.");
        } else if (clubName.equals("SAE")) {
            clubDescpTextView.setText("We create! We destroy! But when we screw, even metals would cry.");
        } else if (clubName.equals("Samarpan")) {
            clubDescpTextView.setText("The different merited people who gets together and extends the technical bond to family bond.");
        } else if (clubName.equals("Srijan")) {
            clubDescpTextView.setText("People here play with colours and experiment with varied forms of  art to embrace the hidden artistic element in every sphere of life as what are days with no colours...");
        } else if (clubName.equals("Taranuum")) {
            clubDescpTextView.setText("Tarannum originated in India meaning 'melody' and justifying the name we give melody to the words; calling it music.");
        } else if (clubName.equals("Vivekanand Manch")) {
            clubDescpTextView.setText("Inspired by Swami Vivekanand this is the category where cultural and fun activities fuse with social values. Witness the Social Bonanza.");
        }


        bar.setVisibility(View.VISIBLE);
        recyclerView=findViewById(R.id.events_list);
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        getEventsByClubName();
    }
    void getEventsByClubName() {
        Call<ArrayList<EventDataModel>> call = apiInterface.getEventByClub(clubName);
        call.enqueue( new Callback<ArrayList<EventDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<EventDataModel>> call, Response<ArrayList<EventDataModel>> response) {
                ArrayList<EventDataModel> eventList= response.body();
                adapter = new EventAdapter(eventList);
                recyclerView.setLayoutManager(new LinearLayoutManager(ClubEventListActivity.this,LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);
                bar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<ArrayList<EventDataModel>> call, Throwable t) {
                Log.e( "Response", call.request().url() + "" + call.request().body() );

            }

        } );

    }
}
