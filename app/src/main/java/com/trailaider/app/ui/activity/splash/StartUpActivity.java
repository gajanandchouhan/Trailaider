package com.trailaider.app.ui.activity.splash;

import android.os.Bundle;
import android.view.View;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.home.MainActivity;
import com.trailaider.app.ui.activity.profile.ProfileActivity;
import com.trailaider.app.ui.activity.siginin.SignInActivity;
import com.trailaider.app.ui.activity.signup.SignupActivity;
import com.trailaider.app.utils.CommonUtils;

public class StartUpActivity extends BaseActivity implements SplasView {


    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        initializeView();
        initializePresneter();
        LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();
//        presenter.delaySplash();
        CommonUtils.printHashKey(this);
        if (TrailaiderPreferences.getInstance().getBoolean(TrailaiderPreferences.IS_LOGGED_IN) && loginData != null) {
            CommonUtils.startActivity(this, MainActivity.class);
            finish();
        }
    }

    @Override
    public void initializePresneter() {
        presenter = new SplashPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        findViewById(R.id.button_create).setOnClickListener(this);
        findViewById(R.id.button_login).setOnClickListener(this);
    }


    @Override
    public void startNextActivity() {
        CommonUtils.startActivity(this, SignupActivity.class);
        finish();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.button_create:
                CommonUtils.startActivity(this, SignupActivity.class);
                break;
            case R.id.button_login:
                CommonUtils.startActivity(this, SignInActivity.class);
                break;
        }
    }
}
