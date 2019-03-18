package com.elementsculmyca.ec19_app.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.SingleEventScreen.SingleEventActivity;
import com.elementsculmyca.ec19_app.aboutPage.AboutBaseFragment;

public class HomeFragment extends Fragment {
    Button day1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate( R.layout.fragment_main_screen, container, false );
        day1=root.findViewById(R.id.btn_day1);
        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SingleEventActivity.class));
            }
        });
        return root;

    }
}
