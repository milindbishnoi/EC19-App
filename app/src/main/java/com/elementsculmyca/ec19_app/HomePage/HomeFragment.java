package com.elementsculmyca.ec19_app.HomePage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elementsculmyca.ec19_app.R;
import com.elementsculmyca.ec19_app.aboutPage.AboutBaseFragment;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate( R.layout.fragment_main_screen, container, false );
        return root;

    }
}
