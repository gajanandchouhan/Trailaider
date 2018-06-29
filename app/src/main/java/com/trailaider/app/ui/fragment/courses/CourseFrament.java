package com.trailaider.app.ui.fragment.courses;

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
import com.trailaider.app.ui.activity.course.AddCourseActivity;
import com.trailaider.app.ui.activity.review.AddReviewActivity;
import com.trailaider.app.ui.fragment.BaseFragment;
import com.trailaider.app.ui.fragment.trek.TrekFrament;
import com.trailaider.app.ui.fragment.trek.TrekListAdapter;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.SpacesItemDecoration;

/**
 * Created by gajanand on 12/1/18.
 */

public class CourseFrament extends BaseFragment {
    RecyclerView recyclerView;
    EditText editTextSearch;

    public static CourseFrament newInstance() {
        Bundle args = new Bundle();
        CourseFrament fragment = new CourseFrament();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

    @Override
    protected void initializeView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        editTextSearch = view.findViewById(R.id.edit_text_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CourseListAdapter(getActivity()));
        recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        view.findViewById(R.id.image_view_plus).setOnClickListener(this);
    }

    @Override
    protected void initializePresenter() {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.image_view_plus:
                CommonUtils.startActivity(getActivity(), AddCourseActivity.class);
                break;
        }
    }
}
