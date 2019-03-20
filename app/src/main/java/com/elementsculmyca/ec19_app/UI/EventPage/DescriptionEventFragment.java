package com.elementsculmyca.ec19_app.UI.EventPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DescriptionEventFragment extends Fragment{
    private ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_description, container, false);
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        return view;
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
