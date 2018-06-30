package com.trailaider.app.ui.activity.inbox;

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
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.model.userprofile.UserProfileData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.chat.ChatActivity;
import com.trailaider.app.ui.activity.userprofile.ReviewUserProfileActivity;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class InboxListAdapter extends RecyclerView.Adapter<InboxListAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<MessageResponseData> list;
    private final LoginResponseData loginData;

    public InboxListAdapter(Context mContext, List<MessageResponseData> list) {
        this.list = list;
        this.mContext = mContext;
        loginData = TrailaiderPreferences.getInstance().getLoginData();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_inbox_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        MessageResponseData messageResponseData = list.get(position);
        GlideApp.with(holder.imageViewFriend).load(messageResponseData.getUser_details().getUser_image())
                .placeholder(R.drawable.placeholder).into(holder.imageViewFriend);
        holder.textViewName.setText(String.format("%s %s", messageResponseData.getUser_details().getFirstname(), messageResponseData.getUser_details().getLastname()));
        holder.textViewMsg.setText(messageResponseData.getMessage());
        holder.textViewTime.setText(CommonUtils.getTimeLineDifference(messageResponseData.getCreated_at()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTime;
        TextView textViewMsg;
        ImageView imageViewFriend;
        TextView textViewName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageViewFriend = itemView.findViewById(R.id.imageView_friend);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewMsg = itemView.findViewById(R.id.textView_msg);
            textViewTime = itemView.findViewById(R.id.textView_time);
        }

        @Override
        public void onClick(View view) {
            UserProfileData user_details = list.get(getAdapterPosition()).getUser_details();
            Bundle bundle = new Bundle();
            bundle.putString("user_id", loginData.getId());
            bundle.putString("user_image", loginData.getUser_image());
            bundle.putString("friend_image", user_details.getUser_image());
            bundle.putString("friend_id", user_details.getId());
            bundle.putString("user_name", user_details.getFirstname() + " " + user_details.getLastname());
            CommonUtils.startActivity(mContext, ChatActivity.class, bundle, false);
        }
    }


}
