package com.xumengran.db;

import android.content.Context;

import com.xumengran.database.greenDao.db.StudentDao;
import com.xumengran.myapplication.Student;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2020/07/10.
 */

public class StudentDaoOpe {


    //增加数据
    public static void insertData(Context context, Student stu) {

        DBManager.getDaoSession(context).getStudentDao().insert(stu);
    }

    /**
     * 将实体数据将事务添加到数据库中去
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<Student> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DBManager.getDaoSession(context).getStudentDao().insertInTx(list);
    }

    /**
     * 添加到数据库中去如果存在则覆盖
     * @param context
     * @param student
     */
    public static void saveData(Context context, Student student) {
        DBManager.getDaoSession(context).getStudentDao().save(student);
    }

    /**
     * 删除数据
     * @param context
     * @param student
     */
    public static void deleteData(Context context, Student student) {
        DBManager.getDaoSession(context).getStudentDao().delete(student);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DBManager.getDaoSession(context).getStudentDao().deleteByKey(id);

    }
    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DBManager.getDaoSession(context).getStudentDao().deleteAll();
    }

    /**
     * 查询所有数据
     * @param context
     * @return
     */
    public static List<Student> queryAll(Context context) {
        QueryBuilder<Student> builder = DBManager.getDaoSession(context).getStudentDao().queryBuilder();

        return builder.build().list();
    }
    /**
     * 根据id，其他的字段类似
     *
     * @param context
     * @param id
     * @return
     */
    public static List<Student> queryForId(Context context, long id) {
        QueryBuilder<Student> builder = DBManager.getDaoSession(context).getStudentDao().queryBuilder();
        /**
         * 返回当前id的数据集合,当然where(这里面可以有多组，做为条件);
         * 这里build.list()；与where(StudentDao.Properties.Id.eq(id)).list()结果是一样的；
         * 在QueryBuilder类中list()方法return build().list();
         *
         */
        // Query<Student> build = builder.where(StudentDao.Properties.Id.eq(id)).build();
        // List<Student> list = build.list();
        return builder.where(StudentDao.Properties.Id.eq(id)).list();
    }

}
