package com.trailaider.app.ui.activity.myrank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trailaider.app.R;


/**
 * Created by Divya on 21-11-2017.
 */

public class MyRankAdapter extends RecyclerView.Adapter<MyRankAdapter.ItemViewHolder> {

    private final Context mContext;

    public MyRankAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_rank, parent, false);
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
