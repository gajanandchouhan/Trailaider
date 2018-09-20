package com.trailaider.app.data.model.trek;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.trailaider.app.data.model.DaoSession;

/**
 * Created by gajanand on 20/1/18.
 */
@Entity
public class TrekResponseData {
    @Id(autoincrement = true)
    Long localId;
    private String trek_id;
    private String user_id;
    private String trek_name;
    private String trek_type;
    private String trek_duration;
    private String trek_height;
    private String latitude;
    private String longitude;
    private String address;
    private String trek_status;
    private String created_at;
    private String updated_at;
    private String trek_unit;
    @ToMany(referencedJoinProperty = "trek_image_id")
    private List<TrekImageModel> trek_images;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1684948043)
    private transient TrekResponseDataDao myDao;
    @Generated(hash = 856207612)
    public TrekResponseData(Long localId, String trek_id, String user_id, String trek_name,
            String trek_type, String trek_duration, String trek_height, String latitude,
            String longitude, String address, String trek_status, String created_at, String updated_at,
            String trek_unit) {
        this.localId = localId;
        this.trek_id = trek_id;
        this.user_id = user_id;
        this.trek_name = trek_name;
        this.trek_type = trek_type;
        this.trek_duration = trek_duration;
        this.trek_height = trek_height;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.trek_status = trek_status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.trek_unit = trek_unit;
    }
    @Generated(hash = 1755300595)
    public TrekResponseData() {
    }
    public Long getLocalId() {
        return this.localId;
    }
    public void setLocalId(Long localId) {
        this.localId = localId;
    }
    public String getTrek_id() {
        return this.trek_id;
    }
    public void setTrek_id(String trek_id) {
        this.trek_id = trek_id;
    }
    public String getUser_id() {
        return this.user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getTrek_name() {
        return this.trek_name;
    }
    public void setTrek_name(String trek_name) {
        this.trek_name = trek_name;
    }
    public String getTrek_type() {
        return this.trek_type;
    }
    public void setTrek_type(String trek_type) {
        this.trek_type = trek_type;
    }
    public String getTrek_duration() {
        return this.trek_duration;
    }
    public void setTrek_duration(String trek_duration) {
        this.trek_duration = trek_duration;
    }
    public String getTrek_height() {
        return this.trek_height;
    }
    public void setTrek_height(String trek_height) {
        this.trek_height = trek_height;
    }
    public String getLatitude() {
        return this.latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return this.longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTrek_status() {
        return this.trek_status;
    }
    public void setTrek_status(String trek_status) {
        this.trek_status = trek_status;
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
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1715430413)
    public List<TrekImageModel> getTrek_images() {
        if (trek_images == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TrekImageModelDao targetDao = daoSession.getTrekImageModelDao();
            List<TrekImageModel> trek_imagesNew = targetDao
                    ._queryTrekResponseData_Trek_images(localId);
            synchronized (this) {
                if (trek_images == null) {
                    trek_images = trek_imagesNew;
                }
            }
        }
        return trek_images;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2026714254)
    public synchronized void resetTrek_images() {
        trek_images = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 806777469)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTrekResponseDataDao() : null;
    }
    public String getTrek_unit() {
        return this.trek_unit;
    }
    public void setTrek_unit(String trek_unit) {
        this.trek_unit = trek_unit;
    }

}
