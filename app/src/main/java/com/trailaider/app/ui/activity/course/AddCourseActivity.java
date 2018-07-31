package com.trailaider.app.ui.activity.course;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.CourseApiResponse;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.week.WeekListActivty;
import com.trailaider.app.ui.dialog.HeightPicker;
import com.trailaider.app.ui.dialog.SelectionListDialog;
import com.trailaider.app.ui.dialog.WeightPicker;
import com.trailaider.app.ui.fragment.courses.CoursePresenter;
import com.trailaider.app.ui.fragment.courses.CourseView;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 14/1/18.
 */

public class AddCourseActivity extends BaseActivity implements CourseView {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private EditText editTextAge, editTextTrekHeight;
    private RadioGroup radioGroupCourseDuration;
    private TextView editTextWeight, editTextHeight, editTextDuration;
    private LoginResponseData loginData;
    private TextView editTextBmi;
    private String unit;
    private TextView textViewUnit;
    private int age;
    private int trekHeght;
    private double bmi;
    private CoursePresenter presenter;
//    For men: maximum heart rate = 220-age of the man user
//    For women: max heart rate = 206 - age of woman user


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.button_generate_course).setOnClickListener(this);
        String height = loginData.getHeight();
        String weight = loginData.getWeight();
        if (loginData.getUnit().equalsIgnoreCase(ConstantLib.UNIT_IMPERIAL)) {
            unit = "ft";
            textViewUnit.setText(unit);
            String weightInkg = CommonUtils.lbsToKgs(weight.replace(" lbs", "")).replace(" kgs", "");
            String heighInCM = CommonUtils.feetToCm(height).replace(" cm", "");
            double heghtInM = Double.parseDouble(heighInCM) / 100;
            bmi = (Double.parseDouble(weightInkg) / heghtInM) / heghtInM;
            long round = Math.round(bmi);
            editTextBmi.setText(new DecimalFormat("##.##").format(bmi));
        } else {
            unit = "m";
            textViewUnit.setText(unit);
            String weightInkg = weight.replace(" kgs", "");
            String heighInCM = height.replace(" cm", "");
            double heghtInM = Double.parseDouble(heighInCM) / 100;
            bmi = (Double.parseDouble(weightInkg) / heghtInM) / heghtInM;
            editTextBmi.setText(new DecimalFormat("##.##").format(bmi));
        }

        String dob = loginData.getDob();
        age = CommonUtils.getAge(dob);
        Log.v("AGE", "" + age);

    }

    @Override
    public void initializePresneter() {
        presenter = new CoursePresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        editTextAge = findViewById(R.id.edit_text_age);
        editTextHeight = findViewById(R.id.edit_text_height);
        editTextWeight = findViewById(R.id.edit_text_weight);
        editTextDuration = findViewById(R.id.edit_text_trek_duration);
        textViewUnit = findViewById(R.id.textView_unit);
        editTextBmi = findViewById(R.id.edit_bmi);
        editTextTrekHeight = findViewById(R.id.edit_text_trek_height);
        radioGroupCourseDuration = findViewById(R.id.radio);
        findViewById(R.id.button_generate_course).setOnClickListener(this);
        editTextHeight.setOnClickListener(this);
        editTextWeight.setOnClickListener(this);
        editTextDuration.setOnClickListener(this);

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
            case R.id.button_generate_course:
                validateAndGenerate();
                break;
            case R.id.edit_text_weight:
                showWeightPicker();
                break;
            case R.id.edit_text_height:
                showHeightPicker();
                break;
            case R.id.edit_text_trek_duration:
                showTrekDurationDialog();
                break;

        }
    }


    private void validateAndGenerate() {
        String trekDuration = editTextDuration.getText().toString().trim();
        String trekHeight = editTextTrekHeight.getText().toString().trim();
        String courseDuration = getCourseDuration();

        if (trekDuration.isEmpty()) {
            CommonUtils.showToast(this, getString(R.string.enter_trek_duration));
            return;
        }
        if (trekHeight.isEmpty()) {
            editTextDuration.setError(getString(R.string.enter_trek_height));
            return;
        }

        /*Bundle bundle = new Bundle();
        bundle.putString("week", getCourseDuration());
        bundle.putDouble("bmi", bmi);
        bundle.putInt("age", age);
        bundle.putInt("trek_height", Integer.parseInt(trekHeight));
        bundle.putString("gender", loginData.getGender());
        CommonUtils.startActivity(this, WeekListActivty.class, bundle, false);*/
        HashMap<String, String> params = new HashMap<>();
        params.put("gender", loginData.getGender().toLowerCase().substring(0, 1));
        params.put("altitude", trekHeight);
        params.put("bmi", String.valueOf(bmi));
        params.put("no_of_weeks", courseDuration);
        params.put("age", String.valueOf(age));
        presenter.getCourses(params);
    }


    private String getCourseDuration() {
        switch (radioGroupCourseDuration.getCheckedRadioButtonId()) {
            case R.id.button_3week:
                return "3";
            case R.id.button_6week:
                return "6";
            case R.id.button_9week:
                return "9";
        }
        return "3";
    }

    private void showWeightPicker() {
        String type = TrailaiderPreferences.getInstance().getLoginData().getUnit();
        if (type.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_unit));
            return;
        }
        new WeightPicker(this, type, new WeightPicker.SelectedListner() {
            @Override
            public void onSelected(int position, String object) {
                editTextWeight.setText(object);
            }
        }, editTextWeight.getText().toString().trim()).show();

    }

    private void showHeightPicker() {
        String type = TrailaiderPreferences.getInstance().getLoginData().getUnit();
        if (type.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_unit));
            return;
        }
        new HeightPicker(this, type, new HeightPicker.SelectedListner() {
            @Override
            public void onSelected(int position, String object) {
                editTextHeight.setText(object);
            }
        }, editTextHeight.getText().toString().trim()).show();

    }

    public void showTrekDurationDialog() {
        new SelectionListDialog(this, getListOfDays(), new SelectionListDialog.SelectedListner<String>() {
            @Override
            public void onSelected(int position, String object) {
                editTextDuration.setText(object);
            }
        }).show();
    }

    private List<String> getListOfDays() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            list.add(String.valueOf(i) + " Days");
        }
        return list;
    }

    @Override
    public void setCourseApiResponse(CourseApiResponse baseResponseModel) {
        if (baseResponseModel.getData() != null && baseResponseModel.getData().getCourse_content() != null && baseResponseModel.getData().getCourse_content().size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", (ArrayList) baseResponseModel.getData().getCourse_content());
            CommonUtils.startActivity(this, WeekListActivty.class, bundle, false);
        }
    }
}
