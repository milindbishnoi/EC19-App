package com.elementsculmyca.ec19_app.EventPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.Model.ApiClient;
import com.elementsculmyca.ec19_app.Model.ApiInterface;
import com.elementsculmyca.ec19_app.Model.EventModel;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DescriptionEventFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description_event, container, false);
        Button button = (Button) view.findViewById(R.id.button5);
        final TextView t1=(TextView)view.findViewById(R.id.description);
        button.setOnClickListener(this);
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<EventModel>> call=apiService.getAllEvent();
        call.enqueue(new Callback<ArrayList<EventModel>>() {
            @Override
            public void onResponse(Call<ArrayList<EventModel>> call, Response<ArrayList<EventModel>> response) {

                Log.e("CheckTag",response.raw()+"");

                ArrayList<EventModel> ar =  response.body();

                Log.e("CheckTag",ar.get(0).getDescription()+"");
                t1.setText(ar.get(0).getDescription().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<EventModel>> call, Throwable t) {
                Log.i("yoooo",call.request().url().toString()+"");


            }
        });
        return view;
        }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                RegisterEventFragment fragment1 = new RegisterEventFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.fragments)).setCustomAnimations(R.animator.fragment_slide_left_enter, R.animator.fragment_slide_right_exit, R.animator.fragment_slide_right_enter, R.animator.fragment_slide_left_exit).add(R.id.fragments, fragment1).commit();
                break;
        }
    }

}
