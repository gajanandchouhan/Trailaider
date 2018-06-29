package com.trailaider.app.data.model.trek;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by gajanand on 11/2/18.
 */
@Entity
public class TrekImageModel {
    private Long trek_image_id;
    private String trek_id;
    private String trek_image;
    private String created_at;
    private String updated_at;
    @Generated(hash = 271295402)
    public TrekImageModel(Long trek_image_id, String trek_id, String trek_image,
            String created_at, String updated_at) {
        this.trek_image_id = trek_image_id;
        this.trek_id = trek_id;
        this.trek_image = trek_image;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    @Generated(hash = 1437361988)
    public TrekImageModel() {
    }
    public Long getTrek_image_id() {
        return this.trek_image_id;
    }
    public void setTrek_image_id(Long trek_image_id) {
        this.trek_image_id = trek_image_id;
    }
    public String getTrek_id() {
        return this.trek_id;
    }
    public void setTrek_id(String trek_id) {
        this.trek_id = trek_id;
    }
    public String getTrek_image() {
        return this.trek_image;
    }
    public void setTrek_image(String trek_image) {
        this.trek_image = trek_image;
    }
    public String getCreated_at() {
        return this.created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getUpdated_at() {
        return this.updated_at;
    }
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
