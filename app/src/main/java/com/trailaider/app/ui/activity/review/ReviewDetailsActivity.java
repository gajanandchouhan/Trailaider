package com.trailaider.app.ui.activity.review;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.review.ReviewDataModel;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.userprofile.ReviewUserProfileActivity;
import com.trailaider.app.ui.adapter.ImageListAdapter;
import com.trailaider.app.ui.fragment.review.ReviewPresenter;
import com.trailaider.app.ui.fragment.review.ReviewView;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 17/1/18.
 */

public class ReviewDetailsActivity extends BaseActivity implements ReviewView {


    private Toolbar toolbar;
    private ActionBar actionBar;
    TextView textViewUserCount;
    private ReviewDataModel reviewDataModel;
    TextView textViewUserName, textViewReviewName, textViewReviewDesc, textViewUrl, textViewRating;

    RatingBar ratingBar;
    RecyclerView recyclerView;
    private RatingBar ratingBar2;
    private ReviewPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.textView_view_profile).setOnClickListener(this);
        reviewDataModel = (ReviewDataModel) getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA).getSerializable("data");
        setUpUi();
        textViewUrl.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setUpUi() {
        if (reviewDataModel.getRating() != null && !reviewDataModel.getRating().isEmpty()) {
            float rating = Float.parseFloat(reviewDataModel.getRating());
            if (rating > 0) {
                findViewById(R.id.layout_rating).setVisibility(View.GONE);
            } else {
                findViewById(R.id.layout_rating).setVisibility(View.VISIBLE);
            }
        } else {
            findViewById(R.id.layout_rating).setVisibility(View.VISIBLE);
        }
        textViewUserName.setText(String.format("%s %s", reviewDataModel.getFirstname(), reviewDataModel.getLastname()));
        textViewReviewName.setText(reviewDataModel.getReview_title());
        textViewUrl.setText(reviewDataModel.getUrl());
        textViewReviewDesc.setText(reviewDataModel.getComment());
        textViewRating.setText(reviewDataModel.getAvg_rating());
        ratingBar.setRating(Float.parseFloat(reviewDataModel.getAvg_rating() != null && !reviewDataModel.getAvg_rating().isEmpty() ? reviewDataModel.getAvg_rating() : "0"));
        recyclerView.setAdapter(new ImageListAdapter(this, reviewDataModel.getReview_images()));
        textViewUserCount.setText(String.format("%s Users", reviewDataModel.getTotal_rating()));
    }

    @Override
    public void initializePresneter() {
        presenter = new ReviewPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        textViewUserName = findViewById(R.id.textView_user_name);
        textViewReviewName = findViewById(R.id.textView_review_name);
        textViewReviewDesc = findViewById(R.id.textView_review_desc);
        textViewUserCount = findViewById(R.id.textView_users);
        textViewUrl = findViewById(R.id.textView_url);
        textViewRating = findViewById(R.id.textView_rating);
        ratingBar = findViewById(R.id.rating_bar);
        recyclerView = findViewById(R.id.recycler_view);
        ratingBar2 = findViewById(R.id.rating_bar_user);
        findViewById(R.id.button_submit).setOnClickListener(this);
        LayerDrawable stars = (LayerDrawable) ratingBar2.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
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
            case R.id.textView_view_profile:
                Bundle bundle = new Bundle();
                bundle.putString("id", reviewDataModel.getUser_id());
                CommonUtils.startActivity(this, ReviewUserProfileActivity.class, bundle, false);
                break;
            case R.id.button_submit:
                submitRating();
                break;
        }
    }

    private void submitRating() {
        float rating = ratingBar2.getRating();
        if (rating > 0) {
            LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();
            HashMap<String, String> body = new HashMap<>();
            body.put("user_id", loginData.getId());
            body.put("rating", String.valueOf(ratingBar2.getRating()));
            body.put("review_id", reviewDataModel.getReview_id());
            presenter.addRating(body);
        } else {
            CommonUtils.showSnakeBar(this, getString(R.string.submit_rating));
        }

    }

    @Override
    public void onReviewAdded() {

    }

    @Override
    public void setReviewList(List<ReviewDataModel> data) {

    }

    @Override
    public void onRatingAdded() {
        setResult(RESULT_OK);
        onBackPressed();
    }
}
