package com.trailaider.app.ui.activity.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.otp.OtpVerificationActivity;
import com.trailaider.app.ui.activity.siginin.SignInActivity;
import com.trailaider.app.utils.CommonUtils;

import java.util.HashMap;

public class SignupActivity extends BaseActivity implements SignUpView {
    private EditText editTextFirstName, editTextLastName, editTextEmail,
            editTextPassword, editTextCondirmPassword, editTextMobile, editTextPincode,
            editTextCity;

    private SignupPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
        setContentView(R.layout.activity_signup);
        initializeView();
        initializePresneter();
    }

    @Override
    public void initializePresneter() {
        presenter = new SignupPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        editTextFirstName = findViewById(R.id.edit_text_fname);
        editTextLastName = findViewById(R.id.edit_text_lastname);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_pass);
        editTextCondirmPassword = findViewById(R.id.edit_text_confirm_pass);
        editTextMobile = findViewById(R.id.edit_text_phone);
        editTextCity = findViewById(R.id.edit_text_city);
        editTextPincode = findViewById(R.id.edit_text_pincode);
        findViewById(R.id.textView_sigin_in).setOnClickListener(this);
        findViewById(R.id.button_create).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.textView_sigin_in:
                CommonUtils.startActivity(this, SignInActivity.class);
                break;
            case R.id.button_create:
                validateSignup();
                break;
        }
    }

    private void validateSignup() {
        String fName = editTextFirstName.getText().toString().trim();
        String lName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String passwod = editTextPassword.getText().toString().trim();
        String confirmPasswrod = editTextCondirmPassword.getText().toString().trim();
        String mobile = editTextMobile.getText().toString().trim();
        String city = editTextCity.getText().toString().trim();
        String pinCode = editTextPincode.getText().toString().trim();
        if (fName.isEmpty()) {
            editTextFirstName.setError(getString(R.string.enter_firstname));
            return;
        }
        if (email.isEmpty()) {
            editTextEmail.setError(getString(R.string.enter_email));
            return;
        }
        if (!CommonUtils.isValidEmail(email)) {
            editTextEmail.setError(getString(R.string.enter_email_valid));
            return;
        }
        if (passwod.length() < 6) {
            editTextPassword.setError(getString(R.string.password_length));
            return;
        }
        if (!CommonUtils.isLegalPassword(passwod)) {
            editTextPassword.setError(getString(R.string.password_validation));
            return;
        }
        if (confirmPasswrod.isEmpty()) {
            editTextCondirmPassword.setError(getString(R.string.enter_confrim_pass));
            return;
        }
        if (!passwod.equals(confirmPasswrod)) {
            editTextCondirmPassword.setError(getString(R.string.password_not_match));
            return;
        }
        if (mobile.isEmpty()) {
            editTextMobile.setError(getString(R.string.enter_mobile_number));
            return;
        }
        if (mobile.length() < 10) {
            editTextMobile.setError(getString(R.string.enter_valid_mobile_number));
            return;
        }
        if (city.isEmpty()) {
            editTextCity.setError(getString(R.string.enter_city));
            return;
        }

        if (pinCode.isEmpty()) {
            editTextPincode.setError(getString(R.string.enter_pincode));
            return;
        }
        HashMap<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", passwod);
        body.put("device_type", "a");
        body.put("device_token", "fhsdkjfhajsf");
        body.put("firstname", fName);
        body.put("pincode", pinCode);
        body.put("lastname", lName);
        body.put("phone_no", mobile);
        body.put("city", city);
        presenter.register(body);
        //  CommonUtils.startActivity(this, OtpVerificationActivity.class);
    }

    @Override
    public void moveToOtp(LoginResponseData data) {
        Bundle bundle = new Bundle();
        bundle.putString("mobile", data.getPhoneNo());
        bundle.putString("otp", data.getOtp());
        bundle.putString("user_id", data.getId());
        CommonUtils.startActivity(this, OtpVerificationActivity.class, bundle, false);
    }
}
