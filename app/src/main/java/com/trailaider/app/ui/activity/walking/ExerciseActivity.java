package com.trailaider.app.ui.activity.walking;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.Session2Data;
import com.trailaider.app.data.courses.ExerciseModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.custom.FontCache;
import com.trailaider.app.ui.custom.FontTypes;
import com.trailaider.app.utils.ConstantLib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gajanand on 14/1/18.
 */

public class ExerciseActivity extends BaseActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private LoginResponseData loginData;
    private Handler handler;
    private TextView textViewWeekDay;
    private TabLayout tabLayout;
    private ViewPager pager;
    private ExercisePagerAdapter pagerAdapter;
    private List<Session2Data> exerciseModelList;
    private List stretchingModelList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Bundle bundleExtra = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA);
        stretchingModelList = new ArrayList();
        exerciseModelList = (List<Session2Data>) bundleExtra.getSerializable("data");
        pager.post(new Runnable() {
            @Override
            public void run() {
                listener.onPageSelected(0);
            }
        });
//        textViewWeekDay.setText(String.format("%s %s", bundleExtra.getString("week"), bundleExtra.getString("day")));
    }


    @Override
    public void initializePresneter() {

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    public void initializeView() {
        tabLayout = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.pager);
        setupViewPager(pager);
        tabLayout.setupWithViewPager(pager);
        changeTabsFont();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void setupViewPager(ViewPager pager) {
        pagerAdapter = new ExercisePagerAdapter(getSupportFragmentManager());
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
                    if (exerciseModelList != null) {
                        ExerciseListFragment exerciseListFragment = (ExerciseListFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" +
                                R.id.pager + ":" + pager.getCurrentItem());
                        exerciseListFragment.setList(exerciseModelList);
                    }
                    break;
                case 1:

                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {

        }
    }


}
