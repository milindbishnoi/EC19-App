package com.elementsculmyca.ec19_app.UI.MainScreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.UI.BookmarksPage.BookmarksFragment;
import com.elementsculmyca.ec19_app.UI.DeveloperPage.DeveloperFragment;
import com.elementsculmyca.ec19_app.UI.HomePage.HomeFragment;
import com.elementsculmyca.ec19_app.UI.LoginScreen.LoginActivity;
import com.elementsculmyca.ec19_app.UI.aboutPage.AboutBaseFragment;

public class MainScreenActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//fragments attached
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
                    SharedPreferences preferences =getSharedPreferences("login_details",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();
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
        manager.beginTransaction().replace(R.id.frame, new BookmarksFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
