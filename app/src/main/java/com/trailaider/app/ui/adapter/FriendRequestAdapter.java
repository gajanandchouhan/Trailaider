package com.trailaider.app.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.friend.FriendActivity;
import com.trailaider.app.ui.fragment.friends.FriendPresenter;
import com.trailaider.app.ui.fragment.friends.FriendView;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<FriendModel> list;

    public FriendRequestAdapter(Context mContext, List<FriendModel> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friend_request, parent, false);
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
        TextView textViewAccept;
        TextView textViewReject;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageViewFriend = itemView.findViewById(R.id.imageView_friend);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewAccept = itemView.findViewById(R.id.textView_accept);
            textViewReject = itemView.findViewById(R.id.textView_reject);
            textViewReject.setOnClickListener(this);
            textViewAccept.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.textView_accept:
                    acceptRequest(getAdapterPosition());
                    break;
                case R.id.textView_reject:
                    rejectRequest(getAdapterPosition());
                    break;
            }
//            FriendModel friendModel = list.get(getAdapterPosition());
//            Bundle bundle = new Bundle();
//            bundle.putString("id", friendModel.getId());
//            CommonUtils.startActivity(mContext, ReviewUserProfileActivity.class, bundle, false);
        }
    }

    private void acceptRequest(final int adapterPosition) {
        LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();
        HashMap<String, String> body = new HashMap<>();
        body.put("request_id", list.get(adapterPosition).getRequest_id());
        body.put("user_id", loginData.getId());
        FriendPresenter presenter = new FriendPresenter(mContext);
        final BaseActivity activity = ((FriendActivity) mContext);
        presenter.initialiseView(new FriendView() {
            @Override
            public void onUnfriended() {

            }

            @Override
            public void onAccepted() {
                FriendModel friendModel = list.get(adapterPosition);
                list.remove(adapterPosition);
                notifyDataSetChanged();
                ((FriendActivity) mContext).removeLocal(adapterPosition, friendModel,true);

            }

            @Override
            public void onReject() {
                FriendModel friendModel = list.get(adapterPosition);
                list.remove(adapterPosition);
                notifyDataSetChanged();
                ((FriendActivity) mContext).removeLocal(adapterPosition, friendModel,false);
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
        presenter.acceptFriend(body);

    }


    private void rejectRequest(final int adapterPosition) {
        LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();
        HashMap<String, String> body = new HashMap<>();
        body.put("request_id", list.get(adapterPosition).getRequest_id());
        body.put("user_id", loginData.getId());
        FriendPresenter presenter = new FriendPresenter(mContext);
        final BaseActivity activity = ((FriendActivity) mContext);
        presenter.initialiseView(new FriendView() {
            @Override
            public void onUnfriended() {

            }

            @Override
            public void onAccepted() {

            }

            @Override
            public void onReject() {
                list.remove(adapterPosition);
                notifyDataSetChanged();
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
        presenter.reject(body);

    }

}
