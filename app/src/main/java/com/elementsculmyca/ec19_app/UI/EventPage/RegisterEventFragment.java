package com.elementsculmyca.ec19_app.UI.EventPage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.DataSources.DataModels.ResponseModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterEventFragment extends Fragment {


    private ApiInterface apiInterface;
    Button add_btn;
    int count = 1;
    ArrayList<TextView> memberno;
    private EditText name,college,mainName,mainClg;
    ArrayList<EditText> nameText, collegeText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_register_event, container, false );
        final LinearLayout layout = view.findViewById(R.id.layout_infater);
        apiInterface = ApiClient.getClient().create( ApiInterface.class );
        add_btn=view.findViewById(R.id.add_mem);
        nameText = new ArrayList<>();
        collegeText = new ArrayList<>();
        memberno = new ArrayList<>();
        mainName = (EditText) view.findViewById(R.id.ld_reg_name);
        mainClg = (EditText) view.findViewById(R.id.ld_reg_clg);
        nameText.add(mainName);
        collegeText.add(mainClg);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = LayoutInflater.from(getActivity()).inflate(R.layout.add_member_layout, layout, false);
                name = v.findViewById(R.id.name);
                college =  v.findViewById(R.id.clg);
                final Button remove =  v.findViewById(R.id.remove_btn);
                final TextView tv_2 = v.findViewById(R.id.member_no_count);
                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup p1 = (ViewGroup) v.getParent();
                        ViewGroup p2 = (ViewGroup) p1.getParent();
                        ViewGroup p3 = (ViewGroup) p2.getParent();
                        ViewGroup p4 =(ViewGroup) p3.getParent();
                        Integer remove_member = Integer.parseInt(tv_2.getText().toString());

                        nameText.remove(remove_member - 1);
                        collegeText.remove(remove_member - 1);
                        memberno.remove(tv_2);
                        update();
                        p4.removeView(p3);
                        count--;
                    }
                });
                count++;
                tv_2.setText(String.valueOf(count));
                memberno.add(tv_2);
                nameText.add(name);
                collegeText.add(college);

                layout.addView(v);
            }


        });
        return view;


    }
    private void update() {
        for (int i = 0; i < memberno.size(); i++) {
            memberno.get(i).setText(String.valueOf(i + 2));
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