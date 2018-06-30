package com.trailaider.app.ui.activity.chat;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.chat.MessageResponseData;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class ChatListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final List<MessageResponseData> list;
    private final int VIEW_SELF = 1;
    private final int VIEW_OTHER = 2;
    private final String userImage;
    private final String friendImage;
    private final String userId;

    public ChatListAdapter(Context mContext, List<MessageResponseData> list, String userImage, String friendImage, String userIds) {
        this.list = list;
        this.mContext = mContext;
        this.userImage = userImage;
        this.friendImage = friendImage;
        this.userId = userIds;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_OTHER) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_list, parent, false);
            return new ItemViewHolder(itemView);
        } else if (viewType == VIEW_SELF) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_list_self, parent, false);
            return new ItemViewHolderSelf(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            GlideApp.with(itemViewHolder.imageViewOther).load(friendImage)
                    .placeholder(R.drawable.placeholder).into(itemViewHolder.imageViewOther);
            itemViewHolder.textViewOther.setText(list.get(position).getMessage());
            itemViewHolder.textViewTime.setText(CommonUtils.getMessageTime(list.get(position).getCreated_at()));
        } else if (holder instanceof ItemViewHolderSelf) {
            ItemViewHolderSelf itemViewHolderSelf = (ItemViewHolderSelf) holder;
            GlideApp.with(itemViewHolderSelf.imageViewSelf).load(userImage)
                    .placeholder(R.drawable.placeholder).into(itemViewHolderSelf.imageViewSelf);
            itemViewHolderSelf.textViewSelf.setText(list.get(position).getMessage());
            itemViewHolderSelf.textViewTime.setText(CommonUtils.getMessageTime(list.get(position).getCreated_at()));
        }
       /* GlideApp.with(holder.imageViewFriend).load(list.get(position).getUser_image())
                .placeholder(R.drawable.placeholder).into(holder.imageViewFriend);
        holder.textViewName.setText(String.format("%s %s", list.get(position).getFirstname(), list.get(position).getLastname()));*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getFrom_id().equalsIgnoreCase(userId)) {
            return VIEW_SELF;
        }
        return VIEW_OTHER;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textViewTime;
        ImageView imageViewOther;
        TextView textViewOther;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageViewOther = itemView.findViewById(R.id.imageView_other);
            textViewOther = itemView.findViewById(R.id.textView_message_other);
            textViewTime = itemView.findViewById(R.id.textView_time);
            textViewOther.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("message", textViewOther.getText());
                    cm.setPrimaryClip(clipData);
                    Toast.makeText(mContext, "Copied to clipboard", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        @Override
        public void onClick(View view) {
//            FriendModel friendModel = list.get(getAdapterPosition());
//            Bundle bundle = new Bundle();
//            bundle.putString("id", friendModel.getId());
//            CommonUtils.startActivity(mContext, ReviewUserProfileActivity.class, bundle, false);
        }
    }

    class ItemViewHolderSelf extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageViewSelf;
        TextView textViewSelf;
        TextView textViewTime;

        public ItemViewHolderSelf(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageViewSelf = itemView.findViewById(R.id.imageView_self);
            textViewSelf = itemView.findViewById(R.id.textView_message_self);
            textViewTime = itemView.findViewById(R.id.textView_time);
            textViewSelf.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("message", textViewSelf.getText());
                    cm.setPrimaryClip(clipData);
                    Toast.makeText(mContext, "Copied to clipboard", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        @Override
        public void onClick(View view) {
//            FriendModel friendModel = list.get(getAdapterPosition());
//            Bundle bundle = new Bundle();
//            bundle.putString("id", friendModel.getId());
//            CommonUtils.startActivity(mContext, ReviewUserProfileActivity.class, bundle, false);
        }
    }


}
