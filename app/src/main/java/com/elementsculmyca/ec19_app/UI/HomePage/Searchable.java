package com.elementsculmyca.ec19_app.UI.HomePage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.PrizeModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.TimingsModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.AppDatabase;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventLocalModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventsDao_Impl;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.ClubEventListPage.EventAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Searchable extends AppCompatActivity {
  ApiInterface apiInterface;
    SearchView searchView;
  RecyclerView eventsrecyclerview;
    ArrayList<EventDataModel> eventList;
  EventAdapter adapter;
    ProgressBar bar;
    EventsDao_Impl dao;
    List<EventLocalModel> data;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        searchView = findViewById(R.id.search_view);
        eventsrecyclerview = findViewById(R.id.schdule_recycler);
        layoutManager = new LinearLayoutManager(this);
        dao=new EventsDao_Impl(AppDatabase.getAppDatabase(this));
        eventsrecyclerview.setLayoutManager(layoutManager);

        bar=new ProgressBar(this);
        searchView.setQueryHint("Search for Events");
        int searchSrcTextId = getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchEditText = (EditText) searchView.findViewById(searchSrcTextId);
        searchEditText.setTextColor(Color.parseColor("#4a4a4a"));
        searchEditText.setHintTextColor(Color.parseColor("#4a4a4a"));
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/overpass_black.ttf");
        searchEditText.setTypeface(face);
        eventList=new  ArrayList<EventDataModel>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        bar.setVisibility(View.VISIBLE);
        if(isNetworkAvailable()) {
            bar.setVisibility(View.VISIBLE);
            getAllEvents();
        }else {
            if(dao.countUsers()==0)
                Toast.makeText(this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            getEvents();
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


    }

    private void getEvents() {
        data= dao.getAll();
        for (int i = 0; i < data.size(); i++) {
            PrizeModel prizes= new PrizeModel();
            List<String> prizeList = Arrays.asList(data.get(i).getPrizes().split("%"));
            if(prizeList.size()==1){
                prizes.setPrize1(prizeList.get(0));
            }else if(prizeList.size()==2){
                prizes.setPrize1(prizeList.get(0));
                prizes.setPrize2(prizeList.get(1));
            }else if(prizeList.size()==3){
                prizes.setPrize1(prizeList.get(0));
                prizes.setPrize2(prizeList.get(1));
                prizes.setPrize3(prizeList.get(2));
            }
            TimingsModel time= new TimingsModel(data.get(i).getStartTime(),data.get(i).getEndTime());

            EventDataModel event= new EventDataModel( data.get( i ).getId(),
                    data.get( i ).getTitle() + "",
                    data.get( i ).getClubname() + "",
                    data.get( i ).getCategory() + "",
                    data.get( i ).getDesc() + "",
                    data.get( i ).getRules() + "",
                    data.get( i ).getVenue() + "",
                    data.get( i ).getPhotolink() + "",
                    data.get( i ).getFee(),
                    time,
                    prizes,
                    data.get(i).getEventType() + "",
                    data.get(i).getHitcount() );
            eventList.add(event);
        }
        adapter = new EventAdapter( eventList,Searchable.this);
        eventsrecyclerview.setAdapter(adapter);
    }

    void getAllEvents() {
        Call<ArrayList<EventDataModel>> call = apiInterface.getEventList();
        call.enqueue(new Callback<ArrayList<EventDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<EventDataModel>> call, Response<ArrayList<EventDataModel>> response) {
                //TODO YAHAN PE LIST AAEGI API SE UI ME LAGA LENA
                ArrayList<EventDataModel>  eventList = response.body();
                adapter = new EventAdapter( eventList,Searchable.this);

                eventsrecyclerview.setAdapter(adapter);
                bar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<ArrayList<EventDataModel>> call, Throwable t) {
                bar.setVisibility(View.GONE);
                Log.e("Response", call.request().url() + "" + call.request().body());

            }

        });

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
