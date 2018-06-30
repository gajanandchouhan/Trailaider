package com.trailaider.app.ui.fragment.debitpoint;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trailaider.app.R;
import com.trailaider.app.ui.activity.review.ReviewDetailsActivity;
import com.trailaider.app.utils.CommonUtils;


/**
 * Created by Divya on 21-11-2017.
 */

public class DebitPointListAdapter extends RecyclerView.Adapter<DebitPointListAdapter.ItemViewHolder> {

    private final Context mContext;

    public DebitPointListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_debit_point, parent, false);
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
