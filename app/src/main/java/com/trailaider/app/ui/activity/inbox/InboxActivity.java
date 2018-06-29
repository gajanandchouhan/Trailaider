package com.trailaider.app.ui.activity.inbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.chat.MessageResponseData;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.model.userprofile.UserProfileData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.friend.FriendListAdapter;
import com.trailaider.app.ui.activity.userprofile.UserProfilePresenter;
import com.trailaider.app.ui.activity.userprofile.UserProfileView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 17/1/18.
 */

public class InboxActivity extends BaseActivity implements InboxView {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private TextView textViewTitle, textViewHeader;
    private LoginResponseData loginData;
    private InboxPresenter presenter;
    private List<MessageResponseData> list;
    private InboxListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.app_name));
//        textViewHeader = findViewById(R.id.textView_header);
//        textViewHeader.setText(getString(R.string.inbox));
        recyclerView = findViewById(R.id.recycler_view);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InboxListAdapter(this, list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getInbox();
    }

    private void getInbox() {
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_id", loginData.getId());
        presenter.getInbox(body);
    }

    @Override
    public void initializePresneter() {
        presenter = new InboxPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setInboxList(List<MessageResponseData> list) {
        if (list != null) {
            this.list.clear();
            this.list.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }
}
