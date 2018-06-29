package com.trailaider.app.ui.activity.walking;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.courses.CourseDataModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

/**
 * Created by gajanand on 14/1/18.
 */

public class PreWalkingActivity extends BaseActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private LoginResponseData loginData;
    private Handler handler;
    private TextView textViewWeekDay;
    private TextView textViewAction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_walking);
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        handler = new Handler();
        handler.postDelayed(runnable, 3000);
        Bundle bundleExtra = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA);
        CourseDataModel courseDataModel = (CourseDataModel) bundleExtra.getSerializable("data");
        textViewAction.setText(courseDataModel.getHeading());
        textViewWeekDay.setText(String.format("%s %s", bundleExtra.getString("week"), bundleExtra.getString("day")));
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            CommonUtils.startActivity(PreWalkingActivity.this, WalkingActivity.class, getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA), false);
            finish();
        }
    };

    @Override
    public void initializePresneter() {

    }

    @Override
    public void onBackPressed() {
        handler.removeCallbacks(runnable);
        super.onBackPressed();
    }

    @Override
    public void initializeView() {
        textViewWeekDay = findViewById(R.id.textView_week_day);
        textViewAction = findViewById(R.id.textView_action);
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
