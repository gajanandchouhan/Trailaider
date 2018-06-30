package com.trailaider.app.ui.activity.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trailaider.app.ui.fragment.courses.CourseFrament;
import com.trailaider.app.ui.fragment.review.ReviewFrament;
import com.trailaider.app.ui.fragment.trek.TrekFrament;

/**
 * Created by Divya on 21-11-2017.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {


    public HomePagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ReviewFrament.newInstance();
            case 1:
                return TrekFrament.newInstance();
            case 2:
                return CourseFrament.newInstance();
        }
        return ReviewFrament.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "REVIEWS";
            case 1:
                return "MY TREKS";
            case 2:
                return "COURSES";
        }
        return super.getPageTitle(position);
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
