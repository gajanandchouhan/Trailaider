package com.trailaider.app.ui.fragment.review;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.model.review.ReviewDataModel;
import com.trailaider.app.ui.activity.review.ReviewDetailsActivity;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ItemViewHolder> {

    private final Context mContext;
    private List<ReviewDataModel> list;
    ReviewFrament frament;


    public ReviewListAdapter(Context mContext, List<ReviewDataModel> list, ReviewFrament frament) {
        this.mContext = mContext;
        this.list = list;
        this.frament = frament;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ReviewDataModel reviewDataModel = list.get(position);
        if (reviewDataModel.getAvg_rating() != null && !reviewDataModel.getAvg_rating().isEmpty())
            holder.ratingBar.setRating(Float.parseFloat(reviewDataModel.getAvg_rating()));
        else
            holder.ratingBar.setRating(0);
        holder.textViewRate.setText(reviewDataModel.getAvg_rating());
        holder.textViewReviewName.setText(reviewDataModel.getReview_title());
        holder.textViewCount.setText(String.format("%s Users", reviewDataModel.getTotal_rating()));
        holder.reviewComment.setText(reviewDataModel.getComment());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewReviewName;
        TextView reviewComment;
        TextView textViewCount;
        TextView textViewRate;
        RatingBar ratingBar;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewReviewName = itemView.findViewById(R.id.textView_name);
            reviewComment = itemView.findViewById(R.id.textView_review);
            textViewRate = itemView.findViewById(R.id.textView_rate);
            ratingBar = itemView.findViewById(R.id.rating_bar);
            textViewCount = itemView.findViewById(R.id.textView_review_count);
            LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
            stars.getDrawable(0).setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_ATOP);
        }

        @Override
        public void onClick(View view) {
            ReviewDataModel reviewDataModel = list.get(getAdapterPosition());
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", reviewDataModel);
            Intent intent = new Intent(mContext, ReviewDetailsActivity.class);
            intent.putExtra(ConstantLib.KEY_BUNDLE_EXTRA, bundle);
            frament.startActivityForResult(intent, 105);
        }
    }


}
