package com.elementsculmyca.ec19_app.HomePage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.elementsculmyca.ec19_app.AdapterCategoriesRecyclerView;
import com.elementsculmyca.ec19_app.ClubEventListPage.EventAdapter;
import com.elementsculmyca.ec19_app.DataSources.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.ApiInterface;
import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.EventPage.SingleEventActivity;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ApiInterface apiInterface;
    SearchView searchView;
    private ProgressBar bar;
    private EventAdapter adapter;
    private AdapterCategoriesRecyclerView adapterCategoriesRecyclerView;
    private RecyclerView recyclerView;
    private ArrayList<String> genres;
    private  ArrayList<Bitmap> mImages;
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
        addData();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.HORIZONTAL,false);
        adapterCategoriesRecyclerView=new AdapterCategoriesRecyclerView(mImages,genres, getActivity().getBaseContext());
        RecyclerView categoryRecycleview = (RecyclerView) root.findViewById(R.id.categories_recyclerView);
        categoryRecycleview.setLayoutManager(linearLayoutManager);
        categoryRecycleview.setAdapter(adapterCategoriesRecyclerView);
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
    public void addData()
    {
        genres.add("MANAN");
        mImages.add(BitmapFactory.decodeResource(HomeFragment.this.getResources(), R.raw.drama_x_9_ad_78png));
        genres.add("MANAN");
        mImages.add(BitmapFactory.decodeResource(HomeFragment.this.getResources(), R.raw.drama_x_9_ad_78png));
        genres.add("MANAN");
        mImages.add(BitmapFactory.decodeResource(HomeFragment.this.getResources(), R.raw.drama_x_9_ad_78png));
        genres.add("MANAN");
        mImages.add(BitmapFactory.decodeResource(HomeFragment.this.getResources(), R.raw.drama_x_9_ad_78png));
        genres.add("MANAN");
        mImages.add(BitmapFactory.decodeResource(HomeFragment.this.getResources(), R.raw.drama_x_9_ad_78png));
        genres.add("MANAN");
        mImages.add(BitmapFactory.decodeResource(HomeFragment.this.getResources(), R.raw.drama_x_9_ad_78png));
        genres.add("MANAN");
        mImages.add(BitmapFactory.decodeResource(HomeFragment.this.getResources(), R.raw.drama_x_9_ad_78png));

    }
}
