package com.elementsculmyca.ec19_app.HomePage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.ClubEventListPage.ClubEventListActivity;
import com.elementsculmyca.ec19_app.ClubEventListPage.EventAdapter;
import com.elementsculmyca.ec19_app.DataSources.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.ApiInterface;
import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.elementsculmyca.ec19_app.EventPage.SingleEventActivity;

public class HomeFragment extends Fragment {
    private ApiInterface apiInterface;
    SearchView searchView;
    private ProgressBar bar;
    private EventAdapter adapter;
    private RecyclerView recyclerView;
    Button day1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate( R.layout.fragment_main_screen, container, false );
        searchView=  root.findViewById(R.id.search_view);
        searchView.setQueryHint("Search for Events");
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        recyclerView=root.findViewById(R.id.schedule_recyclerView);
        bar = (ProgressBar)root.findViewById(R.id.pb);
        bar.setVisibility(View.VISIBLE);
        getAllEvents();
        day1=root.findViewById(R.id.btn_day1);
        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SingleEventActivity.class));
            }
        });
        return root;
    }

    void getAllEvents() {
        Call<ArrayList<EventDataModel>> call = apiInterface.getEventList();
        call.enqueue( new Callback<ArrayList<EventDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<EventDataModel>> call, Response<ArrayList<EventDataModel>> response) {
                //TODO YAHAN PE LIST AAEGI API SE UI ME LAGA LENA
                ArrayList<EventDataModel> eventList= response.body();
                adapter = new EventAdapter(eventList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);
                bar.setVisibility(View.GONE);
                Log.e( "Response", response.body().size() + "" );

            }

            @Override
            public void onFailure(Call<ArrayList<EventDataModel>> call, Throwable t) {
                Log.e( "Response", call.request().url() + "" + call.request().body() );

            }

        } );

    }
}
