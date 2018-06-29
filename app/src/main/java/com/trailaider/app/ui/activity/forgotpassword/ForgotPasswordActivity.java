package com.trailaider.app.ui.activity.forgotpassword;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.trailaider.app.R;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.utils.CommonUtils;

import java.util.HashMap;

public class ForgotPasswordActivity extends BaseActivity implements ForgotPasswordView {
    private EditText editTextEmail;
    private ForgetPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
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
        editTextEmail = findViewById(R.id.edit_text_email);
        findViewById(R.id.button_submit).setOnClickListener(this);
    }

    private void validateFotgotPassword() {
        String email = editTextEmail.getText().toString().trim();
        if (email.isEmpty()) {
            editTextEmail.setError(getString(R.string.enter_email));
            return;
        }
        if (!CommonUtils.isValidEmail(email)) {
            editTextEmail.setError(getString(R.string.enter_email_valid));
            return;
        }
        HashMap<String, String> body = new HashMap<>();
        body.put("email", email);
        presenter.doForgetPassword(body);
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
        CommonUtils.startActivity(this,ResetPasswordActivity.class);
    }

    @Override
    public void onResetSuccess() {

    }
}
