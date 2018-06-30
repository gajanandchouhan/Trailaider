package com.trailaider.app.ui.activity.review;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.userprofile.FriendModel;
import com.trailaider.app.ui.activity.friend.FriendListAdapter;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class ReviewFriendListAdapter extends RecyclerView.Adapter<ReviewFriendListAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<FriendModel> list;

    public ReviewFriendListAdapter(Context mContext, List<FriendModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review_friend_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        FriendModel friendModel = list.get(position);
        holder.textViewName.setText(String.format("%s %s", friendModel.getFirstname(), friendModel.getLastname()));
//        holder.textViewCity.setText(friendModel.getCity());
        GlideApp.with(holder.imageView).load(friendModel.getUser_image()).placeholder(R.drawable.placeholder).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewCity;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewName = itemView.findViewById(R.id.textView_name);
//            textViewCity = itemView.findViewById(R.id.textView_city);
            imageView = itemView.findViewById(R.id.imageView_friend);
        }

        @Override
        public void onClick(View view) {
        }
    }


}
