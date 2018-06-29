package com.trailaider.app.ui.activity.day;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.courses.CourseDataModel;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.week.WeekListAdapter;
import com.trailaider.app.utils.ConstantLib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gajanand on 27/1/18.
 */

public class DayListActivty extends BaseActivity {
    RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView textViewWeek;
    private List<CourseDataModel> daysList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_list);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.my_course));
        Bundle bundleExtra = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA);
        String noOfWeeks = bundleExtra.getString("week");
        daysList= (List<CourseDataModel>) bundleExtra.getSerializable("day_list");
        textViewWeek.setText(noOfWeeks);
//        List<String> list = generateWeekList(7);
        recyclerView.setAdapter(new DayListAdapter(this,daysList,noOfWeeks));
    }

    public List<String> generateWeekList(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add("Day " + i);
        }
        return list;
    }

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textViewWeek=findViewById(R.id.textView_week);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
