package com.elementsculmyca.ec19_app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.PrizeModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.TimingsModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.AppDatabase;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventLocalModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventsDao_Impl;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.UI.ClubEventListPage.EventAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Day2Fragment extends Fragment {
    private RecyclerView recyclerView;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class );
    private EventAdapter adapter;
    EventsDao_Impl dao;
    List<EventLocalModel> data;
    private EventAdapter eventAdapter;
    ArrayList<EventDataModel> eventList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_day2,container, false);

        recyclerView=root.findViewById(R.id.schdule_recycler2);

        dao=new EventsDao_Impl(AppDatabase.getAppDatabase(getActivity()));
        if(dao.countUsers()==0&&!isNetworkAvailable())
            Toast.makeText(getActivity(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
        eventList=new ArrayList<>();
        data = dao.getEventByDay("2");
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
        eventAdapter = new EventAdapter(eventList,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(eventAdapter);

        return root;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
