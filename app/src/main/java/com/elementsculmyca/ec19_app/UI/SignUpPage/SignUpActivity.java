package com.elementsculmyca.ec19_app.UI.SignUpPage;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.LoginScreen.FragmentOtpChecker;
import com.elementsculmyca.ec19_app.UI.LoginScreen.LoginActivity;
import com.elementsculmyca.ec19_app.UI.MainScreen.MainScreenActivity;

import java.util.ArrayList;
import java.util.List;

import static com.elementsculmyca.ec19_app.UI.LoginScreen.FragmentOtpChecker.REQUEST_ID_MULTIPLE_PERMISSIONS;

public class SignUpActivity extends AppCompatActivity implements FragmentOtpChecker.otpCheckStatus  {
    TextView login,guest;
    ImageView submit;
    EditText userName,userCollege,userPhone;
    private ProgressDialog mProgress;
    private String musername;
    private String muserphone;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login=findViewById(R.id.tv_login);
        submit=findViewById(R.id.submit);
        guest=findViewById(R.id.tv_guest);
        userName=findViewById(R.id.name);
        userCollege=findViewById(R.id.college);
        userPhone=findViewById(R.id.phone_number);
        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Registering You");
        mProgress.setTitle("Please Wait");
        mProgress.setCanceledOnTouchOutside(false);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,MainScreenActivity.class));
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checker = validateCredentials();
                if (checker) {
                    mProgress.show();
                    checkOTP();
                    sharedPreferences=getSharedPreferences("login_details",0);
                    musername = userName.getText().toString();
                    muserphone= userPhone.getText().toString();
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("Username",musername);
                    editor.putString("UserPhone",muserphone);
                    editor.commit();
                }
            }
        });
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void checkOTP() {
        checkAndRequestPermissions();
        if(ContextCompat.checkSelfPermission(SignUpActivity.this, android.Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED){
            FragmentManager fm = getFragmentManager();
            FragmentOtpChecker otpChecker = new FragmentOtpChecker();
            Bundle bundle = new Bundle();
            bundle.putString("phone", userPhone.getText().toString());
            otpChecker.setArguments(bundle);
            otpChecker.show(fm, "otpCheckerFragment");
        }
        mProgress.dismiss();
    }
    private void checkAndRequestPermissions() {
        int receiveSMS = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.RECEIVE_SMS);

        int readSMS = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_SMS);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (receiveSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.RECEIVE_MMS);
        }
        if (readSMS != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.READ_SMS);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
                    REQUEST_ID_MULTIPLE_PERMISSIONS);
        }
    }
    private Boolean validateCredentials() {
        if (!isNetworkAvailable()) {
            Toast.makeText(SignUpActivity.this, "Check your Internet Connection", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (userName.getText().toString().equals("")) {
            userName.setError("Enter a User Name");
            return false;
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
        if (userCollege.getText().toString().equals("")) {
            userCollege.setError("Enter a College Name");
            return false;
        }
        return true;
    }

    @Override
    public void updateResult(boolean status) {
        if (status) {
            startActivity(new Intent(SignUpActivity.this,MainScreenActivity.class));
            finish();
        } else {
            mProgress.dismiss();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_ID_MULTIPLE_PERMISSIONS){

            FragmentManager fm = getFragmentManager();
            FragmentOtpChecker otpChecker = new FragmentOtpChecker();
            Bundle bundle = new Bundle();
            bundle.putString("phone", userPhone.getText().toString());
            otpChecker.setArguments(bundle);
            otpChecker.show(fm, "otpCheckerFragment");
        }
    }
}
