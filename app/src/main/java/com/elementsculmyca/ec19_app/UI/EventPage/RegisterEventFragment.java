package com.elementsculmyca.ec19_app.UI.EventPage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.elementsculmyca.ec19_app.DataSources.DataModels.ResponseModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterEventFragment extends Fragment {


    private ApiInterface apiInterface;
    EditText username;
    EditText userclg;
    SharedPreferences sharedPreferences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_register_event, container, false );
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        username=(EditText) view.findViewById(R.id.user_name);
        userclg=(EditText) view.findViewById(R.id.clg);
        sharedPreferences= this.getActivity().getSharedPreferences("login_details",0);
        username.setText(sharedPreferences.getString("Username",""));
        userclg.setText(sharedPreferences.getString("UserClg",""));
        return view;
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