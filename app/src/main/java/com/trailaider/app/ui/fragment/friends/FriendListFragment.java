package com.trailaider.app.ui.fragment.friends;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.friend.FriendListAdapter;
import com.trailaider.app.ui.activity.userprofile.UserProfilePresenter;
import com.trailaider.app.ui.fragment.BaseFragment;
import com.trailaider.app.utils.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by gajanand on 24/2/18.
 */

public class FriendListFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LoginResponseData loginData;
    private UserProfilePresenter presenter;
    private List<FriendModel> list;
    private FriendListAdapter adapter;
    private EditText editTextSearch;
    List<FriendModel> filterList = new ArrayList<>();

    public static FriendListFragment newInstance() {

        Bundle args = new Bundle();

        FriendListFragment fragment = new FriendListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializePresenter();
        initializeView(view);
        recyclerView = view.findViewById(R.id.recycler_view);
        editTextSearch = view.findViewById(R.id.edit_text_search);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FriendListAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    CommonUtils.hideKeyboard(getActivity());
                    return true;
                }
                return false;
            }
        });
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();
//                filter(text);
            }
        });
    }

    @Override
    protected void initializeView(View view) {

    }

    @Override
    protected void initializePresenter() {
    }


    private void getProfile() {
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_id", loginData.getId());
        body.put("my_friends", "1");
        presenter.getUserProfile(body);
    }


    public void setFriendData(List<FriendModel> data) {
        if (data != null) {
            list.clear();
            list.addAll(data);
            this.filterList.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        list.clear();
        if (charText.length() == 0) {
            list.addAll(filterList);
        } else {
            for (FriendModel wp : filterList) {
                if (wp.getFirstname().toLowerCase(Locale.getDefault()).contains(charText)) {
                    list.add(wp);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}
