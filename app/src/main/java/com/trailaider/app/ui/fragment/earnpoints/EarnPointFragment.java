package com.trailaider.app.ui.fragment.earnpoints;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trailaider.app.R;
import com.trailaider.app.ui.fragment.BaseFragment;
import com.trailaider.app.ui.fragment.review.ReviewListAdapter;

/**
 * Created by gajanand on 18/1/18.
 */

public class EarnPointFragment extends BaseFragment {
    private RecyclerView recyclerView;
    public static EarnPointFragment newInstance() {
        
        Bundle args = new Bundle();
        
        EarnPointFragment fragment = new EarnPointFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializePresenter();
        initializeView(view);
    }

    @Override
    protected void initializeView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new EarnPointListAdapter(getActivity()));
    }

    @Override
    protected void initializePresenter() {

    }
}
