package com.trailaider.app.data.persistance;

import android.content.Context;

import com.trailaider.app.data.model.DaoMaster;
import com.trailaider.app.data.model.DaoSession;
import com.trailaider.app.data.model.trek.TrekImageModel;
import com.trailaider.app.data.model.trek.TrekResponseData;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gajanandchouhan on 25/5/17.
 */

public class DBHelper {
    private static DBHelper instance;
    private static DaoSession daoSession;

    public DBHelper(Context mContext) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mContext, "trailaider-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static DBHelper getInstance(Context mContext) {
        if (instance == null) {
            instance = new DBHelper(mContext.getApplicationContext());
        }
        return instance;
    }

    public void inserTrekData(TrekResponseData trekTableModel, List<String> list) {
        long insert = daoSession.getTrekResponseDataDao().insert(trekTableModel);
        List<TrekImageModel> imageModels = new ArrayList<>();
        for (String s : list) {
            TrekImageModel imageModel = new TrekImageModel();
            imageModel.setTrek_image(s);
            imageModel.setTrek_image_id(insert);
            imageModels.add(imageModel);
        }
        daoSession.getTrekImageModelDao().insertInTx(imageModels);
    }

    public List<TrekResponseData> getLocalTrekList() {
        return daoSession.getTrekResponseDataDao().loadAll();
    }

    public void deleteTrek(TrekResponseData trekResponseData) {
        daoSession.getTrekResponseDataDao().delete(trekResponseData);
    }
}
