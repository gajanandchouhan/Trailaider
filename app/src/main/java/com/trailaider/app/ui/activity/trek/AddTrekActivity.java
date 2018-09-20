package com.trailaider.app.ui.activity.trek;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.review.ReviewmageListAdapter;
import com.trailaider.app.ui.dialog.SelectionListDialog;
import com.trailaider.app.ui.dialog.TrekTypeSelectionDialog;
import com.trailaider.app.ui.pickers.ImagePickerUtils;
import com.trailaider.app.utils.AddressListner;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;
import com.trailaider.app.utils.Glide4Engine;
import com.trailaider.app.utils.LocationTask;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by gajanand on 14/1/18.
 */

public class AddTrekActivity extends BaseActivity implements AddTrekView {

    private static final int REQUEST_CHECK_SETTINGS = 105;
    private static final int REQUEST_CODE_CHOOSE = 11;
    private Toolbar toolbar;
    private ActionBar actionBar;
    EditText editTextTrekName, editTextTrekHeight;
    TextView textViewTrekType, textViewTrekDuration, textViewUnit;
    private double lat = 0;
    private double lon = 0;
    private LoginResponseData loginData;
    private AddTrekPresenter presenter;
    private Location location;
    private List<String> list;
    private RecyclerView recyclerView;
    private ReviewmageListAdapter adapter;
    private String unit;
    private List<Uri> mSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trek);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
       /* if (!CommonUtils.hasPermissions(this, ConstantLib.PERMISION_LOCATION)) {
            ActivityCompat.requestPermissions(this, ConstantLib.PERMISION_LOCATION, 104);
        } else {
            createLocationRequest();
        }*/

        findViewById(R.id.layout_upload).setOnClickListener(this);
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list = new ArrayList<>();
        adapter = new ReviewmageListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        presenter = new AddTrekPresenter(this);
        presenter.initialiseView(this);
        if (loginData.getUnit().equalsIgnoreCase(ConstantLib.UNIT_METRIC)) {
            unit = "m";
            textViewUnit.setText(unit);
        } else {
            unit = "ft";
            textViewUnit.setText(unit);
        }


    }

    public void chekcPermisionAndOpenPicker() {
        if (CommonUtils.hasPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK)) {
            openMultipicker();
        } else {
            ActivityCompat.requestPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK, 105);
        }
    }

    private void openMultipicker() {
        Matisse.from(this)
                .choose(MimeType.ofImage())
                .countable(true)
                .maxSelectable(6)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .imageEngine(new Glide4Engine())
                .forResult(REQUEST_CODE_CHOOSE);
    }

    private void uploadInsideImages(List<String> photos) {
        list.addAll(photos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {
        editTextTrekHeight = findViewById(R.id.edit_text_height);
        editTextTrekName = findViewById(R.id.edit_text_trek_name);
        textViewTrekDuration = findViewById(R.id.textView_duration);
        textViewTrekType = findViewById(R.id.textView_trek_type);
        textViewUnit = findViewById(R.id.textView_unit);
        textViewTrekType.setOnClickListener(this);
        textViewTrekDuration.setOnClickListener(this);
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
            case R.id.textView_trek_type:
                showTrekTypePopup();
                break;
            case R.id.layout_upload:
                validateUpload();
                break;
            case R.id.textView_duration:
                showTrekDurationDialog();
                break;
        }
    }

    private void validateUpload() {
        String name = editTextTrekName.getText().toString().trim();
        String trekType = textViewTrekType.getText().toString().trim();
        String trekHeight = editTextTrekHeight.getText().toString().trim();
        String trekDuration = textViewTrekDuration.getText().toString().trim();
        if (name.isEmpty()) {
            editTextTrekName.setError(getString(R.string.enter_trek_name));
            return;
        }
        if (trekType.isEmpty()) {
            CommonUtils.showToast(this, getString(R.string.select_trek_type));
            return;
        }
        if (trekDuration.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.enter_trek_duration));
            return;
        }

        if (trekHeight.isEmpty()) {
            editTextTrekHeight.setError(getString(R.string.enter_trek_height));
            return;
        }

        TrekResponseData data = new TrekResponseData();
        data.setTrek_type(trekType);
        data.setTrek_name(name);
        data.setTrek_duration(trekDuration.replace(" Days", ""));
        data.setTrek_height(trekHeight + " " + unit);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("user_id", loginData.getId());
        builder.addFormDataPart("trek_name", name);
        builder.addFormDataPart("trek_type", trekType);
        builder.addFormDataPart("trek_unit", loginData.getUnit());
//        builder.addFormDataPart("rating", String.valueOf(rating));
        builder.addFormDataPart("trek_duration", trekDuration.replace(" Days", ""));
        builder.addFormDataPart("trek_height", trekHeight);
        for (int i = 0; i < list.size(); i++) {
            try {
                if (list.get(i) != null) {
                    File file = new File(list.get(i));
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    builder.addFormDataPart("trek_images[]", file.getName(), requestBody);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        RequestBody finalRequestBody = builder.build();

        presenter.addTrek(finalRequestBody, data, list);
       /* if (location != null) {
            getLocationAddress(location, name, body);
        } else {
            CommonUtils.showToast(this, getString(R.string.error_location));
        }*/


    }

    private void showTrekTypePopup() {
        new TrekTypeSelectionDialog(this, new TrekTypeSelectionDialog.SelectedListner() {
            @Override
            public void onSelected(String type) {
                textViewTrekType.setText(type);
            }
        }).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 104) {
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    finish();
                    return;
                }
            }
            createLocationRequest();
        }
        if (requestCode == 105) {
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
            }
            openMultipicker();
        }
    }


    protected void createLocationRequest() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());

        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                getLocation();
//                Location location = LocationTask.getLocation(AddTrekActivity.this);
//                if (location != null)
//                    Log.v("LOCATION ", location.getLatitude() + " " + location.getLongitude());
            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(AddTrekActivity.this,
                                REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        FusedLocationProviderClient mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {


                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            AddTrekActivity.this.location = location;
                            lat = location.getLatitude();
                            lon = location.getLongitude();
                            Log.v("LOCATION ", location.getLatitude() + " " + location.getLongitude());
                        }
                    }
                });
    }

    private void getLocationAddress(Location location, final String trekName, final HashMap<String, String> body) {
        new LocationTask(this, location, new AddressListner() {
            @Override
            public void addressFetched(String address) {
                Log.v("CITY", "City Name : " + address);
                if (address != null && address.equalsIgnoreCase(trekName)) {
                    body.put("latitude", String.valueOf(lat));
                    body.put("longitude", String.valueOf(lat));
                    body.put("address", address);
//                    presenter.addTrek(body);
                } else {
                    CommonUtils.showToast(AddTrekActivity.this, getString(R.string.location_not_match));
                }
            }
        }).execute();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (resultCode == RESULT_OK) {
                createLocationRequest();
            } else {
                finish();
            }
        }
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            List<String> photos = ImagePickerUtils.getPathList(this, mSelected);
            if (photos != null) {
                uploadInsideImages(photos);
            }
        }
    }

    @Override
    public void onTrekAdded() {
        setResult(RESULT_OK);
        finish();
    }


    public void showTrekDurationDialog() {
        new SelectionListDialog(this, getListOfDays(), new SelectionListDialog.SelectedListner<String>() {
            @Override
            public void onSelected(int position, String object) {
                textViewTrekDuration.setText(object);
            }
        }).show();
    }

    private List<String> getListOfDays() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            list.add(String.valueOf(i) + " Days");
        }
        return list;
    }
}
