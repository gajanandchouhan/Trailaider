package com.trailaider.app.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;

import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<String> list;

    public ListItemAdapter(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewMessage;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewMessage = itemView.findViewById(R.id.text_view_msg);
        }

        @Override
        public void onClick(View view) {
        }
    }


}
