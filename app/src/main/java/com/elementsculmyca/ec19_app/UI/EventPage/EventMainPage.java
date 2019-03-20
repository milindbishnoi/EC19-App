package com.elementsculmyca.ec19_app.UI.EventPage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventMainPage extends AppCompatActivity {

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_layout);
//
        apiInterface = ApiClient.getClient().create( ApiInterface.class );

        DescriptionEventFragment fragment = new DescriptionEventFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragments, fragment).commit();


    }

    void getEventById() {
        Call<EventDataModel> call = apiInterface.getEventById( "5c5e88c90c63f715b8c42499" );
        call.enqueue( new Callback<EventDataModel>() {
            @Override
            public void onResponse(Call<EventDataModel> call, Response<EventDataModel> response) {
                //TODO YAHAN PE EVENT KA DATA AAEGA API SE UI ME LAGA LENA
                //JAHAN BHI API KA DATA LENA HAH ESA FUNCTION BANANA HAH
                Log.e( "Response", response.body().getDesc() + "" );

            }

            @Override
            public void onFailure(Call<EventDataModel> call, Throwable t) {

            }
        } );

    }
}
