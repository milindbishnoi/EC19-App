package com.elementsculmyca.ec19_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutActivity extends FragmentActivity {
    private static final int TOTAL_PAGES = 2;

    private ViewPager abtviewPager;
    private PagerAdapter abtViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        abtviewPager = (ViewPager) findViewById(R.id.about_viewpager);
        abtViewPagerAdapter = new AboutAdapter(getSupportFragmentManager());
        abtviewPager.setAdapter(abtViewPagerAdapter);
        abtviewPager.addOnPageChangeListener(viewPagerPageChangeListener);

    }
    @Override
    public void onBackPressed(){
        if(abtviewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }
        else {
            abtviewPager.setCurrentItem(abtviewPager.getCurrentItem() -1);
        }
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private class AboutAdapter extends FragmentStatePagerAdapter{
        public AboutAdapter(FragmentManager fm){
            super(fm);
        }

        public Fragment getItem(int position){
            switch (position) {
                case 0:
                    return new aboutYmcaFragment();
                case 1:
                    return new aboutECFragment();

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

}
