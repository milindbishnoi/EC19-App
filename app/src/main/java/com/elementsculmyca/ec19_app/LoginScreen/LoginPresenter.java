package com.elementsculmyca.ec19_app.LoginScreen;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

// GOOGLE SIGN IN
// FOR GETTING PROFILE PIC USE VARIABLE " profPic" and FIRSTLY FIND THE IMAGE VIEW IN ON CREATE METHOD BY USING FINDVIEWBYID AND GIVE ITS VARIABLE NAME AS " profPic" AND CODE FOR IMAGE IS COMMENTED SP THAT ID DOES NOT EFFECT THE PROCESS SO ALSO LOOK AFTER THAT
// FOR GETTING USER NAME USE VARIABLE " userName"
// FOR GETTING USER EMAIL USE VARIABLE " userEmail"


public class LoginPresenter extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    SignInButton signin;
    GoogleApiClient googleApiClient;
    ImageView profPic;
    String userName, userEmail;
    int reqCode = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_presenter);
        signin = findViewById(R.id.googleLogin);
        signin.setOnClickListener(this);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();


    }

    @Override
    public void onClick(View v) {
        signIn();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
    void signIn(){
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,reqCode);
    }


    void handleResult(GoogleSignInResult result){

        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            userName = account.getDisplayName();
            userEmail = account.getEmail();
            Toast.makeText(LoginPresenter.this,"Hello , "+userName , Toast.LENGTH_SHORT).show();

            try {
                String img_url = account.getPhotoUrl().toString();
                if(img_url!=null) {
                }
                //Picasso.get().load(img_url).into(profPic);

            }catch (Exception e){
                if (e != null) {
                }
                //profPic.setImageResource(R.drawable.googlesdninophotoupld);
            }
        }
        else
            Toast.makeText(LoginPresenter.this,"Login Failed, Please Try Again!",Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==reqCode){
            GoogleSignInResult  result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }

    }
}

