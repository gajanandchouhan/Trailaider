package com.trailaider.app.data.model.review;

import java.io.Serializable;

/**
 * Created by gajanand on 23/1/18.
 */

public class ReviewImageModel implements Serializable{
    private String review_image_id;
    private String review_id;
    private String review_image;
    private String created_at;
    private String updated_at;

    public String getReview_image_id() {
        return review_image_id;
    }

    public void setReview_image_id(String review_image_id) {
        this.review_image_id = review_image_id;
    }

    public String getReview_id() {
        return review_id;
    }

    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

    public String getReview_image() {
        return review_image;
    }

    public void setReview_image(String review_image) {
        this.review_image = review_image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
