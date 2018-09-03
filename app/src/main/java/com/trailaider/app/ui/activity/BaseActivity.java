package com.trailaider.app.ui.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.trailaider.app.R;
import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.persistance.DBHelper;
import com.trailaider.app.ui.activity.home.MainActivity;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gajanand on 4/1/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView, View.OnClickListener {

    private ProgressDialog dialog;
    private Uri uri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializePresneter();
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

    }

    protected void setNotifcationClickListner(final View imageView) {
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CommonUtils.showDropDownWindow(new ArrayList(),BaseActivity.this,imageView);
                }
            });
        }
    }

    public abstract void initializePresneter();

    public abstract void initializeView();

    @Override
    public void showProgress() {
        dialog = ProgressDialog.show(this, "", "", true, false);
    }

    @Override
    public void hideProgress() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onClick(View view) {

    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }

    public void shareContent(String text, String image) {
        if (CommonUtils.hasPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK)) {
            CommonUtils.shareImageAndText(this, text, image);
        } else {
            ActivityCompat.requestPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK, 1);
        }
    }
}
