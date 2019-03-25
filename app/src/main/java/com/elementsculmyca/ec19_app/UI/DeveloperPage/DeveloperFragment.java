package com.elementsculmyca.ec19_app.UI.DeveloperPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.DataSources.LocalServices.AppDatabase;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventLocalModel;
import com.elementsculmyca.ec19_app.DataSources.LocalServices.EventsDao_Impl;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

public class DeveloperFragment extends Fragment {
    private ArrayList<DeveloperModel> developers;
    RecyclerView recyclerView;
    DeveloperAdapter mAdapter;
    DeveloperModel developer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_developers, container, false);
        developers = new ArrayList<>();
        addData();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = new DeveloperAdapter(developers,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    private void addData() {
        developer = new DeveloperModel("https://i.ytimg.com/vi/OH2XPFbngvk/maxresdefault.jpg","Prerna Suneja","Team Head","https://www.facebook.com/profile.php?id=100007870874885","https://github.com/Prerna1","https://www.instagram.com/prerna_suneja_07/","https://www.linkedin.com/in/prerna-suneja-96b97714b/");
        developers.add(developer);

        developer = new DeveloperModel("https://i.ytimg.com/vi/OH2XPFbngvk/maxresdefault.jpg","Prerna Suneja","Team Head","https://www.facebook.com/profile.php?id=100007870874885","https://github.com/Prerna1","https://www.instagram.com/prerna_suneja_07/","https://www.linkedin.com/in/prerna-suneja-96b97714b/");
        developers.add(developer);

        developer = new DeveloperModel("https://i.ytimg.com/vi/OH2XPFbngvk/maxresdefault.jpg","Prerna Suneja","Team Head","https://www.facebook.com/profile.php?id=100007870874885","https://github.com/Prerna1","https://www.instagram.com/prerna_suneja_07/","https://www.linkedin.com/in/prerna-suneja-96b97714b/");
        developers.add(developer);

        developer = new DeveloperModel("https://i.ytimg.com/vi/OH2XPFbngvk/maxresdefault.jpg","Prerna Suneja","Team Head","https://www.facebook.com/profile.php?id=100007870874885","https://github.com/Prerna1","https://www.instagram.com/prerna_suneja_07/","https://www.linkedin.com/in/prerna-suneja-96b97714b/");
        developers.add(developer);
    }
}
