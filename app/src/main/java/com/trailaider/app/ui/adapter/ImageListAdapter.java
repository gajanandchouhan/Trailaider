package com.trailaider.app.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.review.ReviewImageModel;
import com.trailaider.app.ui.activity.review.AddReviewActivity;
import com.trailaider.app.ui.dialog.ImageViewer;

import java.util.List;

/**
 * Created by Divya on 21-11-2017.
 */

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    private static final int VIEW_ITEM = 1;
    private static final int VIEW_FOOTER = 2;
    private final Context mContext;
    private final List<ReviewImageModel> list;
    private String searchAreaImage;

    public ImageListAdapter(Context mContext, List<ReviewImageModel> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review_image, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        GlideApp.with(holder.imageView.getContext()).
                load(list.get(position).getReview_image()).placeholder(R.drawable.placeholder).
                into((holder.imageView));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            new ImageViewer(mContext, list, getAdapterPosition()).show();
        }
    }


}
