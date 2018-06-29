package com.trailaider.app.ui.activity.mypoint;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.friend.FriendListAdapter;
import com.trailaider.app.ui.activity.home.HomePagerAdapter;
import com.trailaider.app.ui.custom.FontCache;
import com.trailaider.app.ui.custom.FontTypes;

/**
 * Created by gajanand on 17/1/18.
 */

public class MyPointActivity extends BaseActivity {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private TabLayout tabLayout;
    private ViewPager pager;
    private MyPointPagerAdapter pagerAdapter;
    TextView textViewTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypoint);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tab_layout);
        textViewTitle=findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.my_points));
        pager = findViewById(R.id.pager);
        setupViewPager(pager);
        tabLayout.setupWithViewPager(pager);
        changeTabsFont();
    }

    private void setupViewPager(ViewPager pager) {
        pagerAdapter = new MyPointPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }


    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {

    }

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
}
