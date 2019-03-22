package com.elementsculmyca.ec19_app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.UI.ClubEventListPage.EventAdapter;

import java.util.ArrayList;

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
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        searchView = findViewById(R.id.search_view);
        eventsrecyclerview = findViewById(R.id.schdule_recycler);
        layoutManager = new LinearLayoutManager(this);

        eventsrecyclerview.setLayoutManager(layoutManager);

        bar=new ProgressBar(this);
        searchView.setQueryHint("Search for Events");
        eventList=new  ArrayList<EventDataModel>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        bar.setVisibility(View.VISIBLE);
        if(isNetworkAvailable()) {
            bar.setVisibility(View.VISIBLE);
            getAllEvents();

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
