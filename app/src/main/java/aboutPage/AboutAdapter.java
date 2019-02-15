package aboutPage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class AboutAdapter extends FragmentStatePagerAdapter {

    int noOfPage = 2;

    public AboutAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0 : return new AboutCulmyca();
            case 1 : return new AboutYMCA();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return noOfPage;
    }
}
