package com.trailaider.app.ui.activity.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.profile.ProfilePresenter;
import com.trailaider.app.ui.activity.profile.ProfileView;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;

/**
 * Created by gajanand on 17/1/18.
 */

public class PrivacySettingActivity extends BaseActivity {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private ImageView checkBoxPublic, checkBoxFriend, checkBoxMe;
    private TextView textViewTitle;
    private ProfilePresenter presenter;
    private LoginResponseData loginData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_setting);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.privacy_settings));
        loginData=TrailaiderPreferences.getInstance().getLoginData();
        setCheck();
    }

    private void setCheck() {
        switch (loginData.getPrivecy()) {
            case ConstantLib.PROFILE_PUBLIC:
                checkBoxPublic.setSelected(true);
                checkBoxFriend.setSelected(false);
                checkBoxMe.setSelected(false);
                break;
            case ConstantLib.PROFILE_FRIEND:
                checkBoxPublic.setSelected(false);
                checkBoxFriend.setSelected(true);
                checkBoxMe.setSelected(false);
                break;
            case ConstantLib.PROFILE_PRIVATE:
                checkBoxPublic.setSelected(false);
                checkBoxFriend.setSelected(false);
                checkBoxMe.setSelected(true);
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
        checkBoxPublic = findViewById(R.id.checkbox_everyone);
        checkBoxFriend = findViewById(R.id.checkbox_friend);
        checkBoxMe = findViewById(R.id.checkbox_me);
        checkBoxFriend.setOnClickListener(this);
        checkBoxPublic.setOnClickListener(this);
        checkBoxMe.setOnClickListener(this);
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

            case R.id.checkbox_everyone:
                checkBoxPublic.setSelected(true);
                checkBoxFriend.setSelected(false);
                checkBoxMe.setSelected(false);
                updatePrivcy(ConstantLib.PROFILE_PUBLIC);
                break;
            case R.id.checkbox_friend:
                checkBoxPublic.setSelected(false);
                checkBoxFriend.setSelected(true);
                checkBoxMe.setSelected(false);
                updatePrivcy(ConstantLib.PROFILE_FRIEND);
                break;
            case R.id.checkbox_me:
                checkBoxPublic.setSelected(false);
                checkBoxFriend.setSelected(false);
                checkBoxMe.setSelected(true);
                updatePrivcy(ConstantLib.PROFILE_PRIVATE);
                break;

        }
    }

    private void updatePrivcy(String privacy) {
        HashMap<String, String> stringBody = new HashMap<>();
        stringBody.put("firstname", loginData.getFirstname());
        stringBody.put("lastname", loginData.getLastname());
        stringBody.put("unit", loginData.getUnit());
        stringBody.put("height", loginData.getHeight());
        stringBody.put("weight", loginData.getWeight());
        stringBody.put("dob", loginData.getDob());
        stringBody.put("city", loginData.getCity());
        stringBody.put("pincode", loginData.getCity());
        stringBody.put("user_id", loginData.getId());
        stringBody.put("email", loginData.getEmail());
        stringBody.put("phone_no", loginData.getPhoneNo());
        stringBody.put("gender", loginData.getGender());
        stringBody.put("privecy",privacy);
        presenter.updateProfile(stringBody, null);

    }
}
