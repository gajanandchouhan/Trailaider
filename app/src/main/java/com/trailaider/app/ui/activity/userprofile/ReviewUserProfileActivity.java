package com.trailaider.app.ui.activity.userprofile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.model.userprofile.UserProfileData;
import com.trailaider.app.data.persistance.DBHelper;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.chat.ChatActivity;
import com.trailaider.app.ui.activity.review.ReviewFriendListAdapter;
import com.trailaider.app.ui.fragment.trek.TrekListAdapter;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;
import com.trailaider.app.utils.GridSpacingItemDecoration;
import com.trailaider.app.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gajanand on 25/1/18.
 */

public class ReviewUserProfileActivity extends BaseActivity implements UserProfileView {
    RecyclerView recyclerView, recyclerViewTrek;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private String id;
    private String cuurentUserId;
    private UserProfilePresenter presenter;
    private ImageView imagetViewFriend;
    private TextView textViewName, textViewCity, textViewMutualCount;
    private TabItem tabItemTotalFriend, tabItemMutualFrined;
    private List<FriendModel> list;
    private ReviewFriendListAdapter adapter;
    private TabLayout tabLayout;
    private UserProfileData data;
    private Button buttonAddFriend, buttonMessage;
    private LoginResponseData loginData;
    private List<TrekResponseData> trekList;
    private TrekListAdapter trekAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_profile);
        id = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA).getString("id");
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText("Profile");
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        if (loginData.getId().equalsIgnoreCase(id)) {
            buttonAddFriend.setVisibility(View.GONE);
            buttonMessage.setVisibility(View.GONE);
        }
        getProfile();
        DBHelper.getInstance(this);
    }

    private void getProfile() {
        HashMap<String, String> body = new HashMap<>();
        body.put("user_id", id);
        body.put("current_user_id", loginData.getId());
        presenter.getUserProfile(body);
    }

    @Override
    public void initializePresneter() {
        LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();
        cuurentUserId = loginData.getId();
        presenter = new UserProfilePresenter(this);
        presenter.initialiseView(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initializeView() {
        imagetViewFriend = findViewById(R.id.imageView_friend);
        textViewName = findViewById(R.id.textView_name);
        textViewCity = findViewById(R.id.textView_city);
        tabItemTotalFriend = findViewById(R.id.tab_item1);
        tabItemMutualFrined = findViewById(R.id.tab_item2);
        buttonMessage = findViewById(R.id.button_message);
        textViewMutualCount = findViewById(R.id.textView_count_mutual);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerViewTrek = findViewById(R.id.recycler_view_trek);
        buttonAddFriend = findViewById(R.id.button_add_friend);
        buttonMessage.setOnClickListener(this);
        tabLayout = findViewById(R.id.tab_layout);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTrek.setNestedScrollingEnabled(false);
        recyclerViewTrek.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        trekList = new ArrayList<>();
        buttonAddFriend.setOnClickListener(this);
        adapter = new ReviewFriendListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        trekAdapter = new TrekListAdapter(this, trekList);
        recyclerViewTrek.setAdapter(trekAdapter);
        recyclerViewTrek.addItemDecoration(new SpacesItemDecoration(5));
        tabLayout.addOnTabSelectedListener(listener);
    }


    TabLayout.OnTabSelectedListener listener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (data != null) {
                if (tab.getPosition() == 0) {
                    recyclerViewTrek.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    list.clear();
                    list.addAll(data.getFriends());
                    adapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 1) {
                    recyclerViewTrek.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    list.clear();
                    list.addAll(data.getMutual_friends());
                    adapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 2) {
                    recyclerViewTrek.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    @Override
    public void setUserData(UserProfileData data) {
        if (data != null) {
            this.data = data;
            if (data.getIs_already_friend().equalsIgnoreCase("1") || data.getIs_request_sent().equalsIgnoreCase("1")) {
                buttonAddFriend.setVisibility(View.GONE);
            }
            GlideApp.with(imagetViewFriend).load(data.getUser_image())
                    .placeholder(R.color.colorLightGray).into(imagetViewFriend);
            textViewName.setText(String.format("%s %s", data.getFirstname(), data.getLastname()));
            textViewCity.setText(data.getCity());
            textViewMutualCount.setText(data.getTotal_mutual_friends());
            tabLayout.getTabAt(0).setText(data.getTotal_friend() + " Friend");
            tabLayout.getTabAt(1).setText(data.getTotal_mutual_friends() + " Mutual Friend");
            list.clear();
            list.addAll(data.getFriends());
            trekList.clear();
            trekList.addAll(data.getTreks());
            trekAdapter.notifyDataSetChanged();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.button_add_friend:
                HashMap<String, String> body = new HashMap<>();
                body.put("user_id", loginData.getId());
                body.put("friend_id", id);
                presenter.addFriend(body);
                break;
            case R.id.button_message:
                if (data != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", loginData.getId());
                    bundle.putString("user_image", loginData.getUser_image());
                    bundle.putString("friend_image", data.getUser_image());
                    bundle.putString("friend_id", data.getId());
                    bundle.putString("user_name", data.getFirstname() + " " + data.getLastname());
                    CommonUtils.startActivity(this, ChatActivity.class, bundle, false);
                }
                break;
        }
    }

    @Override
    public void onFriendAdded() {
        buttonAddFriend.setVisibility(View.GONE);
    }
}
