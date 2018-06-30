package com.trailaider.app.ui.activity.mypoint;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trailaider.app.ui.fragment.courses.CourseFrament;
import com.trailaider.app.ui.fragment.debitpoint.DebitPointFragment;
import com.trailaider.app.ui.fragment.earnpoints.EarnPointFragment;
import com.trailaider.app.ui.fragment.review.ReviewFrament;
import com.trailaider.app.ui.fragment.trek.TrekFrament;

/**
 * Created by Divya on 21-11-2017.
 */

public class MyPointPagerAdapter extends FragmentPagerAdapter {


    public MyPointPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return EarnPointFragment.newInstance();
            case 1:
                return DebitPointFragment.newInstance();
        }
        return EarnPointFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "EARN POINTS";
            case 1:
                return "DEBIT POINTS";
        }
        return super.getPageTitle(position);
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
