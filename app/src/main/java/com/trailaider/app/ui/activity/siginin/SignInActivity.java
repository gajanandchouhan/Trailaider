package com.trailaider.app.ui.activity.siginin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.forgotpassword.ForgotPasswordActivity;
import com.trailaider.app.ui.activity.home.MainActivity;
import com.trailaider.app.ui.activity.otp.OtpVerificationActivity;
import com.trailaider.app.ui.activity.profile.ProfileActivity;
import com.trailaider.app.ui.activity.signup.SignupActivity;
import com.trailaider.app.utils.CommonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

public class SignInActivity extends BaseActivity implements GoogleApiClient.OnConnectionFailedListener, SignInView {
    private static final int RC_SIGN_IN = 111;
    private CallbackManager callbackManager;
    private GoogleApiClient mGoogleApiClient;
    private EditText editTextEmail, editTextPassword;
    private SiginInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
        setContentView(R.layout.activity_sign_in);
        initializeView();
        initializePresneter();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                //    .requestIdToken("625831639845-2v4uc03o9d98k9bld9m6rdhefoepa4gj.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
//
        editTextEmail.setText("9753788166");
        editTextPassword.setText("123456");
    }

    @Override
    public void initializePresneter() {
        presenter = new SiginInPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_pass);
        findViewById(R.id.textView_forgot_password).setOnClickListener(this);
        findViewById(R.id.button_fb).setOnClickListener(this);
        findViewById(R.id.button_google).setOnClickListener(this);
        findViewById(R.id.textView_create_account).setOnClickListener(this);
        findViewById(R.id.button_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        switch (view.getId()) {
            case R.id.textView_forgot_password:
                CommonUtils.startActivity(this, ForgotPasswordActivity.class);
                break;
            case R.id.button_fb:
                loginWithFb();
                break;
            case R.id.button_google:
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
                break;
            case R.id.textView_create_account:
                CommonUtils.startActivity(this, SignupActivity.class);
                break;
            case R.id.button_login:
                validateLogin();
                break;
        }
    }

    private void validateLogin() {
        String email = editTextEmail.getText().toString().trim();
        String passwod = editTextPassword.getText().toString().trim();
        if (email.isEmpty()) {
            editTextEmail.setError(getString(R.string.enter_email_mobile));
            return;
        }

        if (passwod.isEmpty()) {
            editTextPassword.setError(getString(R.string.enter_password));
            return;
        }

        HashMap<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", passwod);
        body.put("device_token", "dvasgdhgsadg");
        body.put("device_type", "a");
        presenter.doLogin(body);
//        CommonUtils.startActivity(this, ProfileActivity.class, null, true);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        CommonUtils.startActivity(this, ProfileActivity.class, null, true);
    }

    private void loginWithFb() {
        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Log.v("FACEBOOK", "Suceess" + loginResult.getAccessToken().getToken());
                        setFacebookData(loginResult);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Log.v("FACEBOOK", "Cancel");
                    }

                    @Override
                    public void onError(FacebookException exc) {
                        // App code
                        Log.v("ERROR", "ERROR" + exc.getMessage());
                    }
                });
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"));
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            Log.v("Google", acct.getDisplayName());

            String fullame = acct.getDisplayName();
            String email = acct.getEmail();
            String id = acct.getId();
            String[] parts = fullame.split("\\s+");
            Log.d("Length-->", "" + parts.length);
            String firstname = "";
            String lastname = "";
            if (parts.length == 2) {
                firstname = parts[0];
                lastname = parts[1];
                Log.d("First-->", "" + firstname);
                Log.d("Last-->", "" + lastname);

            } else if (parts.length == 3) {
                firstname = parts[0];
                String middlename = parts[1];
                lastname = parts[2];
            }
        }

    }


    private void setFacebookData(final LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {
                            Log.i("Response", response.toString());

                            String email = response.getJSONObject().getString("email");
                            String firstName = response.getJSONObject().getString("first_name");
                            String lastName = response.getJSONObject().getString("last_name");
                            String id = response.getJSONObject().getString("id");
//                            doSoicialSignup(firstName, lastName, email, id, "2", PrefManager.getInstance(LoginActivity.this).getString(PrefConstants.DEVICE_TOKEN));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email,first_name,last_name,gender");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    public void moveToHome(LoginResponseData data) {
        if (data.getIsOtpVerified().equalsIgnoreCase("1")) {
            if (TrailaiderPreferences.getInstance().getProfileVisited()){
                CommonUtils.startActivity(this, MainActivity.class, null, true);
            }
            else{
                CommonUtils.startActivity(this, ProfileActivity.class, null, true);
            }
            TrailaiderPreferences.getInstance().putBoolean(TrailaiderPreferences.IS_LOGGED_IN, true);

        } else {
            Bundle bundle = new Bundle();
            bundle.putString("mobile", data.getPhoneNo());
            bundle.putString("otp", data.getOtp());
            bundle.putString("user_id", data.getId());
            CommonUtils.startActivity(this, OtpVerificationActivity.class, bundle, false);
        }
    }
}
