package com.trailaider.app.ui.activity.review;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.review.ReviewDataModel;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.fragment.review.ReviewPresenter;
import com.trailaider.app.ui.fragment.review.ReviewView;
import com.trailaider.app.ui.pickers.ImagePickerUtils;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;
import com.trailaider.app.utils.Glide4Engine;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by gajanand on 14/1/18.
 */

public class AddReviewActivity extends BaseActivity implements ReviewView {

    private static final int REQUEST_CODE_CHOOSE = 12;
    private Toolbar toolbar;
    private ActionBar actionBar;
    EditText editTextReviewName, editTextReviewText, editTextUrl;
    RecyclerView recyclerView;
    private List<String> list;
    private ReviewmageListAdapter adapter;
    private LoginResponseData loginData;
    private ReviewPresenter presenter;
    private RatingBar ratingBar;
    private List<Uri> mSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.button_submit).setOnClickListener(this);
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        presenter = new ReviewPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {
        editTextReviewName = findViewById(R.id.edit_text_review_name);
        editTextReviewText = findViewById(R.id.edit_text_review_text);
        editTextUrl = findViewById(R.id.edit_text_url);
        recyclerView = findViewById(R.id.recycler_view);
        ratingBar = findViewById(R.id.rating_bar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list = new ArrayList<>();
        adapter = new ReviewmageListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        findViewById(R.id.button_submit).setOnClickListener(this);
        editTextReviewText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (view.getId() == R.id.edit_text_review_text) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
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
            case R.id.button_submit:
                validateUpload();
                break;
        }
    }

    private void validateUpload() {
        String name = editTextReviewName.getText().toString().trim();
        String desc = editTextReviewText.getText().toString().trim();
        String url = editTextUrl.getText().toString().trim();
        float rating = ratingBar.getRating();
        if (name.isEmpty()) {
            editTextReviewName.setError(getString(R.string.enter_review_name));
            return;
        }
        if (desc.isEmpty()) {
            editTextReviewText.setError(getString(R.string.enter_review_desc));
            return;
        }

       /* if (url.isEmpty()) {
            editTextUrl.setError(getString(R.string.enter_url));
            return;
        }*/
      /*  if (list.isEmpty()) {
            CommonUtils.showSnakeBar(this, getString(R.string.select_mage));
            return;
        }*/
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("user_id", loginData.getId());
        builder.addFormDataPart("review_title", name);
        builder.addFormDataPart("comment", desc);
//        builder.addFormDataPart("rating", String.valueOf(rating));
        builder.addFormDataPart("url", url);
        for (int i = 0; i < list.size(); i++) {
            try {
                if (list.get(i) != null) {
                    File file = new File(list.get(i));
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    builder.addFormDataPart("review_images[]", file.getName(), requestBody);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        RequestBody finalRequestBody = builder.build();
        presenter.addReview(finalRequestBody);

    }

    public void chekcPermisionAndOpenPicker() {
        if (CommonUtils.hasPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK)) {
            openMultipicker();
        } else {
            ActivityCompat.requestPermissions(this, ConstantLib.PERMISSION_IMAGE_PICK, 104);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 104) {
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
            }
            openMultipicker();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            List<String> photos = ImagePickerUtils.getPathList(this, mSelected);
            if (photos != null) {
                uploadInsideImages(photos);
            }
        }
    }

    private void uploadInsideImages(List<String> photos) {
        list.addAll(photos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onReviewAdded() {
        setResult(RESULT_OK);
        finish();

    }

    @Override
    public void setReviewList(List<ReviewDataModel> data) {

    }

    @Override
    public void onRatingAdded() {

    }
}
