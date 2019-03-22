package com.elementsculmyca.ec19_app.UI.EventPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elementsculmyca.ec19_app.DataSources.DataModels.CoordinatorModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.PrizeModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.TimingsModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DescriptionEventFragment extends Fragment{
    private ApiInterface apiInterface;

    private String eventId,eventName,eventClubName,eventCategory,eventDesc,eventRules,eventVenue,eventPhotoLink,eventType;
    private int eventFee,eventHitCount;
    private String[] eventTags;
    private List<CoordinatorModel> eventCoordinator;
    private PrizeModel eventPrize;
    private TimingsModel eventTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        eventId = getArguments().getString("id");
        View view = inflater.inflate(R.layout.fragment_event_description, container, false);
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        return view;
    }

    void getEventById() {
        //Call<EventDataModel> call = apiInterface.getEventById( "5c5e88c90c63f715b8c42499" );
        Call<EventDataModel> call = apiInterface.getEventById( eventId );
        call.enqueue( new Callback<EventDataModel>() {
            @Override
            public void onResponse(Call<EventDataModel> call, Response<EventDataModel> response) {
                //TODO YAHAN PE EVENT KA DATA AAEGA API SE UI ME LAGA LENA
                //JAHAN BHI API KA DATA LENA HAH ESA FUNCTION BANANA HAH
                Log.e( "Response", response.body().getDesc() + "" );

                eventName = response.body().getTitle();
                eventClubName = response.body().getClubname();
                eventCategory = response.body().getCategory();
                eventDesc = response.body().getDesc();
                eventRules = response.body().getRules();
                eventVenue = response.body().getVenue();
                eventPhotoLink = response.body().getPhotolink();
                eventFee = response.body().getFee();
                eventTime = response.body().getTime();
                eventCoordinator = response.body().getCoordinatorModelList();
                eventPrize = response.body().getPrizes();
                eventType = response.body().getEventType();
                eventTags = response.body().getTags();
                eventHitCount = response.body().getHitcount();
            }

            @Override
            public void onFailure(Call<EventDataModel> call, Throwable t) {

            }
        } );

    }

}
