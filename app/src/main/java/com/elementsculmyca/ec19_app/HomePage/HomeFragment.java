package com.elementsculmyca.ec19_app.HomePage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elementsculmyca.ec19_app.DataSources.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.ApiInterface;
import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate( R.layout.fragment_main_screen, container, false );
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        getAllEvents();

        return root;

    }

    void getAllEvents() {
        Call<ArrayList<EventDataModel>> call = apiInterface.getEventList();
        call.enqueue( new Callback<ArrayList<EventDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<EventDataModel>> call, Response<ArrayList<EventDataModel>> response) {
                //TODO YAHAN PE LIST AAEGI API SE UI ME LAGA LENA
                Log.e( "Response", response.body().size() + "" );

            }

            @Override
            public void onFailure(Call<ArrayList<EventDataModel>> call, Throwable t) {

                Log.e( "Response", call.request().url() + "" + call.request().body() );

            }

        } );

    }
}
