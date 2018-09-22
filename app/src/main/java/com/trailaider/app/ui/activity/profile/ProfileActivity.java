package com.trailaider.app.ui.activity.profile;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.home.MainActivity;
import com.trailaider.app.ui.dialog.HeightPicker;
import com.trailaider.app.ui.dialog.WeightPicker;
import com.trailaider.app.ui.pickers.ImagePickerUtils;
import com.trailaider.app.ui.dialog.SelectionListDialog;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;
import com.trailaider.app.utils.DateSelectedListner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ProfileActivity extends BaseActivity implements ProfileView {
    TextView unitTextView, dobTextView;
    EditText editTextFirstName, editTextLastName, editTextCity, editTextPincode;
    ImageView imageViewProfile, imageViewCamera;
    private String imagePath;
    private LoginResponseData loginData;
    private ProfilePresenter presenter;
    private List<String> genderList;
    private boolean fromSlider;
    private TextView textViewGender;
    List<String> list;

    TextView editTextHeight, editTextWeight;
    private String currentUnit;
    Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
        setContentView(R.layout.activity_profile);
        initializeView();
        initializePresneter();
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        setUpView();
        if (fromSlider)
            enableDisableView(false);
    }

    private void enableDisableView(boolean isEnable) {
        imageViewProfile.setEnabled(isEnable);
        unitTextView.setEnabled(isEnable);
        editTextWeight.setEnabled(isEnable);
        editTextHeight.setEnabled(isEnable);
        editTextFirstName.setEnabled(isEnable);
        editTextPincode.setEnabled(isEnable);
        editTextCity.setEnabled(isEnable);
        editTextLastName.setEnabled(isEnable);
        dobTextView.setEnabled(isEnable);
        textViewGender.setEnabled(isEnable);
        buttonSave.setEnabled(isEnable);
    }

    private void setUpView() {
        editTextFirstName.setText(loginData.getFirstname());
        editTextLastName.setText(loginData.getLastname());
        editTextCity.setText(loginData.getCity());
        dobTextView.setText(loginData.getDob());
        unitTextView.setText(loginData.getUnit());
        currentUnit = loginData.getUnit();
        editTextHeight.setText(loginData.getHeight());
        editTextWeight.setText(loginData.getWeight());
        textViewGender.setText(loginData.getGender());
        fromSlider = getIntent().getBooleanExtra(ConstantLib.FROM_SLIDER, false);
        editTextPincode.setText(loginData.getPincode());
        if (loginData.getUser_image() != null && !loginData.getUser_image().isEmpty())
            GlideApp.with(imageViewProfile).load(loginData.getUser_image()).into(imageViewProfile);
    }

    @Override
    public void initializePresneter() {
        presenter = new ProfilePresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        unitTextView = findViewById(R.id.textView_unit);
        textViewGender = findViewById(R.id.textView_gender);
        dobTextView = findViewById(R.id.textView_dob);
        editTextHeight = findViewById(R.id.edit_text_height);
        editTextWeight = findViewById(R.id.edit_text_weight);
        editTextCity = findViewById(R.id.edit_text_city);
        editTextFirstName = findViewById(R.id.edit_text_fname);
        editTextLastName = findViewById(R.id.edit_text_lastname);
        editTextPincode = findViewById(R.id.edit_text_pincode);
        imageViewProfile = findViewById(R.id.image_view_profile);
        imageViewCamera = findViewById(R.id.image_view_camera);
        buttonSave = findViewById(R.id.button_save);
        editTextWeight.setOnClickListener(this);
        findViewById(R.id.button_save).setOnClickListener(this);
        imageViewProfile.setOnClickListener(this);
        findViewById(R.id.textView_unit).setOnClickListener(this);
        dobTextView.setOnClickListener(this);
        textViewGender.setOnClickListener(this);
        editTextHeight.setOnClickListener(this);
        findViewById(R.id.imageView_edit).setOnClickListener(this);
        genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.button_save:
                validateAndUpdate();
                break;
            case R.id.image_view_profile:
                if (CommonUtils.hasPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK)) {
                    ImagePickerUtils.showImagePicker(this);
                } else {
                    ActivityCompat.requestPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK, 102);
                }
                break;
            case R.id.textView_unit:
                showUnitSelecttion();
                break;
            case R.id.edit_text_weight:
                showWeightPicker();
                break;
            case R.id.edit_text_height:
                showHeightPicker();
                break;
            case R.id.textView_gender:
                showGenderSelection();
                break;
            case R.id.textView_dob:
                showDatePicker();
                break;
            case R.id.imageView_edit:
                imageViewCamera.setVisibility(View.VISIBLE);
                enableDisableView(true);
                break;
        }
    }

    private void showWeightPicker() {
        String type = unitTextView.getText().toString();
        if (type.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_unit));
            return;
        }
        new WeightPicker(this, type, new WeightPicker.SelectedListner() {
            @Override
            public void onSelected(int position, String object) {
                editTextWeight.setText(object);
            }
        }, editTextWeight.getText().toString().trim()).show();

    }

    private void showHeightPicker() {
        String type = unitTextView.getText().toString();
        if (type.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_unit));
            return;
        }
        new HeightPicker(this, type, new HeightPicker.SelectedListner() {
            @Override
            public void onSelected(int position, String object) {
                editTextHeight.setText(object);
            }
        }, editTextHeight.getText().toString().trim()).show();

    }

    private void showGenderSelection() {

        new SelectionListDialog(this, genderList, new SelectionListDialog.SelectedListner<String>() {
            @Override
            public void onSelected(int position, String object) {
                textViewGender.setText(object);
            }
        }).show();
    }

    private void showDatePicker() {
        CommonUtils.showDatePicker(this, "Select Date", 1, new DateSelectedListner() {
            @Override
            public void onDateSelected(String date, int type) {
                dobTextView.setText(date);
            }
        });
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
                    convertUnit(object);
                    currentUnit = object;
                }

                unitTextView.setText(object);
            }
        }).show();
    }

    private void convertUnit(String unit) {
        switch (unit) {
            case ConstantLib.UNIT_IMPERIAL:
                String weight = editTextWeight.getText().toString().trim();
                String height = editTextHeight.getText().toString().trim();
                if (!weight.isEmpty()) {
                    editTextWeight.setText(CommonUtils.kgsToLbs(weight.replace(" kgs", "")));
                }

                if (!height.isEmpty()) {
                    editTextHeight.setText(CommonUtils.centimeterToFeet(height.replace(" cm", "")));
                }
                break;

            case ConstantLib.UNIT_METRIC:
                String w = editTextWeight.getText().toString().trim();
                String h = editTextHeight.getText().toString().trim();
                if (!w.isEmpty()) {
                    editTextWeight.setText(CommonUtils.lbsToKgs(w.replace(" lbs", "")));
                }

                if (!h.isEmpty()) {
                    editTextHeight.setText(CommonUtils.feetToCm(h));
                }
                break;
        }
    }

    private void validateAndUpdate() {
        String fName = editTextFirstName.getText().toString().trim();
        String lName = editTextLastName.getText().toString().trim();
        String height = editTextHeight.getText().toString().trim();
        String weight = editTextWeight.getText().toString().trim();
        String unit = unitTextView.getText().toString().trim();
        String dob = dobTextView.getText().toString().trim();
        String city = editTextCity.getText().toString().trim();
        String pinCode = editTextPincode.getText().toString().trim();
        String gender = textViewGender.getText().toString().trim();
        if (fName.isEmpty()) {
            editTextFirstName.setError(getString(R.string.enter_firstname));
            return;
        }
        if (unit.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_unit));
            return;
        }
        if (gender.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_gender));
            return;
        }
        if (height.isEmpty()) {
            editTextHeight.setError(getString(R.string.enter_height));
            return;
        }

        if (weight.isEmpty()) {
            editTextWeight.setError(getString(R.string.enter_weight));
            return;
        }

        if (dob.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_dob));
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

        HashMap<String, String> stringBody = new HashMap<>();
        stringBody.put("firstname", fName);
        stringBody.put("lastname", lName);
        stringBody.put("unit", unit);
        stringBody.put("height", height);
        stringBody.put("weight", weight);
        stringBody.put("dob", dob);
        stringBody.put("city", city);
        stringBody.put("pincode", pinCode);
        stringBody.put("user_id", loginData.getId());
        stringBody.put("email", loginData.getEmail());
        stringBody.put("phone_no", loginData.getPhoneNo());
        stringBody.put("gender", gender);
        HashMap<String, File> fileBody = null;
        if (imagePath != null) {
            fileBody = new HashMap<>();
            fileBody.put("user_image", new File(imagePath));
        }
        presenter.updateProfile(stringBody, fileBody);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            findViewById(R.id.image_view_camera).setVisibility(View.GONE);
            if (requestCode == ImagePickerUtils.GALEERY_REQUEST) {
                Uri uri = data.getData();
                if (uri != null) {
                    imageViewProfile.setImageURI(uri);
                    imagePath = ImagePickerUtils.getPath(this, uri);
                    CommonUtils.showLog(this.getClass().getSimpleName(), "Image Path : " + imagePath);
                }
            } else if (requestCode == ImagePickerUtils.CAMERA_REQUEST) {
//                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Uri tempUri = getUri();
                imageViewProfile.setImageURI(tempUri);
                imagePath = ImagePickerUtils.getPath(this, tempUri);
                CommonUtils.showLog(this.getClass().getSimpleName(), "Image Path : " + imagePath);
                // CALL THIS METHOD TO GET THE ACTUAL PATH
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 102) {
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
            }
            ImagePickerUtils.showImagePicker(this);
        }
    }

    @Override
    public void setProfileData(LoginResponseData data) {
        loginData = data;
        TrailaiderPreferences.getInstance().saveLoginData(data);
        TrailaiderPreferences.getInstance().setProfileVisited(true);
        setUpView();
        //if (!fromSlider)
            CommonUtils.startActivity(this, MainActivity.class,null,true);
        finish();
    }
}
