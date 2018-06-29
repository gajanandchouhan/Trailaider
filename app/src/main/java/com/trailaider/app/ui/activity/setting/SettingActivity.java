package com.trailaider.app.ui.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.profile.ProfilePresenter;
import com.trailaider.app.ui.activity.profile.ProfileView;
import com.trailaider.app.ui.activity.siginin.SignInActivity;
import com.trailaider.app.ui.dialog.SelectionListDialog;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by gajanand on 17/1/18.
 */

public class SettingActivity extends BaseActivity {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private TextView textViewTitle, textViewUnit;
    private SwitchCompat switchCompat;
    private LoginResponseData loginData;
    private ProfilePresenter presenter;
    private ArrayList<String> list;
    private String currentUnit;
    private String height;
    private String weight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle.setText(getString(R.string.setting));
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        currentUnit = loginData.getUnit();
        height = loginData.getHeight();
        weight = loginData.getWeight();
        textViewUnit.setText(currentUnit);
        if (loginData.getIsNotificationOn().equalsIgnoreCase("1"))
            switchCompat.setChecked(true);
        else
            switchCompat.setChecked(false);

    }

    private void convertUnit(String unit) {
        switch (unit) {
            case ConstantLib.UNIT_IMPERIAL:

                if (!weight.isEmpty()) {
                    weight = CommonUtils.kgsToLbs(weight.replace(" kgs", ""));
                }

                if (!height.isEmpty()) {
                    height = CommonUtils.centimeterToFeet(height.replace(" cm", ""));
                }
                break;

            case ConstantLib.UNIT_METRIC:
                if (!weight.isEmpty()) {
                    weight = CommonUtils.lbsToKgs(weight.replace(" lbs", ""));
                }

                if (!height.isEmpty()) {
                    height = CommonUtils.feetToCm(height);
                }
                break;
        }
    }

    @Override
    public void initializePresneter() {
        presenter = new ProfilePresenter(this);
        presenter.initialiseView(new ProfileView() {
            @Override
            public void setProfileData(LoginResponseData data) {
                TrailaiderPreferences.getInstance().saveLoginData(data);
                textViewUnit.setText(currentUnit);
            }

            @Override
            public void showProgress() {
            }

            @Override
            public void hideProgress() {

            }
        });
    }

    @Override
    public void initializeView() {
        textViewTitle = findViewById(R.id.textView_title);
        findViewById(R.id.cardView_terms_of_use).setOnClickListener(this);
        findViewById(R.id.cardView_privacy_policy).setOnClickListener(this);
        findViewById(R.id.cardView_privacy_seting).setOnClickListener(this);
        findViewById(R.id.cardView_change_passwordd).setOnClickListener(this);
        findViewById(R.id.cardView_logout).setOnClickListener(this);
        findViewById(R.id.cardView_unit).setOnClickListener(this);
        textViewUnit = findViewById(R.id.textView_unit);
        switchCompat = findViewById(R.id.switchCompact);
        switchCompat.setOnClickListener(this);
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
            case R.id.cardView_terms_of_use:
                Intent intent = new Intent(this, TCAndPrivacyActivity.class);
                intent.putExtra("title", getString(R.string.terms_of_use));
                intent.putExtra("text", getString(R.string.tc_text));
                startActivity(intent);
                break;
            case R.id.cardView_privacy_policy:
                Intent intent2 = new Intent(this, TCAndPrivacyActivity.class);
                intent2.putExtra("title", getString(R.string.privacy_policy));
                intent2.putExtra("text", getString(R.string.pp));
                startActivity(intent2);
                break;
            case R.id.cardView_privacy_seting:
                CommonUtils.startActivity(this, PrivacySettingActivity.class);
                break;

            case R.id.cardView_change_passwordd:
                CommonUtils.startActivity(this, ChangePasswordActivity.class);
                break;
            case R.id.cardView_logout:
                TrailaiderPreferences.getInstance().cleaAll();
                CommonUtils.startActivity(this, SignInActivity.class, null, true);
                break;
            case R.id.switchCompact:
                onOfNotification();
                break;
            case R.id.cardView_unit:
                showUnitSelecttion();
                break;
        }
    }

    private void showUnitSelecttion() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(ConstantLib.UNIT_IMPERIAL);
            list.add(ConstantLib.UNIT_METRIC);
        }
        new SelectionListDialog(this, list, new SelectionListDialog.SelectedListner<String>() {
            @Override
            public void onSelected(int position, String object) {
                if (currentUnit != null && !currentUnit.equalsIgnoreCase(object)) {
                    currentUnit = object;
                    convertUnit(currentUnit);
                    onOfNotification();
                }


            }
        }).show();
    }

    private void onOfNotification() {
        HashMap<String, String> stringBody = new HashMap<>();
        stringBody.put("firstname", loginData.getFirstname());
        stringBody.put("lastname", loginData.getLastname());
        stringBody.put("unit", currentUnit);
        stringBody.put("height", height);
        stringBody.put("weight", weight);
        stringBody.put("dob", loginData.getDob());
        stringBody.put("city", loginData.getCity());
        stringBody.put("pincode", loginData.getCity());
        stringBody.put("user_id", loginData.getId());
        stringBody.put("email", loginData.getEmail());
        stringBody.put("phone_no", loginData.getPhoneNo());
        stringBody.put("gender", loginData.getGender());
        stringBody.put("is_notification_on", switchCompat.isChecked() ? "1" : "0");
        presenter.updateProfile(stringBody, null);

    }
}
