package com.elementsculmyca.ec19_app.EventPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elementsculmyca.ec19_app.DataSources.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.ApiInterface;
import com.elementsculmyca.ec19_app.DataSources.DataModels.ResponseModel;
import com.elementsculmyca.ec19_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterEventFragment extends Fragment implements View.OnClickListener {


    private ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_event, container, false);
        apiInterface = ApiClient.getClient().create( ApiInterface.class );

        Button button1 = (Button) view.findViewById(R.id.button4);
        button1.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                Fragment fragment2 = new DescriptionEventFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.fragments)).setCustomAnimations(R.animator.fragment_slide_left_enter, R.animator.fragment_slide_right_exit).add(R.id.fragments, fragment2).commit();
        }
    }

    void registerEvent() {
        Call<ResponseModel> call = apiInterface.postregisterEvent( "asd", "asfa,", "asda",
                "saf", "sfs", "sfsf", "fsdf", "dsfsf" );
        call.enqueue( new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                //TODO YAHAN PE EVENT KA DATA AAEGA API SE UI ME LAGA LENA
                Log.e( "Response", response.body().getStatus() + "" );

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }


        } );

    }
}
