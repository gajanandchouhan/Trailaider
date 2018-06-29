package com.trailaider.app.ui.activity.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.review.ReviewDataModel;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.model.userprofile.UserProfileData;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.chat.ChatActivity;
import com.trailaider.app.ui.activity.review.ReviewDetailsActivity;
import com.trailaider.app.ui.activity.userprofile.ReviewUserProfileActivity;
import com.trailaider.app.ui.fragment.friends.FriendPresenter;
import com.trailaider.app.ui.fragment.friends.FriendView;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<FriendModel> list;
    LoginResponseData loginData;

    public FriendListAdapter(Context mContext, List<FriendModel> list) {
        this.list = list;
        this.mContext = mContext;
        loginData = TrailaiderPreferences.getInstance().getLoginData();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friend_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        GlideApp.with(holder.imageViewFriend).load(list.get(position).getUser_image())
                .placeholder(R.drawable.placeholder).into(holder.imageViewFriend);
        holder.textViewName.setText(String.format("%s %s", list.get(position).getFirstname(), list.get(position).getLastname()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageViewFriend;
        TextView textViewName;
        TextView textViewUnfriend;
        ImageView imageViewChat;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageViewFriend = itemView.findViewById(R.id.imageView_friend);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewUnfriend = itemView.findViewById(R.id.textView_unfriend);
            imageViewChat = itemView.findViewById(R.id.imageView_chat);
            imageViewChat.setOnClickListener(this);
            imageViewFriend.setOnClickListener(this);
            textViewUnfriend.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.textView_unfriend:
                    unFriend(getAdapterPosition());
                    break;
                case R.id.imageView_friend:
                    FriendModel friendModel = list.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putString("id", friendModel.getId());
                    CommonUtils.startActivity(mContext, ReviewUserProfileActivity.class, bundle, false);
                    break;
                case R.id.imageView_chat:
                    FriendModel friendModel1 = list.get(getAdapterPosition());
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("user_id", loginData.getId());
                    bundle1.putString("user_image", loginData.getUser_image());
                    bundle1.putString("friend_image", friendModel1.getUser_image());
                    bundle1.putString("friend_id", friendModel1.getId());
                    bundle1.putString("user_name", friendModel1.getFirstname() + " " + friendModel1.getLastname());
                    CommonUtils.startActivity(mContext, ChatActivity.class, bundle1, false);
                    break;
            }

        }
    }

    private void unFriend(final int adapterPosition) {
        HashMap<String, String> body = new HashMap<>();
        body.put("friend_id", list.get(adapterPosition).getId());
        body.put("user_id", loginData.getId());
        FriendPresenter presenter = new FriendPresenter(mContext);
        final BaseActivity activity = ((FriendActivity) mContext);
        presenter.initialiseView(new FriendView() {
            @Override
            public void onUnfriended() {
                FriendModel friendModel = list.get(adapterPosition);
                list.remove(adapterPosition);
                notifyDataSetChanged();
                ((FriendActivity) mContext).removeLocal(adapterPosition,friendModel,false);
            }

            @Override
            public void onAccepted() {

            }

            @Override
            public void onReject() {

            }

            @Override
            public void showProgress() {
                activity.showProgress();
            }

            @Override
            public void hideProgress() {
                activity.hideProgress();
            }
        });
        presenter.unFriend(body);


    }
}
