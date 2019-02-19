package com.elementsculmyca.ec19_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Description_event extends Fragment implements View.OnClickListener {











    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_description_event, container, false);
        Button button=(Button) view.findViewById(R.id.button5);
        button.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.button5:
                Register_event fragment1= new Register_event();
                FragmentManager fragmentManager= getFragmentManager();
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.fragments)).setCustomAnimations(R.animator.fragment_slide_left_enter,R.animator.fragment_slide_right_exit,R.animator.fragment_slide_right_enter,R.animator.fragment_slide_left_exit).add(R.id.fragments,fragment1).commit();
                break;
            }
        }

}
