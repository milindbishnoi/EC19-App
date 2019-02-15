package aboutPage;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.elementsculmyca.ec19_app.R;

public class AboutScreen extends AppCompatActivity {
    ViewPager viewPager;
    ImageView goback, leftPage, rightPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about_screen);

        viewPager = findViewById(R.id.viewpager);
        goback = findViewById(R.id.goback);
        leftPage = findViewById(R.id.page1);
        rightPage = findViewById(R.id.page2);
        viewPager.setAdapter(new AboutAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(onchange);

        leftPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        rightPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });


    }

    void check() {
        if (viewPager.getCurrentItem() == 0) {
            leftPage.setVisibility(View.INVISIBLE);
            rightPage.setVisibility(View.VISIBLE);
        } else if (viewPager.getCurrentItem() == 1) {
            leftPage.setVisibility(View.VISIBLE);
            rightPage.setVisibility(View.INVISIBLE);
        }
    }



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
}