package com.trailaider.app.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by gajanand on 15/1/18.
 */
@Entity
public class TrekTableModel {
    @Id(autoincrement = true)
    Long id;
    String trekName;
    String trekType;
    String trekDuration;
    String trekHeight;
    String latidude;
    String longitude;
    String status;
    String address;
    @Generated(hash = 832978112)
    public TrekTableModel(Long id, String trekName, String trekType,
            String trekDuration, String trekHeight, String latidude,
            String longitude, String status, String address) {
        this.id = id;
        this.trekName = trekName;
        this.trekType = trekType;
        this.trekDuration = trekDuration;
        this.trekHeight = trekHeight;
        this.latidude = latidude;
        this.longitude = longitude;
        this.status = status;
        this.address = address;
    }
    @Generated(hash = 1174689390)
    public TrekTableModel() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTrekName() {
        return this.trekName;
    }
    public void setTrekName(String trekName) {
        this.trekName = trekName;
    }
    public String getTrekType() {
        return this.trekType;
    }
    public void setTrekType(String trekType) {
        this.trekType = trekType;
    }
    public String getTrekDuration() {
        return this.trekDuration;
    }
    public void setTrekDuration(String trekDuration) {
        this.trekDuration = trekDuration;
    }
    public String getTrekHeight() {
        return this.trekHeight;
    }
    public void setTrekHeight(String trekHeight) {
        this.trekHeight = trekHeight;
    }
    public String getLatidude() {
        return this.latidude;
    }
    public void setLatidude(String latidude) {
        this.latidude = latidude;
    }
    public String getLongitude() {
        return this.longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
