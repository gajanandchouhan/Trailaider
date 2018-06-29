package com.trailaider.app.ui.activity.otp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.EditText;

import com.trailaider.app.R;
import com.trailaider.app.TrailaiderApp;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.profile.ProfileActivity;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;

public class OtpVerificationActivity extends BaseActivity implements OtpVerificationView {

    private static final int CODE_SMS_PERMISSION = 101;
    EditText editTextOtp;
    private String otp;
    private String mobile;
    private String userId;
    private OtpVerificationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        initializePresneter();
        initializeView();
        Bundle bundleExtra = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA);
        mobile = bundleExtra.getString("mobile");
        otp = bundleExtra.getString("otp");
        userId = bundleExtra.getString("user_id");
        editTextOtp.setText(otp);
        if (!CommonUtils.hasPermissions(this, ConstantLib.PERMISSION_SMS)) {
            ActivityCompat.requestPermissions(this, ConstantLib.PERMISSION_SMS, CODE_SMS_PERMISSION);
        }

    }

    @Override
    public void initializePresneter() {
        presenter = new OtpVerificationPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        editTextOtp = findViewById(R.id.edit_otp);
        findViewById(R.id.button_submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.button_submit:
                verifyOtp();
                break;
        }
    }

    private void verifyOtp() {
        if (otp.length() > 4) {
            editTextOtp.setError("Please enter a valid otp.");
            return;
        }
        HashMap<String, String> body = new HashMap<>();
        body.put("user_id", userId);
        body.put("otp", editTextOtp.getText().toString().trim());
        presenter.verifyOtp(body);
    }

    @Override
    public void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("otp"));
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                final String message = intent.getStringExtra("message");
            }
        }
    };

    @Override
    public void onVerifySuccess() {
        TrailaiderPreferences.getInstance().putBoolean(TrailaiderPreferences.IS_LOGGED_IN,true);
        CommonUtils.startActivity(this, ProfileActivity.class, null, true);
    }
}
