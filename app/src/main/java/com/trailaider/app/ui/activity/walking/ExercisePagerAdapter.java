package com.trailaider.app.ui.activity.walking;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trailaider.app.ui.fragment.friends.FriendListFragment;
import com.trailaider.app.ui.fragment.friends.FriendRequestFragment;
import com.trailaider.app.ui.fragment.review.ReviewFrament;

/**
 * Created by Divya on 21-11-2017.
 */

public class ExercisePagerAdapter extends FragmentPagerAdapter {


    public ExercisePagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ExerciseListFragment.newInstance();
            case 1:
                return ExerciseListFragment.newInstance();

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
                return "EXERCISES";
            case 1:
                return "STRETCHING";

        }
        return super.getPageTitle(position);
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
