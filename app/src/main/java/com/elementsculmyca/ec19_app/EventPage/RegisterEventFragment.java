package com.elementsculmyca.ec19_app.EventPage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.elementsculmyca.ec19_app.DataSources.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.ApiInterface;
import com.elementsculmyca.ec19_app.DataSources.DataModels.ResponseModel;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterEventFragment extends Fragment {


    private ApiInterface apiInterface;
    Button add_btn;
    private Button remove_btn;
    LinearLayout ll_mem_layout;
    ArrayList<EditText> et_addmem_array;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate( R.layout.fragment_register_event, container, false );
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        add_btn=view.findViewById(R.id.add_mem);
        ll_mem_layout=view.findViewById(R.id.ll_current_mem);
        et_addmem_array = new ArrayList<>();

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View vi = inflater.inflate(R.layout.add_member_layout, null);
                Log.d("onCLick", "button pressed");
                remove_btn=vi.findViewById(R.id.remove_mem);
                final EditText et = (EditText) vi.findViewById(R.id.memname);

                remove_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ll_mem_layout.removeView(vi);
                        et_addmem_array.remove(et);
                    }
                });
                et_addmem_array.add(et);
                ll_mem_layout.addView(vi);
            }
        });
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