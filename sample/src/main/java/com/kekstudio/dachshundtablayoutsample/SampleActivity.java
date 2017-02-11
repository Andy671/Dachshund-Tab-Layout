package com.kekstudio.dachshundtablayoutsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.kekstudio.dachshundtablayout.indicators.DachshundIndicator;
import com.kekstudio.dachshundtablayout.indicators.LineMoveIndicator;
import com.kekstudio.dachshundtablayout.indicators.PointMoveIndicator;


public class SampleActivity extends AppCompatActivity {

    private static final String DOG_BREEDS[] = {"Pug", "Beagle", "Bulldog", "Poodle"};

    private ViewPager viewPager;
    private DachshundTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        tabLayout = (DachshundTabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onClickDachshund(View view){
        tabLayout.setAnimatedIndicator(new DachshundIndicator(tabLayout));
    }

    public void onClickPointMove(View view){
        tabLayout.setAnimatedIndicator(new PointMoveIndicator(tabLayout));
    }

    public void onClickPointMoveAccelerate(View view){
        PointMoveIndicator pointMoveIndicator = new PointMoveIndicator(tabLayout);
        pointMoveIndicator.setInterpolator(new AccelerateInterpolator());
        tabLayout.setAnimatedIndicator(pointMoveIndicator);
    }

    public void onClickLineMove(View view){
        tabLayout.setAnimatedIndicator(new LineMoveIndicator(tabLayout));
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return new PageFragment();
        }

        @Override
        public int getCount() {
            return DOG_BREEDS.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return DOG_BREEDS[position];
        }
    }

    public static class PageFragment extends Fragment {

        public PageFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_page, container, false);
        }
    }

}
