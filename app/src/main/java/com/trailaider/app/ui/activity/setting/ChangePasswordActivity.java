package com.trailaider.app.ui.activity.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.utils.CommonUtils;

import java.util.HashMap;

/**
 * Created by gajanand on 17/1/18.
 */

public class ChangePasswordActivity extends BaseActivity implements ChangePasswordView {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private TextView textViewTitle;
    private EditText editTextCurrPass, editTextNewPass, editTextConfirmNewPass;
    private ChangePasswordPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.change_password));
    }

    @Override
    public void initializePresneter() {
        presenter = new ChangePasswordPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        editTextCurrPass = findViewById(R.id.edit_current);
        editTextNewPass = findViewById(R.id.edit_newpass);
        editTextConfirmNewPass = findViewById(R.id.edit_confirm_newpass);
        findViewById(R.id.button_submit).setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void validateFotgotPassword() {
        String currPass = editTextCurrPass.getText().toString().trim();
        String newPass = editTextNewPass.getText().toString().trim();
        String confirmNewPass = editTextConfirmNewPass.getText().toString().trim();
        if (currPass.isEmpty()) {
            editTextCurrPass.setError("Please enter current password.");
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
        body.put("current_password", currPass);
        body.put("user_id", TrailaiderPreferences.getInstance().getLoginData().getId());
        presenter.changePassword(body);
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
    public void onPasswordChangeSuccess() {
        finish();
    }
}
