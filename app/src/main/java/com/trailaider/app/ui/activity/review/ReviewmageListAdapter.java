package com.trailaider.app.ui.activity.review;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.ui.activity.trek.AddTrekActivity;

import java.util.List;

/**
 * Created by Divya on 21-11-2017.
 */

public class ReviewmageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_ITEM = 1;
    private static final int VIEW_FOOTER = 2;
    private final Context mContext;
    private final List<String> list;
    private String searchAreaImage;

    public ReviewmageListAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_review_image, parent, false);
            return new ViewHolder(itemView);
        } else if (viewType == VIEW_FOOTER) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_review_image, parent, false);
            return new FooterViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ViewHolder) {

            GlideApp.with(((ViewHolder) holder).imageView.getContext()).
                    load(list.get(position)).placeholder(R.drawable.plus).
                    into(((ViewHolder) holder).imageView);


        } else if (holder instanceof FooterViewHolder) {
            ((FooterViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mContext instanceof AddReviewActivity) {
                        ((AddReviewActivity) mContext).chekcPermisionAndOpenPicker();
                    }
                    else if (mContext instanceof AddTrekActivity){
                        ((AddTrekActivity) mContext).chekcPermisionAndOpenPicker();
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public int getItemViewType(int position) {

        if (position == list.size()) {
            return VIEW_FOOTER;
        }
        return VIEW_ITEM;
    }
}
