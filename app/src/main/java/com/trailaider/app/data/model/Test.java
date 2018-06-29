package com.trailaider.app.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by gajanand on 15/1/18.
 */
@Entity
public class Test {
    @Id(autoincrement = true)
    long id;

    @Generated(hash = 1285100756)
    public Test(long id) {
        this.id = id;
    }

    @Generated(hash = 372557997)
    public Test() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
