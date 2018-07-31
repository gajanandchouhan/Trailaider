package com.trailaider.app.utils;

import android.Manifest;

/**
 * Created by gajanand on 6/1/18.
 */

public interface ConstantLib {

    String PERMISSION_SMS[] = new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS};
    String PERMISSION_IMAGE_PICK[] = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    String PERMISION_LOCATION[] = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    String KEY_BUNDLE_EXTRA = "bundle";
    String SUCCESS = "true";
    String FROM_SLIDER = "from_slider";
    int SUCCESS_RESULT = 0;
    int FAILURE_RESULT = 1;
    String PACKAGE_NAME =
            "com.google.android.gms.location.sample.locationaddress";
    String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    String RESULT_DATA_KEY = PACKAGE_NAME +
            ".RESULT_DATA_KEY";
    String LOCATION_DATA_EXTRA = PACKAGE_NAME +
            ".LOCATION_DATA_EXTRA";

    String UNIT_IMPERIAL = "Imperial";
    String UNIT_METRIC = "Metric";
    String PROFILE_PUBLIC = "1";
    String PROFILE_PRIVATE = "0";
    String PROFILE_FRIEND = "2";
    String UNIT_MINUTE = "min";
    String UNIT_SECOND = "sec";
}
