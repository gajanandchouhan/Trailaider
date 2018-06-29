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

public class SplashActivity extends BaseActivity implements SplasView {


    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initializeView();
        initializePresneter();
        presenter.delaySplash();
        CommonUtils.printHashKey(this);

    }

    @Override
    public void initializePresneter() {
        presenter = new SplashPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
    }


    @Override
    public void startNextActivity() {
        LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();

        if (TrailaiderPreferences.getInstance().getBoolean(TrailaiderPreferences.IS_LOGGED_IN) && loginData != null) {
            if (TrailaiderPreferences.getInstance().getProfileVisited()) {
                CommonUtils.startActivity(this, MainActivity.class);
            } else {
                CommonUtils.startActivity(this, ProfileActivity.class);
            }

            finish();
        } else {
            CommonUtils.startActivity(this, StartUpActivity.class);
            finish();
        }
    }


}
