package com.trailaider.app.ui.activity.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.chat.MessageResponseData;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.chat.ChatListAdapter;
import com.trailaider.app.ui.activity.userprofile.UserProfilePresenter;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

/**
 * Created by gajanand on 17/1/18.
 */

public class ChatActivity extends BaseActivity implements ChatView {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private TextView textViewTitle, textViewHeader;
    private LoginResponseData loginData;
    private ChatPresenter presenter;
    private List<MessageResponseData> list;
    private ChatListAdapter adapter;
    private String friendName;
    private String friendId;
    private String userId;
    private String userImage;
    private String friendImage;
    EditText editTextMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Bundle bundleExtra = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA);
        userId = bundleExtra.getString("user_id");
        friendId = bundleExtra.getString("friend_id");
        friendName = bundleExtra.getString("user_name");
        userImage = bundleExtra.getString("user_image");
        friendImage = bundleExtra.getString("friend_image");
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.app_name));
        textViewHeader = findViewById(R.id.textView_header);
        textViewHeader.setText(friendName);
        recyclerView = findViewById(R.id.recycler_view);
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, VERTICAL, true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ChatListAdapter(this, list, userImage, friendImage, userId);
        recyclerView.setAdapter(adapter);
        getChat("1");
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.button_send:
                sendMessage();
                break;
        }
    }

    private void sendMessage() {
        String msg = editTextMessage.getText().toString().trim();
        if (msg.isEmpty()) {
            return;
        }

        HashMap<String, String> body = new HashMap<>();
        body.put("from_id", userId);
        body.put("to_id", friendId);
        body.put("message", msg);
        presenter.sendMessage(body);

    }

    private void getChat(String page) {
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        HashMap<String, String> body = new HashMap<>();
        body.put("from_id", loginData.getId());
        body.put("to_id", friendId);
        body.put("page", page);
        body.put("limit", "30");
        presenter.getChat(body);
    }

    @Override
    public void initializePresneter() {
        presenter = new ChatPresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public void initializeView() {
        editTextMessage = findViewById(R.id.edit_text_msg);
        findViewById(R.id.button_send).setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setMessageList(List<MessageResponseData> list) {
        if (list != null) {
            this.list.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onMessageSent(MessageResponseData data) {
        if (data != null) {
            data.setMessage(editTextMessage.getText().toString().trim());
            data.setFrom_id(userId);
            data.setCreated_at(CommonUtils.getCureretDateTime());
            list.add(0, data);
            adapter.notifyDataSetChanged();
            editTextMessage.setText("");
        }
    }
}
