package com.elementsculmyca.ec19_app.UI.EventPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.DataSources.DataModels.CoordinatorModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.PrizeModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.TimingsModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.AppDatabase;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventLocalModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventsDao_Impl;
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
    private TextView rules;
    EventsDao_Impl dao;
    EventLocalModel eventData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        eventId = getArguments().getString("id");
        dao=new EventsDao_Impl(AppDatabase.getAppDatabase(getActivity()));
        View view = inflater.inflate(R.layout.fragment_event_description, container, false);
        rules = view.findViewById(R.id.rules);
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        Toast.makeText(getActivity(), eventId, Toast.LENGTH_SHORT).show();
        eventData =new EventLocalModel();
        eventData = dao.getEventByEventId(eventId);
        rules.setText("gggvh");
        return view;
    }

}
