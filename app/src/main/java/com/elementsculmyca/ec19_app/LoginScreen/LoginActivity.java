package com.elementsculmyca.ec19_app.LoginScreen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.MainScreen.MainScreenActivity;
import com.elementsculmyca.ec19_app.R;

public class LoginActivity extends Activity {
    TextView guestLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        Window window = getWindow();
        window.clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        window.addFlags( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
        String color = "#0f0f0f";
        window.setStatusBarColor( Color.parseColor( color ) );


        //TODO : OTP VALA CODE KRNA HAH ISME USER KO OTP JAE VERIFY HOKAR LOGIN
        guestLogin = findViewById( R.id.button_guest );

        guestLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( LoginActivity.this, MainScreenActivity.class ) );
            }
        } );
    }
}
