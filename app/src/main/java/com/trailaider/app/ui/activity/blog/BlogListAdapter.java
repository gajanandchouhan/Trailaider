package com.trailaider.app.ui.activity.blog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.chat.MessageResponseData;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.userprofile.UserProfileData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.chat.ChatActivity;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List list;
    private final LoginResponseData loginData;

    public BlogListAdapter(Context mContext, List list) {
        this.list = list;
        this.mContext = mContext;
        loginData = TrailaiderPreferences.getInstance().getLoginData();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blog_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }


}
