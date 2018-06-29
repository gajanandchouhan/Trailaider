package com.trailaider.app.ui.fragment.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.review.ReviewDataModel;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.review.AddReviewActivity;
import com.trailaider.app.ui.fragment.BaseFragment;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 12/1/18.
 */

public class ReviewFrament extends BaseFragment implements ReviewView {

    RecyclerView recyclerView;
    EditText editTextSearch;
    private ReviewListAdapter adapter;
    private List<ReviewDataModel> list;
    LoginResponseData loginResponseData;
    private ReviewPresenter presenter;

    public static ReviewFrament newInstance() {

        Bundle args = new Bundle();

        ReviewFrament fragment = new ReviewFrament();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    protected void initializeView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        editTextSearch = view.findViewById(R.id.edit_text_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new ReviewListAdapter(getActivity(), list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(8));
        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    CommonUtils.hideKeyboard(getActivity());
                    getReview(editTextSearch.getText().toString().trim());
                    editTextSearch.setText("");
                    return true;
                }
                return false;
            }
        });
        view.findViewById(R.id.image_view_plus).setOnClickListener(this);
        loginResponseData = TrailaiderPreferences.getInstance().getLoginData();
        presenter = new ReviewPresenter(getActivity());
        presenter.initialiseView(this);
        getReview("");


    }

    public void getReview(String searchKey) {
        HashMap<String, String> body = new HashMap<>();
        body.put("search_string", searchKey);
        body.put("user_id", loginResponseData.getId());
        body.put("is_all", "1");
        presenter.getReview(body);
    }

    @Override
    protected void initializePresenter() {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.image_view_plus:
                startActivityForResult(new Intent(getActivity(), AddReviewActivity.class), 105);
                break;
        }
    }

    @Override
    public void onReviewAdded() {

    }

    @Override
    public void setReviewList(List<ReviewDataModel> data) {
        if (data != null) {
            list.clear();
            list.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRatingAdded() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 105 && resultCode == Activity.RESULT_OK) {
            getReview("");
        }
    }
}
