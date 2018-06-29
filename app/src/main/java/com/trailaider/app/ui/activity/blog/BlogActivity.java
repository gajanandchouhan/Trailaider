package com.trailaider.app.ui.activity.blog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.chat.MessageResponseData;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.inbox.InboxListAdapter;
import com.trailaider.app.utils.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 17/1/18.
 */

public class BlogActivity extends BaseActivity implements BlogView {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private TextView textViewTitle;
    private LoginResponseData loginData;
    private BlogPresenter presenter;
    private List<MessageResponseData> list;
    private BlogListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.blog));
        recyclerView = findViewById(R.id.recycler_view);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,20,true));
        adapter = new BlogListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        getBlogs();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void getBlogs() {
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_id", loginData.getId());
//        presenter.getInbox(body);
    }

    @Override
    public void initializePresneter() {
        presenter = new BlogPresenter(this);
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


}
