package com.trailaider.app.ui.fragment.trek;

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
import com.trailaider.app.data.model.TrekTableModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.persistance.DBHelper;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.trek.AddTrekActivity;
import com.trailaider.app.ui.fragment.BaseFragment;
import com.trailaider.app.ui.fragment.review.ReviewFrament;
import com.trailaider.app.ui.fragment.review.ReviewListAdapter;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 12/1/18.
 */

public class TrekFrament extends BaseFragment implements TrekView {
    RecyclerView recyclerView;
    EditText editTextSearch;
    private TrekPresenter presenter;
    private LoginResponseData loginData;
    private TrekListAdapter adapter;
    private List<TrekResponseData> list;

    public static TrekFrament newInstance() {
        Bundle args = new Bundle();
        TrekFrament fragment = new TrekFrament();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trek, container, false);
    }

    @Override
    protected void initializeView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        editTextSearch = view.findViewById(R.id.edit_text_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new TrekListAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(2));
        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    CommonUtils.hideKeyboard(getActivity());
                    String trim = editTextSearch.getText().toString().trim();
                    if (!trim.isEmpty()) {
                        getTrek(trim);
                    }
                    editTextSearch.setText("");
                    return true;
                }
                return false;
            }
        });
        view.findViewById(R.id.image_view_plus).setOnClickListener(this);
        presenter = new TrekPresenter(getActivity());
        presenter.initialiseView(this);
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        getTrek("");
    }

    public void getTrek(String searchKey) {
        HashMap<String, String> body = new HashMap<>();
        body.put("user_id", loginData.getId());
        body.put("search_string", searchKey);
        presenter.getTrek(body);
    }

    @Override
    protected void initializePresenter() {

    }



    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.image_view_plus:
                startActivityForResult(new Intent(getActivity(), AddTrekActivity.class), 101);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            if (CheckNetworkState.isOnline(getActivity())) {
                getTrek("");
            } else {
                List<TrekResponseData> trekLocalList = DBHelper.getInstance(getActivity()).getLocalTrekList();
                if (trekLocalList != null) {
                    if (list != null) {
                        list.addAll(0,trekLocalList);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    @Override
    public void setTrekList(List<TrekResponseData> data) {
        if (data != null) {
            list.clear();
            list.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }
}
