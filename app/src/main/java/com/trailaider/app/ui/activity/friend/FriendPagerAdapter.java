package com.trailaider.app.ui.activity.friend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trailaider.app.ui.fragment.courses.CourseFrament;
import com.trailaider.app.ui.fragment.friends.FriendListFragment;
import com.trailaider.app.ui.fragment.friends.FriendRequestFragment;
import com.trailaider.app.ui.fragment.review.ReviewFrament;
import com.trailaider.app.ui.fragment.trek.TrekFrament;

/**
 * Created by Divya on 21-11-2017.
 */

public class FriendPagerAdapter extends FragmentPagerAdapter {


    public FriendPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FriendListFragment.newInstance();
            case 1:
                return FriendRequestFragment.newInstance();

        }
        return ReviewFrament.newInstance();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "FRIENDS";
            case 1:
                return "PENDING REQUESTS";

        }
        return super.getPageTitle(position);
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
