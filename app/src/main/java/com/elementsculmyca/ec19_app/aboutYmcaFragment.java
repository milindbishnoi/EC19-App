package com.elementsculmyca.ec19_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class aboutYmcaFragment extends Fragment {



    public aboutYmcaFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView= (ViewGroup)inflater.inflate(R.layout.fragment_about_ymca, container, false);
        return rootView;
    }




}
