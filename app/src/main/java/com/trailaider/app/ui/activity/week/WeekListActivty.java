package com.trailaider.app.ui.activity.week;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.CourseApiContent;
import com.trailaider.app.data.courses.CourseRepository;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.utils.ConstantLib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gajanand on 27/1/18.
 */

public class WeekListActivty extends BaseActivity {
    RecyclerView recyclerView;
    private Toolbar toolbar;
    private CourseRepository courseSections;
    private int age;
    private String gender;
    private int trekHeight;
    private double bmi;
    private List<CourseApiContent> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_list);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.my_course));
        courseSections = new CourseRepository();
        Bundle bundleExtra = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA);
        list = (ArrayList) bundleExtra.getSerializable("data");
        recyclerView.setAdapter(new WeekListAdapter(this, list));
      /*  age = bundleExtra.getInt("age");
        trekHeight = bundleExtra.getInt("trek_height");
        gender = bundleExtra.getString("gender");
        bmi = bundleExtra.getDouble("bmi");
        String noOfWeeks = bundleExtra.getString("week");
        List<WeekModel> list = generateWeekList(Integer.parseInt(noOfWeeks));
        recyclerView.setAdapter(new WeekListAdapter(this, list));
        Log.v("DATA", "age " + age + ", height " + trekHeight + ", BMI " + bmi + ", Gender " + gender);
    */
    }

  /*  public List<WeekModel> generateWeekList(int count) {
        List<WeekModel> list = new ArrayList<>();
        switch (count) {
            case 3:
                for (int i = 1; i <= count; i++) {
                    if (gender.equalsIgnoreCase("male") && age > 15 && age < 46 && trekHeight <= 12000 && bmi > 17 && bmi < 26) {
                        WeekModel weekModel = new WeekModel();
                        weekModel.setWeek("Week " + i);
                        weekModel.setDaysList(courseSections.getCoursesForMaleFor3WeekPart1(i));
                        list.add(weekModel);
                    } else if (gender.equalsIgnoreCase("female") && age > 15 && age < 46 && trekHeight <= 12000 && bmi > 17 && bmi < 26) {
                        WeekModel weekModel = new WeekModel();
                        weekModel.setWeek("Week " + i);
                        weekModel.setDaysList(courseSections.getCoursesForFemaleFor3WeekPart1(i));
                        list.add(weekModel);
                    }

                }
                break;
            case 6:
                for (int i = 1; i <= count; i++) {
                    if (gender.equalsIgnoreCase("male") && age > 15 && age < 46 && trekHeight <= 12000 && bmi > 17 && bmi < 26) {
                        WeekModel weekModel = new WeekModel();
                        weekModel.setWeek("Week " + i);
                        weekModel.setDaysList(courseSections.getCoursesForMaleFor6WeekPart1(i));
                        list.add(weekModel);
                    }
                    else if (gender.equalsIgnoreCase("male") && age > 15 && age < 46 && trekHeight <= 15000 && bmi > 17 && bmi < 26) {
                        WeekModel weekModel = new WeekModel();
                        weekModel.setWeek("Week " + i);
                        weekModel.setDaysList(courseSections.getCoursesForMaleFor6WeekPart2(i));
                        list.add(weekModel);
                    }else if (gender.equalsIgnoreCase("female") && age > 15 && age < 46 && trekHeight <= 12000 && bmi > 17 && bmi < 26) {
                        WeekModel weekModel = new WeekModel();
                        weekModel.setWeek("Week " + i);
                        weekModel.setDaysList(courseSections.getCoursesForFemaleFor6WeekPart1(i));
                        list.add(weekModel);
                    }
                   *//* else if (gender.equalsIgnoreCase("female") && age > 15 && age < 46 && trekHeight <= 15000 && bmi > 17 && bmi < 26) {
                        WeekModel weekModel = new WeekModel();
                        weekModel.setWeek("Week " + i);
                        weekModel.setDaysList(courseSections.getCoursesForFemaleFor6WeekPart2(i));
                        list.add(weekModel);
                    }*//*


                }
                break;
        }

        return list;
    }*/

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
