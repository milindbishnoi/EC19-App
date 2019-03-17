package com.elementsculmyca.ec19_app.MainScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.HomePage.HomeFragment;
import com.elementsculmyca.ec19_app.LoginScreen.LoginActivity;
import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.aboutPage.AboutBaseFragment;

public class MainScreenActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchToFragmentHome();
                    break;
                case R.id.navigation_about:
                    switchToFragmentAbout();
                    break;
                case R.id.navigation_logout:
                    startActivity(new Intent(MainScreenActivity.this,LoginActivity.class));
                    finish();
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_screen );
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener );
    }
    public void switchToFragmentHome() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
    }

    private void switchToFragmentAbout() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, new AboutBaseFragment()).commit();
    }



}
