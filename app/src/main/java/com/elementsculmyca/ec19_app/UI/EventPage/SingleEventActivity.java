package com.elementsculmyca.ec19_app.UI.EventPage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.elementsculmyca.ec19_app.R;

public class SingleEventActivity extends AppCompatActivity {
    TextView registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        registerButton=findViewById(R.id.register);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame, new DescriptionEventFragment()).commit();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(registerButton.getText().equals("Register Now!")) {
                    registerButton.setText("View Details");
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.frame, new RegisterEventFragment()).commit();
                }else{
                    registerButton.setText("Register Now!");
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.frame, new DescriptionEventFragment()).commit();
                }
            }
        });
    }
}
