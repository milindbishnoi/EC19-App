package com.elementsculmyca.ec19_app.UI.BookmarksPage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.DataSources.DataModels.EventDataModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.PrizeModel;
import com.elementsculmyca.ec19_app.DataSources.DataModels.TimingsModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.AppDatabase;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventLocalModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventsDao_Impl;
import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.ClubEventListPage.EventAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookmarksFragment extends Fragment {
    RecyclerView recyclerView;
    EventAdapter mAdapter;
    SharedPreferences sharedPreferences;
    TextView noBookmarks;
    EventsDao_Impl dao;
    ArrayList<EventDataModel> eventList;
    EventLocalModel data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmarks, container, false);
        noBookmarks = view.findViewById(R.id.tv_no_bookmarks);
        recyclerView = view.findViewById(R.id.recycler_view);
        dao=new EventsDao_Impl(AppDatabase.getAppDatabase(getActivity()));
        eventList=new ArrayList<>();
        sharedPreferences= this.getActivity().getSharedPreferences("login_details",Context.MODE_PRIVATE);
        Set<String> set = sharedPreferences.getStringSet("bookmarks", new HashSet<String>());
        if(set.isEmpty())
            noBookmarks.setVisibility(View.VISIBLE);
        else {
            noBookmarks.setVisibility(View.GONE);
            for (String s : set) {
                data = dao.getEventByEventId(s);
                    PrizeModel prizes= new PrizeModel();
                    List<String> prizeList = Arrays.asList(data.getPrizes().split("%"));
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
                    TimingsModel time= new TimingsModel(data.getStartTime(),data.getEndTime());

                    EventDataModel event= new EventDataModel( data.getId(),
                            data.getTitle() + "",
                            data.getClubname() + "",
                            data.getCategory() + "",
                            data.getDesc() + "",
                            data.getRules() + "",
                            data.getVenue() + "",
                            data.getPhotolink() + "",
                            data.getFee(),
                            time,
                            prizes,
                            data.getEventType() + "",
                            data.getHitcount() );
                    eventList.add(event);
                }
            }
            mAdapter = new EventAdapter(eventList, getContext());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(mAdapter);
        return view;
    }

}
