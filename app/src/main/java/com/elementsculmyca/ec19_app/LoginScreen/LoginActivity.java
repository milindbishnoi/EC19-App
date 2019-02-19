package com.elementsculmyca.ec19_app.LoginScreen;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.security.auth.callback.Callback;

public class LoginActivity extends AppCompatActivity {
  CallbackManager callbackmanager;
  ProgressDialog progressdialog;
    private static  String facebook_token ;
    private static  String email ;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackmanager.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_presenter);
  callbackmanager=CallbackManager.Factory.create();
        LoginButton loginbutton =findViewById(R.id.facebook_login);

  loginbutton.setReadPermissions(Arrays.asList("public_profile"));
  loginbutton.registerCallback(callbackmanager, new FacebookCallback<LoginResult>() {
      @Override
      public void onSuccess(LoginResult loginResult) {
          progressdialog =new ProgressDialog(LoginActivity.this);
          progressdialog.setMessage("Loging in");
          progressdialog.show();
          facebook_token=loginResult.getAccessToken().getToken();
          GraphRequest request=GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
              @Override
              public void onCompleted(JSONObject object, GraphResponse response) {
progressdialog.dismiss();
                  Log.d("response",response.toString());
getdata(object);
              }
          });
          Bundle parameters=new Bundle();
          parameters.putString("fields","id,email");
          request.setParameters(parameters);
          request.executeAsync();

      }

      @Override
      public void onCancel() {

      }

      @Override
      public void onError(FacebookException error) {

      }
  });

  if(AccessToken.getCurrentAccessToken()!=null)
  {
      Toast.makeText(LoginActivity.this, "already login",Toast.LENGTH_LONG).show();
  }
    }

    private void getdata(JSONObject object) {
        try{
            URL profile_picture=new URL("https://graph.facebook.com/"+object.getString("id")+"/picture?width=250&height=250");
            email=object.getString("email");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
