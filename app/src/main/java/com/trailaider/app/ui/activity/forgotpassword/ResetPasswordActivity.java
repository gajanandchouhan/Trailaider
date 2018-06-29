package com.trailaider.app.ui.activity.forgotpassword;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.trailaider.app.R;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.siginin.SignInActivity;
import com.trailaider.app.utils.CommonUtils;

import java.util.HashMap;

public class ResetPasswordActivity extends BaseActivity implements ForgotPasswordView {
    private EditText editTextOtp, editTextNewPass, editTextConfirmNewPass;
    private ForgetPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initializeView();
        initializePresneter();
    }

    @Override
    public void initializePresneter() {
        presenter = new ForgetPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        editTextOtp = findViewById(R.id.edit_otp);
        editTextNewPass = findViewById(R.id.edit_newpass);
        editTextConfirmNewPass = findViewById(R.id.edit_confirm_newpass);
        findViewById(R.id.button_submit).setOnClickListener(this);
    }

    private void validateFotgotPassword() {
        String otp = editTextOtp.getText().toString().trim();
        String newPass = editTextNewPass.getText().toString().trim();
        String confirmNewPass = editTextConfirmNewPass.getText().toString().trim();
        if (otp.isEmpty()) {
            editTextOtp.setError("Please enter verification code.");
            return;
        }
        if (newPass.length() < 6) {
            editTextNewPass.setError(getString(R.string.password_length));
            return;
        }
        if (!CommonUtils.isLegalPassword(newPass)) {
            editTextNewPass.setError(getString(R.string.password_validation));
            return;
        }
        if (confirmNewPass.isEmpty()) {
            editTextConfirmNewPass.setError(getString(R.string.enter_confrim_pass));
            return;
        }
        if (!newPass.equals(confirmNewPass)) {
            editTextConfirmNewPass.setError(getString(R.string.password_not_match));
            return;
        }
        HashMap<String, String> body = new HashMap<>();
        body.put("new_password", newPass);
        body.put("password_token", otp);
        presenter.resetPassword(body);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.button_submit:
                validateFotgotPassword();
                break;
        }
    }

    @Override
    public void onForgotPasswordSuccess() {

    }

    @Override
    public void onResetSuccess() {
        CommonUtils.startActivity(this, SignInActivity.class, null, true);
    }
}
