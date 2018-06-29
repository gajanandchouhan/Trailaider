package com.trailaider.app.ui.activity.friend;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.model.userprofile.UserProfileData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.userprofile.UserProfilePresenter;
import com.trailaider.app.ui.activity.userprofile.UserProfileView;
import com.trailaider.app.ui.custom.FontCache;
import com.trailaider.app.ui.custom.FontTypes;
import com.trailaider.app.ui.fragment.friends.FriendListFragment;
import com.trailaider.app.ui.fragment.friends.FriendRequestFragment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 17/1/18.
 */

public class FriendActivity extends BaseActivity implements UserProfileView {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private TextView textViewTitle;
    private LoginResponseData loginData;
    private UserProfilePresenter presenter;
    private List<FriendModel> list;
    private List<FriendModel> pendingList;
    private TabLayout tabLayout;
    private ViewPager pager;
    private FriendPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.friends));
        getProfile();
    }

    public void getProfile() {
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_id", loginData.getId());
        body.put("my_friends", "1");
        presenter.getUserProfile(body);
    }


    @Override
    public void setUserData(UserProfileData data) {
        if (data != null) {
            list = data.getFriends();
            pendingList = data.getPending_friends();
            listener.onPageSelected(0);
        }
    }

    @Override
    public void onFriendAdded() {

    }

    @Override
    public void initializePresneter() {
        presenter = new UserProfilePresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        tabLayout = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.pager);
        setupViewPager(pager);
        tabLayout.setupWithViewPager(pager);
        changeTabsFont();
    }

    private void setupViewPager(ViewPager pager) {
        pagerAdapter = new FriendPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(listener);
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    if (list != null) {
                        FriendListFragment friendListFragment = (FriendListFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" +
                                R.id.pager + ":" + pager.getCurrentItem());
                        friendListFragment.setFriendData(list);
                    }
                    break;
                case 1:
                    if (pendingList != null) {
                        FriendRequestFragment friendListFragment = (FriendRequestFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" +
                                R.id.pager + ":" + pager.getCurrentItem());
                        friendListFragment.setFriendData(pendingList);
                    }
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    private void changeTabsFont() {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(FontCache.getTypeface(FontTypes.REGULAR, this), Typeface.NORMAL);
                }
            }
        }
    }
public void removeLocal(int pos, FriendModel friendModel,boolean accepted){
        switch (pager.getCurrentItem()){
            case 0:
                list.remove(pos);
                break;
            case 1:
                if (accepted){
                    list.add(friendModel);
                    pagerAdapter.notifyDataSetChanged();
                }
                pendingList.remove(pos);
                break;

        }
}
}
