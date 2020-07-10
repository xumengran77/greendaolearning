package com.xumengran.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.xumengran.database.greenDao.db.DaoMaster;
import com.xumengran.database.greenDao.db.DaoSession;

/**
 * Created by Administrator on 2020/07/10.
 */

public class DBManager {
    // 是否加密
    public static final boolean ENCRYPTED = true;

    private static final String DB_NAME = "test.db";
    private static DBManager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private Context mContext;


    private DBManager(Context context) {
        this.mContext = context;
        // 初始化数据库信息
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }
    public static DBManager getInstance(Context context) {
        if (null == mDbManager) {
            synchronized (DBManager.class) {
                if (null == mDbManager) {
                    mDbManager = new DBManager(context);
                }
            }
        }
        return mDbManager;
    }

    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }

        return mDevOpenHelper.getWritableDatabase();
    }

    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DBManager.class) {
                if (null == mDaoMaster) {
                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
                }
            }
        }
        return mDaoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DBManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }
}
