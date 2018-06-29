package com.trailaider.app.ui.fragment.friends;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.trailaider.app.data.model.userprofile.UserProfileData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.friend.FriendListAdapter;
import com.trailaider.app.ui.activity.userprofile.UserProfilePresenter;
import com.trailaider.app.ui.activity.userprofile.UserProfileView;
import com.trailaider.app.ui.adapter.FriendRequestAdapter;
import com.trailaider.app.ui.fragment.BaseFragment;
import com.trailaider.app.utils.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 24/2/18.
 */

public class FriendRequestFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LoginResponseData loginData;
    private UserProfilePresenter presenter;
    private List<FriendModel> list;
    private FriendRequestAdapter adapter;
    private EditText editTextSearch;

    public static FriendRequestFragment newInstance() {

        Bundle args = new Bundle();

        FriendRequestFragment fragment = new FriendRequestFragment();
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
        adapter = new FriendRequestAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
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
//                adapter.getFilter().filter(text);
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


    public void setFriendData(List<FriendModel> list) {
        this.list.clear();
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
