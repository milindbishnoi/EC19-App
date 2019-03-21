package com.elementsculmyca.ec19_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class DayAdapter extends FragmentStatePagerAdapter {
    private static final int TOTAL_PAGES = 3;


    public DayAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public int getCount() {
        return TOTAL_PAGES;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new Day1Fragment();
            case 1:
                return new Day2Fragment();
            case 2:
                return new Day3Fragment();
        }

        return null;
    }
}
