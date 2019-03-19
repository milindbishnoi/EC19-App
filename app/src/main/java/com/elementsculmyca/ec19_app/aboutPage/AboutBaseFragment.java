package com.elementsculmyca.ec19_app.aboutPage;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elementsculmyca.ec19_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutBaseFragment extends Fragment {


    ViewPager viewPager;
    ImageView goback, leftPage, rightPage;
    ViewPager.OnPageChangeListener onchange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            check();
        }

        @Override
        public void onPageSelected(int i) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    public AboutBaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_about_base, container, false );
        viewPager = root.findViewById( R.id.viewpager );

        leftPage = root.findViewById( R.id.page1 );
        rightPage = root.findViewById( R.id.page2 );
        AboutAdapter adapter = new AboutAdapter(getChildFragmentManager());
        viewPager.setAdapter( adapter );
         viewPager.addOnPageChangeListener(onchange);
      check();
        leftPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0,true);

            }
        });
        rightPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,true);
            }
        });


        return root;

    }
    private int getCurrItem() {
        return viewPager.getCurrentItem();
    }


    void check() {
        if (viewPager.getCurrentItem() == 0) {
            leftPage.setVisibility( View.INVISIBLE );
            rightPage.setVisibility( View.VISIBLE );
        } else if (viewPager.getCurrentItem() == 1) {
            leftPage.setVisibility( View.VISIBLE );
            rightPage.setVisibility( View.INVISIBLE );
        }
    }

   // private class WizardPagerAdapter extends PagerAdapter {

     //   public WizardPagerAdapter(FragmentManager childFragmentManager) {

       // }

        //@//Override
       // public int getCount() {
       //     return 2;
        //}

        //public Object instantiateItem(ViewGroup collection, int position) {
//
  //          int resId = 0;
    //        switch (position) {
      //          case 0:
        //            return new AboutYmca();
         //       case 1:
         //           return new AboutCulmyca();
         //   }
        //   return null;
     //   }





   //     @Override
    //    public boolean isViewFromObject(View arg0, Object arg1) {
      //      return arg0 == arg1;
        //}

        //@Override
        //public void destroyItem(ViewGroup container, int position, Object object) {
            // No super
      //  }
    //}

}
