package com.elementsculmyca.ec19_app.UI.aboutPage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AboutAdapter extends FragmentStatePagerAdapter {

    private static final int TOTAL_PAGES = 2;

    public AboutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AboutYmca();
            case 1:
                return new AboutCulmyca();

            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return TOTAL_PAGES;
    }

}
