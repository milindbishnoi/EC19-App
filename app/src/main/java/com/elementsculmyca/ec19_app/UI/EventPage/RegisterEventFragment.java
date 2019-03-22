package com.elementsculmyca.ec19_app.UI.EventPage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.app.PendingIntent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Patterns;
import android.content.Intent;

import com.elementsculmyca.ec19_app.DataSources.DataModels.ResponseModel;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiClient;
import com.elementsculmyca.ec19_app.DataSources.RemoteServices.ApiInterface;
import com.elementsculmyca.ec19_app.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.ProgressDialog.show;
import static android.support.v4.content.ContextCompat.getSystemService;


public class RegisterEventFragment extends Fragment {


    private ApiInterface apiInterface;
    EditText userName,userEmail;
    EditText userClg,name,college,userPhone;
    TextView team;
    String intentTeam;
    String intentEmail;
    String intentPhone;
    String intentClg;

    String intentName;
    Button bt;



    ArrayList<TextView> memberno;
    ArrayList<EditText> nameText, collegeText;
    Button addButton;

    int count=1;
    SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String eventName= getArguments().getString("eventname");
        String eventId = getArguments().getString("eventid");

        View view = inflater.inflate( R.layout.fragment_register_event, container, false );



        apiInterface = ApiClient.getClient().create( ApiInterface.class );
       // eventName = getIntent().getStringExtra("eventName");
        //eventId = getIntent().getStringExtra("eventId");
        userName=(EditText) view.findViewById(R.id.user_name);
        userPhone = view.findViewById(R.id.phone_number);
        userClg=(EditText) view.findViewById(R.id.clg);
         userEmail=(EditText) view.findViewById(R.id.useremail) ;
        bt = (Button) view.findViewById(R.id.registerNow);
        memberno = new ArrayList<>();
        nameText = new ArrayList<>();
        collegeText = new ArrayList<>();
        nameText.add(userName);
        collegeText.add(userClg);
        addButton=view.findViewById(R.id.add_mem);
        final LinearLayout layout = view.findViewById(R.id.layout_infater);
        sharedPreferences= this.getActivity().getSharedPreferences("login_details",0);
        userName.setText(sharedPreferences.getString("Username",""));
        userClg.setText(sharedPreferences.getString("UserClg",""));
        userPhone.setText(sharedPreferences.getString("UserPhone",""));
        userEmail.setText(sharedPreferences.getString("userEmail",""));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = LayoutInflater.from(getActivity()).inflate(R.layout.add_member_layout, layout, false);
                name = (EditText) v.findViewById(R.id.memname);
                college = (EditText) v.findViewById(R.id.memclg);
                final Button remove = v.findViewById(R.id.remove_btn);
                final TextView tv_2 =  v.findViewById(R.id.member_no_count);
                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ViewGroup p1 = (ViewGroup) v.getParent();
                        ViewGroup p2 = (ViewGroup) p1.getParent();
                        ViewGroup p3 = (ViewGroup) p2.getParent();
                        ViewGroup p4 = (ViewGroup)p3.getParent();
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


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentName = "";
                intentClg = "";
                intentTeam="";
                intentEmail="";
                intentPhone = "";
                intentPhone += userPhone.getText().toString();
               intentEmail+= userEmail.getText().toString();

                for (int i = 0; i < nameText.size(); i++) {
                    intentName += nameText.get(i).getText().toString() + ",";
                }
                intentName = intentName.substring(0, intentName.length() - 1);

                for (int i = 0; i < collegeText.size(); i++) {
                    intentClg += collegeText.get(i).getText().toString() + ",";
                }
                intentClg = intentClg.substring(0, intentClg.length() - 1);

//
                Boolean checker = validateCredentials();
                if (checker) {

                    registerEvent();

                }
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


                ResponseModel Rm = response.body();


                Log.e( "Response", response.body().getStatus() + "" );

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e( "Response1", call.request().url() + "" + call.request().body() );
            }


        } );


    }



    private Boolean validateCredentials() {



        for (EditText nameTextView : nameText) {
            if (nameTextView.getText().toString().equals("")) {
                nameTextView.setError("Enter a User Name");
                return false;
            }
        }
        for (EditText collegeTextView : collegeText) {
            if (collegeTextView.getText().toString().equals("")) {
                collegeTextView.setError("Enter a College Name");
                return false;
            }
        }

        if (userPhone.getText().toString().equals("")) {
            userPhone.setError("Enter a Phone Number");
            return false;
        }
        if (!Patterns.PHONE.matcher(userPhone.getText().toString()).matches()) {
            userPhone.setError("Enter a valid Phone Number");
            return false;
        }
        if (userPhone.getText().toString().length() != 10) {
            userPhone.setError("Enter a valid Phone Number");
            return false;
        }
        return true;
    }



}